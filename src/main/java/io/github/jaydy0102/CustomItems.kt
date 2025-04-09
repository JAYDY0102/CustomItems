package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ShapedRecipe
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
        server.scheduler.runTaskTimer(this, EquipmentEffects, 0L,1L)
        registerRecipe()
    }
    private fun registerRecipe() {
        //Enderman's Sword
        val key = NamespacedKey(this,"Endermans_Sword")
        val recipe = ShapedRecipe(key,Recipe.endermanSwordItemStack).apply {
            shape("  P","CP ","EC ")
            setIngredient('P', Material.ENDER_PEARL)
            setIngredient('C', Material.POPPED_CHORUS_FRUIT)
            setIngredient('E', Material.END_ROD) }
        Bukkit.addRecipe(recipe)
        //Wither's LongSword
        val key6 = NamespacedKey(this,"Withers_Sword")
        val recipe6 = ShapedRecipe(key6,Recipe.witherLongSwordItemStack).apply {
            shape("  S","NW ","BN ")
            setIngredient('S', Material.STONE_SWORD)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('W', Material.WITHER_SKELETON_SKULL)
            setIngredient('B', Material.BLAZE_ROD)}
        Bukkit.addRecipe(recipe6)
        //Hell's Pickaxe
        val key7 = NamespacedKey(this,"Hells_Pickaxe")
        val recipe7 = ShapedRecipe(key7,Recipe.hellspickaxeItemStack).apply {
            shape("NNS"," BN","B N")
            setIngredient('S', Material.NETHER_STAR)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('B', Material.BLAZE_ROD)}
        Bukkit.addRecipe(recipe7)
        //Elder Guardian's Thorn
        val key8 = NamespacedKey(this,"Elder_Guardians_Thorn")
        val recipe8 = ShapedRecipe(key8,Recipe.elderGuardiansThornItemStack).apply {
            shape("  P","GH ","SG ")
            setIngredient('P', Material.PRISMARINE_SHARD)
            setIngredient('G', Material.ENCHANTED_GOLDEN_APPLE)
            setIngredient('H', Material.HEART_OF_THE_SEA)
            setIngredient('S', Material.SEA_PICKLE)}
        Bukkit.addRecipe(recipe8)
        //Shulk Sword
        val key9 = NamespacedKey(this,"Shulk_Sword")
        val recipe9 = ShapedRecipe(key9,Recipe.shulkSwordItemStack).apply {
            shape("  F","SD ","ES ")
            setIngredient('S', Material.SHULKER_SHELL)
            setIngredient('D', Material.DRAGON_HEAD)
            setIngredient('F', Material.ELYTRA)
            setIngredient('E', Material.END_ROD) }
        Bukkit.addRecipe(recipe9)
        //Rose Sword
        val key10 = NamespacedKey(this,"Rose_Sword")
        val recipe10 = ShapedRecipe(key10,Recipe.roseSwordItemStack).apply {
            shape("  W","WW ","RW ")
            setIngredient('W', Material.WITHER_ROSE)
            setIngredient('R', Material.ROSE_BUSH) }
        Bukkit.addRecipe(recipe10)
        //Ice Sword
        val key11 = NamespacedKey(this,"Ice_Sword")
        val recipe11 = ShapedRecipe(key11,Recipe.iceSwordItemStack).apply {
            shape("  I","II ","DI ")
            setIngredient('I', Material.BLUE_ICE)
            setIngredient('D', Material.DIAMOND_SWORD) }
        Bukkit.addRecipe(recipe11)
        //Piglin Chestplate
        val key12 = NamespacedKey(this,"Piglins_Chestplate")
        val recipe12 = ShapedRecipe(key12,Recipe.piglinsArmorItemStack).apply {
            shape("L L","NPN","BNB")
            setIngredient('L', Material.LAVA_BUCKET)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('P', Material.MUSIC_DISC_PIGSTEP)
            setIngredient('B', Material.NETHER_BRICK) }
        Bukkit.addRecipe(recipe12)
        //Flying Chicken Pants
        val key13 = NamespacedKey(this,"Flying_Chicken_Pants")
        val recipe13 = ShapedRecipe(key13,Recipe.flyingChickenPantsItemStack).apply {
            shape("LPL","I I","B B")
            setIngredient('L', Material.FEATHER)
            setIngredient('I', Material.IRON_INGOT)
            setIngredient('P', Material.ELYTRA)
            setIngredient('B', Material.SHULKER_SHELL) }
        Bukkit.addRecipe(recipe13)
        //Anvil Pants
        val key14 = NamespacedKey(this,"Anvil_Pants")
        val recipe14 = ShapedRecipe(key14,Recipe.anvilPantsItemStack).apply {
            shape("BLB","N N","N N")
            setIngredient('N', Material.ANVIL)
            setIngredient('L', Material.IRON_BLOCK)
            setIngredient('B', Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipe14)
        //The Oceans Boots
        val key15 = NamespacedKey(this,"Ocean_Boots")
        val recipe15 = ShapedRecipe(key15,Recipe.oceansBootsItemStack).apply {
            shape(" T ","NPN","D D")
            setIngredient('T', Material.TRIDENT)
            setIngredient('N', Material.CONDUIT)
            setIngredient('P', Material.HEART_OF_THE_SEA)
            setIngredient('D', Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipe15)
    }
}