package singleton

import properties.PropertiesUtil.loadProperty


class Singleton {
    private val _CONFIGURATION_PROP = "properties/singleton"
    private val _APP_NAME_PROP = "appName"
    private val _APP_VERSION_PROP = "appVersion"
    private var _appName: String? = null
    private var _appVersion: String? = null
    init {
        val prop = loadProperty(this._CONFIGURATION_PROP)
        this._appName = prop!!.getProperty(this._APP_NAME_PROP)
        this._appVersion = prop.getProperty(this._APP_VERSION_PROP)
    }
    companion object {

        private lateinit var _singleton: Singleton
        fun getInstance(): Singleton {
            synchronized(this) {
                if (!::_singleton.isInitialized) {
                    _singleton = Singleton()
                }
                return _singleton
            }
        }
    }
    fun setAppName(appName: String) {
        this._appName = appName
    }

    fun getAppName() = this._appName
    fun setAppVersion(appVersion: String) {
        this._appVersion = appVersion
    }

    fun getAppVersion() = this._appVersion
}




