@file:Suppress("DEPRECATION")

package io.github.jaydy0102

import io.papermc.paper.datacomponent.item.Fireworks
import org.bukkit.*
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object EquipmentEffects : Runnable {
    override fun run() {
            equipmentEffects()
    }

    private fun equipmentEffects() {
        Bukkit.getOnlinePlayers().forEach {
            val player = it.player as Player
            val loc = player.location
            val inventory: PlayerInventory = player.inventory
            val chestplate = inventory.chestplate
            val boots = inventory.boots
            val hand = inventory.itemInMainHand
            val chestmeta = chestplate?.itemMeta
            val bootsmeta = boots?.itemMeta
            val handmeta = hand.itemMeta
            val item = inventory.itemInMainHand
            val meta = item.itemMeta
            if (chestmeta != null) {
                if (chestmeta.hasCustomModelData()) {
                    if (chestmeta.customModelData == 2) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20,0,true,true))
                    }
                    if (chestplate.type == (Material.ELYTRA)) {
                        if (player.isGliding) {
                            if (hand.isSimilar(Recipe.fireworkItemStack)) {
                                if (player.velocity.length() < 1.5) {
                                    val boost = player.location.direction.multiply(0.5)
                                    player.velocity = player.velocity.add(boost)
                                }
                                player.spawnParticle(Particle.FLAME, loc, 20, 0.1, 0.1, 0.1, 0.1)
                                player.playSound(player,Sound.ITEM_FIRECHARGE_USE,SoundCategory.PLAYERS,1.0F,1.0F)
                            }
                        }
                        player.addPotionEffect(PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20,0,true,true))
                    }
                }
            }
            if (bootsmeta != null) {
                if (bootsmeta.hasCustomModelData()) {
                    if (bootsmeta.customModelData == 2) {
                        player.addPotionEffect(PotionEffect(PotionEffectType.DOLPHINS_GRACE, 20,0,true,true))
                        player.addPotionEffect(PotionEffect(PotionEffectType.CONDUIT_POWER, 20,0,true,true))
                    }
                }
            }
            if (handmeta != null) {
                if (player.itemInHand.type == Material.NETHERITE_PICKAXE) {
                    if (handmeta.hasCustomModelData()) {
                        if (meta?.customModelData == 1) {
                            player.addPotionEffect(PotionEffect(PotionEffectType.HASTE, 20, 1, true, true))
                        }
                    }
                }
            }
        }
    }
}