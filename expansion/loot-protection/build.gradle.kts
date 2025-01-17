import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.net.URI

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("maven-publish")
}

publishing {
    repositories {
        maven("https://nexus.sirblobman.xyz/public/") {
            credentials {
                username = rootProject.ext.get("mavenUsername") as String
                password = rootProject.ext.get("mavenPassword") as String
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.sirblobman.combatlogx.expansion"
            artifactId = "loot-protection"
            version = rootProject.ext.get("apiVersion") as String
            from(components["java"])
        }
    }
}

repositories {
    maven {
        url = URI("https://mvn.lumine.io/repository/maven-public/")
    }
}

dependencies {
    implementation("net.jodah:expiringmap:0.5.10")
    compileOnly("io.lumine:Mythic-Dist:5.2.1")
}

tasks {
    named<Jar>("jar") {
        enabled = false
    }

    named<ShadowJar>("shadowJar") {
        archiveClassifier.set(null as String?)
        val expansionName = findProperty("expansion.name") ?: project.name
        archiveFileName.set("$expansionName.jar")

        relocate("net.jodah.expiringmap", "combatlogx.expansion.loot.protection.expiringmap")
    }

    build {
        dependsOn(shadowJar)
    }
}

