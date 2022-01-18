package com.example.spacedim

import com.squareup.moshi.Json

enum class UIType {
    BUTTON, SWITCH, SHAKE
}

interface IElement {
    var id: Int
    val content: String
}

data class UIElement(val id: Int, @Json(name = "type") val uiType: UIType, val content: String)

