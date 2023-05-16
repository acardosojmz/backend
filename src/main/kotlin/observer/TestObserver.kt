package observer

import java.text.DecimalFormat

import java.text.SimpleDateFormat




fun main() {
    val conf = ConfigurationManager.getInstance()

    conf.setDefaultDateFormat(SimpleDateFormat("yyyy/MM/dd"))

    conf.setMoneyFormat(DecimalFormat("##.00"))

    println("Configuración establecida")

    val dateFormatObserver = DateFormatObserver()

    val moneyFormatObserver = MoneyFormatObserver()

    conf.addObserver(dateFormatObserver)

    conf.addObserver(moneyFormatObserver)

    println("")

    conf.setDefaultDateFormat(SimpleDateFormat("dd/MM/yyyy"))

    conf.setMoneyFormat(DecimalFormat("###,#00.00"))
    println("")


    conf.setDefaultDateFormat(SimpleDateFormat("MM/yyyy/dd"))
    conf.setMoneyFormat(DecimalFormat("###,#00"))

    conf.removeObserver(dateFormatObserver)
    conf.removeObserver(moneyFormatObserver)
    println("")

    conf.setDefaultDateFormat(SimpleDateFormat("MM/yyyy"))
    conf.setMoneyFormat(DecimalFormat("###,##0.00"))

    
}