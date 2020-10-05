package com.wildanfuady.bookingservice.util

import java.text.NumberFormat
import java.util.*

object Converter {
    fun formatRupiah(price: Int): String? {
        val localeID = Locale("in", "ID")
        val format =
            NumberFormat.getCurrencyInstance(localeID)
        return format.format(price.toLong())
    }
}