package tech.qhuyy.template.storage

enum class StorageType {
    SQLITE, MYSQL;

    companion object {
        fun fromString(value: String?): StorageType {
            return when (value?.uppercase()) {
                "SQLITE" -> SQLITE
                "MYSQL" -> MYSQL
                else -> SQLITE
            }
        }
    }
}
