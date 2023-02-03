package com.example.callapiwithcleanarch.utils

import com.google.gson.annotations.SerializedName

/**
 * Class represents error body of retrofit.
 */
open class ErrorBodyResponse(
        @SerializedName("code")
        val code: Int = -1,
        @SerializedName("error", alternate = ["message", "errorMessage"])
        val message: String = ""
)