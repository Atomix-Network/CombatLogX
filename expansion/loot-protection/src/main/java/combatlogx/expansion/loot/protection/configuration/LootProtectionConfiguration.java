package combatlogx.expansion.loot.protection.configuration;

import org.jetbrains.annotations.NotNull;

import org.bukkit.configuration.ConfigurationSection;

import com.github.sirblobman.api.configuration.IConfigurable;

import java.util.ArrayList;
import java.util.List;

public final class LootProtectionConfiguration implements IConfigurable {
    private int lootProtectionTime;
    private int messageCooldown;
    private boolean onlyProtectAfterLog;
    private boolean returnVoidItems;
    private List<String> mobWhitelist;

    public LootProtectionConfiguration() {
        this.lootProtectionTime = 30;
        this.messageCooldown = 30;
        this.onlyProtectAfterLog = false;
        this.returnVoidItems = true;
        this.mobWhitelist = new ArrayList<>();
    }

    @Override
    public void load(@NotNull ConfigurationSection config) {
        setLootProtectionTime(config.getInt("loot-protection-time", 30));
        setMessageCooldown(config.getInt("message-cooldown", 30));
        setOnlyProtectAfterLog(config.getBoolean("only-protect-after-log", false));
        setReturnVoidItems(config.getBoolean("return-void-items", true));
        setMobWhitelist(config.getStringList("mob-whitelist"));
    }

    public int getLootProtectionTime() {
        return this.lootProtectionTime;
    }

    public void setLootProtectionTime(int lootProtectionTime) {
        this.lootProtectionTime = lootProtectionTime;
    }

    public int getMessageCooldown() {
        return this.messageCooldown;
    }

    public void setMessageCooldown(int messageCooldown) {
        this.messageCooldown = messageCooldown;
    }

    public boolean isOnlyProtectAfterLog() {
        return this.onlyProtectAfterLog;
    }

    public void setOnlyProtectAfterLog(boolean onlyProtectAfterLog) {
        this.onlyProtectAfterLog = onlyProtectAfterLog;
    }

    public List<String> getMobWhitelist() {
        return mobWhitelist;
    }

    public void setMobWhitelist(List<String> mobWhitelist) {
        this.mobWhitelist = mobWhitelist;
    }

    public boolean isReturnVoidItems() {
        return this.returnVoidItems;
    }

    public void setReturnVoidItems(boolean returnVoidItems) {
        this.returnVoidItems = returnVoidItems;
    }
}
