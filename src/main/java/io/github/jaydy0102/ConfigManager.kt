package io.github.jaydy0102

object ConfigManager {
    private val config = CustomItems.instance.config

    val craftedAxe: Boolean
        get() = config.getBoolean("craftedAxe")
}