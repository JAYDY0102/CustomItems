package io.github.jaydy0102

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
            if (CustomItems.instance.craftlist.contains(playerName)) {
                event.isCancelled = true
            } else {
                CustomItems.instance.craftlist.add(playerName)
            }
        }
    }
}