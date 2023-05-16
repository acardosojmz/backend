package observer
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


class ConfigurationManager: AbstractObservable() {
    private lateinit var  defaultDateFormat: SimpleDateFormat
    private lateinit var  moneyFormat: NumberFormat

    init {
        defaultDateFormat= SimpleDateFormat ("dd-MMM-yyyy")
        moneyFormat =  NumberFormat.getInstance(Locale.ENGLISH)

    }
    companion object {
        private lateinit var configurationManager: ConfigurationManager
        fun getInstance(): ConfigurationManager {
            synchronized(this) {
                if (!::configurationManager.isInitialized) {
                    configurationManager = ConfigurationManager()
                }
                return configurationManager
            }
        }
    }
    fun getDefaultDateFormat(): SimpleDateFormat {
        return defaultDateFormat
    }
    fun setDefaultDateFormat(dateFormat: SimpleDateFormat) {
        this.defaultDateFormat = dateFormat
        notifyAllObservers("defaultDateFormat", this)
    }
    fun getMoneyFormat(): NumberFormat {
        return moneyFormat
    }
    fun setMoneyFormat(moneyFormat: NumberFormat){
        this.moneyFormat = moneyFormat
        notifyAllObservers("moneyFormat", this)
    }

}