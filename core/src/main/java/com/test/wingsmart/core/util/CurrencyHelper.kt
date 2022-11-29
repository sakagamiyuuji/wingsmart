package com.test.wingsmart.core.util

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

object CurrencyHelper {

    private const val CURRENCY_SYMBOL = "Rp"

    fun Long.toRupiahString(addCurrencySymbol: Boolean = true, withSuffix: Boolean = false): String {
        return doubleToRupiahString(this.toDouble(), addCurrencySymbol, withSuffix)
    }

    fun doubleToRupiahString(number: Double, addCurrencySymbol: Boolean, withSuffix: Boolean): String {
        val locale = Locale("in", "ID")
        val rupiahFormat = NumberFormat.getCurrencyInstance(locale) as DecimalFormat
        if (addCurrencySymbol) {
            rupiahFormat.positivePrefix = CURRENCY_SYMBOL
            rupiahFormat.negativePrefix = "$CURRENCY_SYMBOL -"
        } else {
            rupiahFormat.positivePrefix = ""
            rupiahFormat.negativePrefix = "-"
        }
        if (withSuffix) {
            rupiahFormat.positiveSuffix = ",-"
            rupiahFormat.negativeSuffix = ",-"
        }
        rupiahFormat.maximumFractionDigits = 0
        return rupiahFormat.format(number)
    }
}