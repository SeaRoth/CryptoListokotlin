package com.leyrey.cryptolisto.utils

import java.util.regex.Pattern

object InputValidator {
    private val VALID_CITY_REGEX = Pattern.compile("[a-zA-Z]+")

    fun isValidCoinInput(city: String): Boolean {
        val matches = VALID_CITY_REGEX.matcher(city).matches()
        return matches
    }
}