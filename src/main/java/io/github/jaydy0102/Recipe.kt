package io.github.jaydy0102

import io.papermc.paper.datacomponent.item.Equippable
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.EquipmentSlotGroup
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ArmorMeta
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.ItemMeta

abstract class  Recipe {
    companion object {
        val wardenHeartItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Warden's Heart", TextColor.color(255,85,255))) }
            itemMeta = itemMeta.apply { setCustomModelData(6) }
        }
        val endermanSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Enderman's Sword", TextColor.color(170,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(3) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("enderman_sword","enderman_sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val witherLongSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Wither's Longsword", TextColor.color(0,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(4) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE, AttributeModifier(NamespacedKey("wither_sword","wither_sword"), 1.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND)) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("wither_sword","wither_sword"), 6.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val hellspickaxeItemStack = ItemStack(Material.NETHERITE_PICKAXE).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Hell's Pickaxe", TextColor.color(170,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val elderGuardiansThornItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Elder Guardian's Thorn", TextColor.color(0,170,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(5) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("elder_guardian_thorn","elder_guardian_thorn"), 11.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val shulkSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Shulk Sword", TextColor.color(255,85,255))) }
            itemMeta = itemMeta.apply { setCustomModelData(6) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("sculk_sword","sculk_sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val roseSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Rose Sword", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(7) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("rose_sword","rose_sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val iceSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Ice Sword", TextColor.color(0,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(8) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("ice_sword","ice_sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val wardensArmorItemStack: ItemStack = ItemStack(Material.NETHERITE_CHESTPLATE).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemMeta = itemMeta.apply { itemName(Component.text("Warden's Chestplate", TextColor.color(0,0,170))) }
                setCustomModelData(1)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("warden_chestplate","warden_chestplate"),9.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("warden_chestplate","warden_chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("warden_chestplate","warden_chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setEquippable(equippable.apply {
                    slot = EquipmentSlot.CHEST
                    model = NamespacedKey.fromString("minecraft:1")
                })            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val piglinsArmorItemStack: ItemStack = ItemStack(Material.NETHERITE_CHESTPLATE).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Pligin's Chestplate", TextColor.color(170,0,0)))
                setCustomModelData(2)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("piglin_chestplate","piglin_chestplate"),7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("piglin_chestplate","piglin_chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("piglin_chestplate","piglin_chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setEquippable(equippable.apply {
                    slot = EquipmentSlot.CHEST
                    model = NamespacedKey.fromString("minecraft:2")
                })            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val flyingChickenPantsItemStack: ItemStack = ItemStack(Material.NETHERITE_LEGGINGS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(255,255,255)))
                setCustomModelData(1)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("flying_chicken_pants","flying_chicken_pants"),5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.GRAVITY,AttributeModifier(NamespacedKey("flying_chicken_pants","flying_chicken_pants"),-0.05, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setEquippable(equippable.apply {
                    slot = EquipmentSlot.LEGS
                    model = NamespacedKey.fromString("minecraft:1")
                })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(272)
            }
        }
        val anvilPantsItemStack: ItemStack = ItemStack(Material.NETHERITE_LEGGINGS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Hardened Steel Greaves", TextColor.color(170,170,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("hardened_steel_greaves","hardened_steel_greaves"),8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("hardened_steel_greaves","hardened_steel_greaves"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("hardened_steel_greaves","hardened_steel_greaves"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setEquippable(equippable.apply {
                    slot = EquipmentSlot.LEGS
                    model = NamespacedKey.fromString("minecraft:2")
                })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(784)
            }
        }
        val wardensBootsItemStack: ItemStack = ItemStack(Material.NETHERITE_BOOTS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Warden's Sabatons", TextColor.color(80,170,170)))
                setCustomModelData(1)
                removeAttributeModifier(Attribute.ARMOR)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("warden_sabatons","warden_sabatons"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.MOVEMENT_SPEED, AttributeModifier(NamespacedKey("warden_sabatons","warden_sabatons"),1.5, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.FEET))
                setEquippable(equippable.apply {
                    slot = EquipmentSlot.FEET
                    model = NamespacedKey.fromString("minecraft:1")
                })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val oceansBootsItemStack: ItemStack = ItemStack(Material.NETHERITE_BOOTS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Ocean's Pact", TextColor.color(80,80,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.FEET)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("ocean_pact","ocean_pact"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.SAFE_FALL_DISTANCE, AttributeModifier(NamespacedKey("ocean_pact","ocean_pact"),512.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                lore(listOf(Component.text("Protects User From Heights", TextColor.color(255,255,255))))
                setEquippable(equippable.apply {
                    slot = EquipmentSlot.FEET
                    model = NamespacedKey.fromString("minecraft:2")
                })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
    }
}