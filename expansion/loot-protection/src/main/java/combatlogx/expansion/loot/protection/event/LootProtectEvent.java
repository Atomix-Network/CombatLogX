package combatlogx.expansion.loot.protection.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Event called when loot from an entity should be protected.
 */
public final class LootProtectEvent extends Event {
    private static final HandlerList HANDLER_LIST;

    static {
        HANDLER_LIST = new HandlerList();
    }

    /**
     * LivingEntity that was killed.
     */
    private final LivingEntity entity;
    /**
     * Loot that will be protected.
     */
    private final List<ItemStack> loot;

    public LootProtectEvent(LivingEntity entity, List<ItemStack> loot) {
        this.entity = entity;
        this.loot = loot;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return getHandlerList();
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public List<ItemStack> getLoot() {
        return loot;
    }
}
