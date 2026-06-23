package tech.qhuyy.template.manager

import org.bukkit.configuration.file.FileConfiguration
import tech.qhuyy.template.Template
import tech.qhuyy.template.storage.StorageType

@Suppress("unused")
class ConfigManager(
    private val plugin: Template
) {
    private var config: FileConfiguration = plugin.config

    init {
        plugin.saveDefaultConfig()
        reload()
    }

    fun reload() {
        plugin.reloadConfig()
        config = plugin.config
    }

    fun getStorageMethod(): StorageType = StorageType.fromString(
        config.getString("storage.method", "sqlite")
    )

    fun getMySQLHost(): String = config.getString("storage.mysql.host", "localhost") ?: "localhost"
    fun getMySQLPort(): Int = config.getInt("storage.mysql.port", 3306)
    fun getMySQLDatabase(): String = config.getString("storage.mysql.database", "hyticinv") ?: "hyticinv"
    fun getMySQLUsername(): String = config.getString("storage.mysql.username", "root") ?: "root"
    fun getMySQLPassword(): String = config.getString("storage.mysql.password", "password") ?: "password"

    fun getMySQLMaxPoolSize(): Int = config.getInt("storage.mysql.pool.maximum-pool-size", 10)
    fun getMySQLMinIdle(): Int = config.getInt("storage.mysql.pool.minimum-idle", 2)
    fun getMySQLConnectionTimeout(): Long = config.getLong("storage.mysql.pool.connection-timeout", 30000)
    fun getMySQLIdleTimeout(): Long = config.getLong("storage.mysql.pool.idle-timeout", 600000)
    fun getMySQLMaxLifetime(): Long = config.getLong("storage.mysql.pool.max-lifetime", 1800000)

    fun getSQLitePath(): String {
        val configPath = config.getString("storage.sqlite.path", "data.db") ?: "data.db"
        return if (configPath.startsWith("/") || configPath.contains(":")) {
            configPath
        } else {
            "${plugin.dataFolder}/$configPath"
        }
    }

    fun isPrefixEnabled(): Boolean = config.getBoolean("messages.enable-prefix", true)
    fun getPrefix(): String = config.getString("messages.prefix", "") ?: ""
    fun getMetrics(): Boolean = config.getBoolean("metrics.enabled", true)
}
