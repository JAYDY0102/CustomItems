package io.github.jaydy0102

object ConfigManager {
    private val config = CustomItems.instance.config

    val craftPlayers: MutableList<String>
        get() = config.getStringList("craftPlayers")
}