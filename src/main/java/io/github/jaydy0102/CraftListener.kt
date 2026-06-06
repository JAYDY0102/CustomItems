package io.github.jaydy0102

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

class CraftListener : Listener {
    @EventHandler
    fun onCraft(event: CraftItemEvent) {
        val player = event.whoClicked as Player
        val playerName = player.name
        val result = event.recipe.result
        if (result.isSimilar(Recipe.weightedAxeItemStack)){
            if (ConfigManager.craftedAxe) {
                event.isCancelled = true
            } else {
                CustomItems.instance.config.set("craftedAxe", true)
                CustomItems.instance.saveConfig()
                CustomItems.instance.server.sendMessage(Component.text("$playerName crafted the Weighted axe!", NamedTextColor.YELLOW))
            }
        }
    }
}