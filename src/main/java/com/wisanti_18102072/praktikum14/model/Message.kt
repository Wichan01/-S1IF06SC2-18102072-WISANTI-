package com.wisanti_18102072.praktikum14.model

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("message")
    var message: String? = null
)