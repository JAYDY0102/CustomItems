package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.ShapelessRecipe
import org.bukkit.plugin.java.JavaPlugin

class CustomItems : JavaPlugin() {
    companion object {
        lateinit var instance: CustomItems
            private set
    }
    override fun onEnable() {
        instance = this
        logger.info("CustomItems starting...")
        saveDefaultConfig()
        Bukkit.getPluginManager().registerEvents(AttackListener(),this)
        Bukkit.getPluginManager().registerEvents(DeathListener(),this)
        server.scheduler.runTaskTimer(this, EquipmentEffects, 0L,1L)
        registerRecipe()

    }
    private fun registerRecipe() {
        //ids: a(Custom Miscellaneous Items), b(Swords), c(Tools), d(Helmet), e(Chestplate), f(Leggings), g(Boots)
        //a4, Bamboo Candy -> Chocolate
        val keya4 = NamespacedKey(this,"Chocolate")
        val recipea4 = ShapelessRecipe(keya4,Recipe.chocolateItemStack).apply {
            addIngredient(1,Material.COCOA_BEANS)
            addIngredient(1,Material.MILK_BUCKET)
            addIngredient(1,Material.SUGAR)
        }
        Bukkit.addRecipe(recipea4)
        //a5, Enchanted Diamond Apple -> Augmented Strength Potion
        val keya5 = NamespacedKey(this,"Augmented_Strength_Potion")
        val recipea5 = ShapedRecipe(keya5,Recipe.augmentedStrengthPotionItemStack).apply {
            shape("GBD","BAB","NBG")
            setIngredient('A', Material.GOLDEN_APPLE)
            setIngredient('B', Material.BLAZE_ROD)
            setIngredient('D', Material.DIAMOND)
            setIngredient('G', Material.GHAST_TEAR)
            setIngredient('N', Material.NETHERITE_SCRAP)
        }
        Bukkit.addRecipe(recipea5)
        //a9, Enhanced Golden Apple
        val keya9 = NamespacedKey(this,"Enhanced_Golden_Apple")
        val recipea9 = ShapedRecipe(keya9,Recipe.enhancedGoldenAppleItemStack).apply {
            shape("NDN","DAD","NDN")
            setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE)
            setIngredient('D', Material.DIAMOND_BLOCK)
            setIngredient('N', Material.NETHERITE_INGOT)
        }
        Bukkit.addRecipe(recipea9)
        //b3, Enderman's Sword
        val keyb3 = NamespacedKey(this,"Endermans_Sword")
        val recipeb3 = ShapedRecipe(keyb3,Recipe.endermanSwordItemStack).apply {
            shape("  P","CP ","EC ")
            setIngredient('P', Material.ENDER_PEARL)
            setIngredient('C', Material.POPPED_CHORUS_FRUIT)
            setIngredient('E', Material.END_ROD) }
        Bukkit.addRecipe(recipeb3)
        //b4, Wither's LongSword
        val keyb4 = NamespacedKey(this,"Withers_Sword")
        val recipeb4 = ShapedRecipe(keyb4,Recipe.witherLongSwordItemStack).apply {
            shape("  S","NW ","BN ")
            setIngredient('S', Material.STONE_SWORD)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('W', Material.WITHER_SKELETON_SKULL)
            setIngredient('B', Material.BLAZE_ROD)}
        Bukkit.addRecipe(recipeb4)
        //b5, Elder Guardian's Thorn
        val keyb5 = NamespacedKey(this,"Elder_Guardians_Thorn")
        val recipeb5 = ShapedRecipe(keyb5,Recipe.elderGuardiansThornItemStack).apply {
            shape("  P","GH ","SG ")
            setIngredient('P', Material.PRISMARINE_SHARD)
            setIngredient('G', Material.ENCHANTED_GOLDEN_APPLE)
            setIngredient('H', Material.HEART_OF_THE_SEA)
            setIngredient('S', Material.SEA_PICKLE)}
        Bukkit.addRecipe(recipeb5)
        //b6, Shulk Sword
        val keyb6 = NamespacedKey(this,"Shulk_Sword")
        val recipeb6 = ShapedRecipe(keyb6,Recipe.shulkSwordItemStack).apply {
            shape("  F","SD ","ES ")
            setIngredient('S', Material.SHULKER_SHELL)
            setIngredient('D', Material.DRAGON_HEAD)
            setIngredient('F', Material.ELYTRA)
            setIngredient('E', Material.END_ROD) }
        Bukkit.addRecipe(recipeb6)
        //b7, Rose Sword
        val keyb7 = NamespacedKey(this,"Rose_Sword")
        val recipeb7 = ShapedRecipe(keyb7,Recipe.roseSwordItemStack).apply {
            shape("  W","WW ","RW ")
            setIngredient('W', Material.WITHER_ROSE)
            setIngredient('R', Material.ROSE_BUSH) }
        Bukkit.addRecipe(recipeb7)
        //b8, Ice Sword
        val keyb8 = NamespacedKey(this,"Ice_Sword")
        val recipeb8 = ShapedRecipe(keyb8,Recipe.iceSwordItemStack).apply {
            shape("  I","II ","DI ")
            setIngredient('I', Material.BLUE_ICE)
            setIngredient('D', Material.DIAMOND_SWORD) }
        Bukkit.addRecipe(recipeb8)
        //c1, Hell's Pickaxe
        val keyc1 = NamespacedKey(this,"Hells_Pickaxe")
        val recipec1 = ShapedRecipe(keyc1,Recipe.hellspickaxeItemStack).apply {
            shape("NNS"," BN","B N")
            setIngredient('S', Material.NETHER_STAR)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('B', Material.BLAZE_ROD)}
        Bukkit.addRecipe(recipec1)
        //e1, Wardens Chestplate
        val keye1 = NamespacedKey(this,"Wardens_Chestplate")
        val recipee1 = ShapedRecipe(keye1,Recipe.wardensArmorItemStack).apply {
            shape("D D","SHS","ECE")
            setIngredient('D',Material.SCULK_SHRIEKER)
            setIngredient('S',Material.SCULK_SENSOR)
            setIngredient('H',Recipe.wardenHeartItemStack)
            setIngredient('C',Material.SCULK_CATALYST)
            setIngredient('E',Material.ECHO_SHARD) }
        Bukkit.addRecipe(recipee1)
        //e2, Piglin Chestplate
        val keye2 = NamespacedKey(this,"Piglins_Chestplate")
        val recipee2 = ShapedRecipe(keye2,Recipe.piglinsArmorItemStack).apply {
            shape("L L","NPN","BNB")
            setIngredient('L', Material.LAVA_BUCKET)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('P', Material.MUSIC_DISC_PIGSTEP)
            setIngredient('B', Material.NETHER_BRICK) }
        Bukkit.addRecipe(recipee2)
        //f1, Flying Chicken Pants
        val keyf1 = NamespacedKey(this,"Flying_Chicken_Pants")
        val recipef1 = ShapedRecipe(keyf1,Recipe.flyingChickenPantsItemStack).apply {
            shape("LPL","I I","B B")
            setIngredient('L', Material.FEATHER)
            setIngredient('I', Material.IRON_INGOT)
            setIngredient('P', Material.ELYTRA)
            setIngredient('B', Material.SHULKER_SHELL) }
        Bukkit.addRecipe(recipef1)
        //f2, Anvil Pants
        val keyf2 = NamespacedKey(this,"Anvil_Pants")
        val recipef2 = ShapedRecipe(keyf2,Recipe.anvilPantsItemStack).apply {
            shape("BLB","N N","N N")
            setIngredient('N', Material.ANVIL)
            setIngredient('L', Material.IRON_BLOCK)
            setIngredient('B', Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipef2)
        //g1, The Oceans Boots
        val keyg1 = NamespacedKey(this,"Ocean_Boots")
        val recipeg1 = ShapedRecipe(keyg1,Recipe.oceansBootsItemStack).apply {
            shape(" T ","NPN","D D")
            setIngredient('T', Material.TRIDENT)
            setIngredient('N', Material.CONDUIT)
            setIngredient('P', Material.HEART_OF_THE_SEA)
            setIngredient('D', Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipeg1)
        //g2, Wardens Ice Boots
        val keyg2 = NamespacedKey(this,"Wardens_Boots")
        val recipeg2 = ShapedRecipe(keyg2,Recipe.wardensBootsItemStack).apply {
            shape("N N","N N","H H")
            setIngredient('N',Material.NETHERITE_INGOT)
            setIngredient('H',Recipe.wardenHeartItemStack)}
        Bukkit.addRecipe(recipeg2)
    }
}