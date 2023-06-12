package com.example.scratchcard

import android.content.Context
import java.util.Random


object Utils {
    var random: Random = Random()

    fun dipToPx(context: Context, dipValue: Int): Float {
        val density = context.resources.displayMetrics.density
        return dipValue * density
    }


    //Generate random number(Prize)
    private fun generateCodePart(min: Int, max: Int): String {
        val minNumber = 1
        val maxNumber = 100
        return java.lang.String.valueOf(random.nextInt(maxNumber - minNumber + 1) + minNumber)
    }

    fun generateNewCode(): String? {
        val firstCodePart = generateCodePart(1000, 9999)
        return "You Won\nRs.$firstCodePart"
    }
}