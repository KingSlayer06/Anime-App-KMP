package com.kingslayer06.core.util


fun Int?.toFormattedString(): String {
    if (this == null) return "0"
    return when {
        this >= 1_000_000 -> "${(this / 1_000_000.0).roundToOneDecimal()}M"
        this >= 1_000 -> "${(this / 1_000.0).roundToOneDecimal()}k"
        else -> this.toString()
    }
}

private fun Double.roundToOneDecimal(): String {
    val rounded = (this * 10).toInt() / 10.0
    return if (rounded % 1.0 == 0.0) rounded.toInt().toString() else rounded.toString()
}