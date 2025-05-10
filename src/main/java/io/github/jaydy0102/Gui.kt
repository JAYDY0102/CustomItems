package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

class Gui {
    companion object {
        val testInventory: Inventory = Bukkit.createInventory(null, 54)
        init {
            initializeItems()
        }
        fun initializeItems() {
            val items = listOf(
                0 to Recipe.chocolateItemStack,
                1 to Recipe.augmentedStrengthPotionItemStack,
                2 to Recipe.wardenHeartItemStack,
                3 to Recipe.enhancedGoldenAppleItemStack,
                4 to Recipe.leftWingItemStack,
                5 to Recipe.rightWingItemStack,
                6 to Recipe.fireworkItemStack,
                7 to Recipe.fuseItemStack,
                8 to Recipe.netherCoreItemStack,
                9 to Recipe.endermanSwordItemStack,
                10 to Recipe.witherLongSwordItemStack,
                11 to Recipe.elderGuardiansThornItemStack,
                12 to Recipe.shulkSwordItemStack,
                13 to Recipe.roseSwordItemStack,
                14 to Recipe.iceSwordItemStack,
                18 to Recipe.weightedAxeItemStack,
                19 to Recipe.hellspickaxeItemStack,
                27 to Recipe.endCrownItemStack,
                28 to Recipe.wardensArmorItemStack,
                29 to Recipe.piglinsArmorItemStack,
                30 to Recipe.upgradedElytraItemStack,
                36 to Recipe.flyingChickenPantsItemStack,
                37 to Recipe.anvilPantsItemStack,
                45 to Recipe.wardensBootsItemStack,
                46 to Recipe.oceansBootsItemStack
            )

            items.forEach { (slot, item) ->
                testInventory.setItem(slot, item)
            }
        }
    }
}