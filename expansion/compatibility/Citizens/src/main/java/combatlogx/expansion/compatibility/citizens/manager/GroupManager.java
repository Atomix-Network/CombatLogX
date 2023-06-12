package combatlogx.expansion.compatibility.citizens.manager;

import com.sxtanna.atomix.player.PlayerData;
import com.sxtanna.atomix.plugin.xAtomixPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class GroupManager {
    private final xAtomixPlugin sxAtomix;

    public GroupManager() {
        sxAtomix = JavaPlugin.getPlugin(xAtomixPlugin.class);
    }

    public PlayerData.GroupData getGroup(Player player) {
        return sxAtomix.getBase().getPlayerModule().get(player.getUniqueId()).getGroup();
    }
}
