package io.github.jaydy0102

import org.bukkit.entity.Warden
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import kotlin.random.Random.Default.nextInt

class DeathListener : Listener {
    @EventHandler
    fun onEntityDeath(event: EntityDeathEvent) {
        val entity = event.entity
        val loc = entity.location
        val item = Recipe.wardenHeartItemStack
        if (entity is Warden) {
            if (nextInt(3)==0) {
                loc.world.dropItem(loc, item)
            }
        }
    }
}