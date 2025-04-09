package io.github.jaydy0102

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.EquipmentSlotGroup
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.LeatherArmorMeta

abstract class  Recipe {
    companion object {
        val endermanSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Enderman's Sword", TextColor.color(170,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(3) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Enderman_Sword","Enderman_Sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val witherLongSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Wither's Longsword", TextColor.color(0,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(4) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE, AttributeModifier(NamespacedKey("Wither_Sword","Wither_Sword"), 1.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND)) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Wither_Sword","Wither_Sword"), 6.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val hellspickaxeItemStack = ItemStack(Material.NETHERITE_PICKAXE).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Hell's Pickaxe", TextColor.color(170,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val elderGuardiansThornItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Elder Guardian's Thorn", TextColor.color(0,170,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(5) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Elder_Guardian_Thorn","Elder_Guardian_Thorn"), 11.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val shulkSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Shulk Sword", TextColor.color(255,85,255))) }
            itemMeta = itemMeta.apply { setCustomModelData(6) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Sculk_Sword","Sculk_Sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val roseSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Rose Sword", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(7) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Rose_Sword","Rose_Sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val iceSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Ice Sword", TextColor.color(0,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(8) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Ice_Sword","Ice_Sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val piglinsArmorItemStack: ItemStack = ItemStack(Material.LEATHER_CHESTPLATE).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Pligin's Chestplate", TextColor.color(170,0,0)))
                setCustomModelData(2)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("Piglin_Chestplate","Piglin_Chestplate"),7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("Piglin_Chestplate","Piglin_Chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("Piglin_Chestplate","Piglin_Chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setColor(Color.fromRGB(0, 0, 255))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val flyingChickenPantsItemStack: ItemStack = ItemStack(Material.LEATHER_LEGGINGS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(255,255,255)))
                setCustomModelData(1)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("Flying_Chicken_Pants","Flying_Chicken_Pants"),5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.GRAVITY,AttributeModifier(NamespacedKey("Flying_Chicken_Pants","Flying_Chicken_Pants"),0.05, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setColor(Color.fromRGB(255, 0, 0))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(272)
            }
        }
        val anvilPantsItemStack: ItemStack = ItemStack(Material.LEATHER_LEGGINGS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(170,170,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("Hardened_Steel_Greaves","Hardened_Steel_Greaves"),8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("Hardened_Steel_Greaves","Hardened_Steel_Greaves"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("Hardened_Steel_Greaves","Hardened_Steel_Greaves"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setColor(Color.fromRGB(0, 0, 255))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(784)
            }
        }
        val oceansBootsItemStack: ItemStack = ItemStack(Material.LEATHER_BOOTS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(80,80,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.FEET)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("Ocean_Pact","Ocean_Pact"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.SAFE_FALL_DISTANCE, AttributeModifier(NamespacedKey("Ocean_Pact","Ocean_Pact"),512.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                lore(listOf(Component.text("Protects User From Heights", TextColor.color(255,255,255))))
                setColor(Color.fromRGB(0, 0, 255))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
    }
}