package io.github.jaydy0102

import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.Consumable
import io.papermc.paper.datacomponent.item.FoodProperties
import io.papermc.paper.datacomponent.item.Tool
import io.papermc.paper.datacomponent.item.consumable.ConsumeEffect
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.EquipmentSlotGroup
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ArmorMeta
import org.bukkit.inventory.meta.Damageable
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

@Suppress("DEPRECATION")
abstract class  Recipe {
    companion object {
        //shortened code in general + why no eat seconds? -> Turns out other method exists
        //ids: a(Custom Miscellaneous Items), b(Swords), c(Tools), d(Helmet), e(Chestplate), f(Leggings), g(Boots)
        //a4
        val chocolateItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Chocolate", TextColor.color(255, 255, 255)))
                setCustomModelData(4)
                setMaxStackSize(64)
            }
            setData(DataComponentTypes.FOOD, FoodProperties.food().nutrition(7).saturation(8.0F).build())
            setData(DataComponentTypes.CONSUMABLE, Consumable.consumable().consumeSeconds(0.5F).build())
        }
        //a5
        val augmentedStrengthPotionItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Augmented Strength Potion"))
                setCustomModelData(5)
                setMaxStackSize(16)
                setEnchantmentGlintOverride(true)
                setRarity(ItemRarity.EPIC)
            }
            setData(DataComponentTypes.FOOD, FoodProperties.food().nutrition(15).saturation(10.0F).canAlwaysEat(true).build())
            setData(DataComponentTypes.CONSUMABLE,Consumable.consumable().animation(ItemUseAnimation.DRINK).sound(Key.key("minecraft:entity.generic.drink")).consumeSeconds(1.0F).addEffects(listOf(ConsumeEffect.applyStatusEffects(listOf(PotionEffect(PotionEffectType.STRENGTH,4800,3,true,true)),1.0F))).build())
        }
        //a6
        val wardenHeartItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Warden's Heart", TextColor.color(255,85,255)))
                setCustomModelData(6)
            }
        }
        //a9
        val enhancedGoldenAppleItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Enhanced Golden Apple"))
                setCustomModelData(9)
                setMaxStackSize(16)
                setEnchantmentGlintOverride(true)
                setRarity(ItemRarity.EPIC)
            }
            setData(DataComponentTypes.FOOD, FoodProperties.food().nutrition(15).saturation(10.0F).canAlwaysEat(true).build())
            setData(DataComponentTypes.CONSUMABLE,Consumable.consumable().animation(ItemUseAnimation.EAT).consumeSeconds(5.0F).addEffects(listOf(ConsumeEffect.applyStatusEffects(listOf(PotionEffect(PotionEffectType.REGENERATION,4800,1,true,true), PotionEffect(PotionEffectType.RESISTANCE,4800,0,true,true), PotionEffect(PotionEffectType.SLOWNESS,4800,3,true,true), PotionEffect(PotionEffectType.ABSORPTION,4800,8,true,true)),1.0F))).build())
        }
        //a13
        val leftWingItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Left Wing"))
                setCustomModelData(13)
                setMaxStackSize(16)
                setRarity(ItemRarity.EPIC)
            }
        }
        //a14
        val rightWingItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Right Wing"))
                setCustomModelData(14)
                setMaxStackSize(16)
                setRarity(ItemRarity.EPIC)
            }
        }
        //a15
        val fireworkItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Eternal Flame"))
                setRarity(ItemRarity.RARE)
                setCustomModelData(15)
                lore(listOf(Component.text("Only usable with Upgraded Elytra")))
            }
        }
        //a16
        val fuseItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Fuse"))
                setCustomModelData(16)
            }
        }
        //a17
        val netherCoreItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Nether Core", TextColor.color(59, 57, 59)))
                setCustomModelData(17)
            }
        }
        //b3
        val endermanSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Enderman's Sword", TextColor.color(170,0,170)))
                setCustomModelData(3)
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("enderman_sword","enderman_sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
            }
        }
        //b4
        val witherLongSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Wither's Longsword", TextColor.color(0,0,0)))
                setCustomModelData(4)
                removeAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE)
                addAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE, AttributeModifier(NamespacedKey("wither_sword","wither_sword"), 1.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("wither_sword","wither_sword"), 6.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
            }
        }
        //b5
        val elderGuardiansThornItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Elder Guardian's Thorn", TextColor.color(0,170,170)))
                setCustomModelData(5)
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("elder_guardian_thorn","elder_guardian_thorn"), 11.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
            }
        }
        //b6
        val shulkSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Shulk Sword", TextColor.color(255,85,255)))
                setCustomModelData(6)
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("sculk_sword","sculk_sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
            }
        }
        //b7
        val roseSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Rose Sword", TextColor.color(255,85,85)))
                setCustomModelData(7)
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("rose_sword","rose_sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
            }
        }
        //b8
        val iceSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Ice Sword", TextColor.color(0,0,170)))
                setCustomModelData(8)
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("ice_sword","ice_sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
            }
        }
        //c1
        val hellspickaxeItemStack = ItemStack(Material.NETHERITE_PICKAXE).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Hell's Pickaxe", TextColor.color(170,0,0)))
                setCustomModelData(1)
            }
        }
        //c2
        val weightedAxeItemStack: ItemStack = ItemStack(Material.NETHERITE_AXE).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Weighted Axe", TextColor.color(122,130,196)))
                setCustomModelData(1)
                removeAttributeModifier(Attribute.ATTACK_DAMAGE)
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("weighted_axe","weighted_axe"), 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))
                addEnchant(Enchantment.WIND_BURST, 5, true)
                addEnchant(Enchantment.DENSITY, 5, true)
                addEnchant(Enchantment.BREACH, 5, true)
            }
            setData(DataComponentTypes.TOOL, Tool.tool().defaultMiningSpeed(30.0F).build())
        }
        //d1
        val endCrownItemStack: ItemStack = ItemStack(Material.NETHERITE_HELMET).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                removeAttributeModifier(EquipmentSlot.HEAD)
                itemMeta = itemMeta.apply { itemName(Component.text("The Crown of the End", TextColor.color(255,255,85))) }
                setCustomModelData(1)
                isFireResistant = true
                addAttributeModifier(Attribute.MAX_HEALTH, AttributeModifier(NamespacedKey("end_crown","end_crown"), 20.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD))
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("end_crown","end_crown"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD))
                addAttributeModifier(Attribute.ATTACK_DAMAGE, AttributeModifier(NamespacedKey("end_crown","end_crown"),5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD))
                addEnchant(Enchantment.THORNS, 5, true)
                addEnchant(Enchantment.PROTECTION, 10, true)
                addEnchant(Enchantment.PROJECTILE_PROTECTION, 10, true)
                addEnchant(Enchantment.BLAST_PROTECTION, 10, true)
                setEquippable(equippable.apply { slot = EquipmentSlot.HEAD; model = NamespacedKey.fromString("minecraft:1") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                isUnbreakable = true
            }
        }
        //e1
        val wardensArmorItemStack: ItemStack = ItemStack(Material.NETHERITE_CHESTPLATE).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Warden's Chestplate", TextColor.color(0,0,170)))
                setCustomModelData(1)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("warden_chestplate","warden_chestplate"),9.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("warden_chestplate","warden_chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("warden_chestplate","warden_chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setEquippable(equippable.apply { slot = EquipmentSlot.CHEST; model = NamespacedKey.fromString("minecraft:1") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        //e2
        val piglinsArmorItemStack: ItemStack = ItemStack(Material.NETHERITE_CHESTPLATE).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Pligin's Chestplate", TextColor.color(170,0,0)))
                setCustomModelData(2)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("piglin_chestplate","piglin_chestplate"),7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("piglin_chestplate","piglin_chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("piglin_chestplate","piglin_chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setEquippable(equippable.apply { slot = EquipmentSlot.CHEST;model = NamespacedKey.fromString("minecraft:2") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        //e3
        val upgradedElytraItemStack: ItemStack = ItemStack(Material.ELYTRA).apply {
            itemMeta = itemMeta.apply {
                itemName(Component.text("Upgraded Elytra", TextColor.color(154,192,205)))
                setCustomModelData(3)
                isGlider = true
                isFireResistant = true
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("upgraded_elytra","upgraded_elytra"),9.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("upgraded_elytra","upgraded_elytra"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("upgraded_elytra","upgraded_elytra"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setEquippable(equippable.apply { slot = EquipmentSlot.CHEST;model = NamespacedKey.fromString("minecraft:3") })
                addEnchant(Enchantment.PROTECTION, 5, true)
                addEnchant(Enchantment.PROJECTILE_PROTECTION, 5, true)
                addEnchant(Enchantment.BLAST_PROTECTION, 5, true)
                setEnchantmentGlintOverride(false)
                isUnbreakable = true
            }
        }
        //f1
        val flyingChickenPantsItemStack: ItemStack = ItemStack(Material.NETHERITE_LEGGINGS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(255,255,255)))
                setCustomModelData(1)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("flying_chicken_pants","flying_chicken_pants"),5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.GRAVITY,AttributeModifier(NamespacedKey("flying_chicken_pants","flying_chicken_pants"),-0.05, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setEquippable(equippable.apply { slot = EquipmentSlot.LEGS; model = NamespacedKey.fromString("minecraft:1") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(272)
            }
        }
        //f2
        val anvilPantsItemStack: ItemStack = ItemStack(Material.NETHERITE_LEGGINGS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Hardened Steel Greaves", TextColor.color(170,170,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("hardened_steel_greaves","hardened_steel_greaves"),8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("hardened_steel_greaves","hardened_steel_greaves"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("hardened_steel_greaves","hardened_steel_greaves"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setEquippable(equippable.apply { slot = EquipmentSlot.LEGS; model = NamespacedKey.fromString("minecraft:2") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(784)
            }
        }
        //g1
        val wardensBootsItemStack: ItemStack = ItemStack(Material.NETHERITE_BOOTS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Warden's Sabatons", TextColor.color(80,170,170)))
                setCustomModelData(1)
                removeAttributeModifier(Attribute.ARMOR)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("warden_sabatons","warden_sabatons"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.MOVEMENT_SPEED, AttributeModifier(NamespacedKey("warden_sabatons","warden_sabatons"),1.5, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.FEET))
                setEquippable(equippable.apply { slot = EquipmentSlot.FEET;model = NamespacedKey.fromString("minecraft:1") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        //g2
        val oceansBootsItemStack: ItemStack = ItemStack(Material.NETHERITE_BOOTS).apply {
            itemMeta = (itemMeta as ArmorMeta).apply {
                itemName(Component.text("Ocean's Pact", TextColor.color(80,80,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.FEET)
                addAttributeModifier(Attribute.ARMOR, AttributeModifier(NamespacedKey("ocean_pact","ocean_pact"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.SAFE_FALL_DISTANCE, AttributeModifier(NamespacedKey("ocean_pact","ocean_pact"),512.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                lore(listOf(Component.text("Protects User From Heights", TextColor.color(255,255,255))))
                setEquippable(equippable.apply { slot = EquipmentSlot.FEET; model = NamespacedKey.fromString("minecraft:2") })
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
    }
}