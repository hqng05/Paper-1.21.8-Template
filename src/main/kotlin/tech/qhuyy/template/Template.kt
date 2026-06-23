package tech.qhuyy.template

import org.bukkit.plugin.java.JavaPlugin
import tech.qhuyy.template.manager.ConfigManager
import tech.qhuyy.template.metrics.MetricsManager

private const val PLUGIN_ID = 987654321 // CHANGE IT

class Template : JavaPlugin() {
    lateinit var configManager: ConfigManager
        private set
    lateinit var metricsManager: MetricsManager
        private set

    override fun onEnable() {
        configManager = ConfigManager(this)
        metricsManager = MetricsManager(this, PLUGIN_ID).also { it.start() }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
