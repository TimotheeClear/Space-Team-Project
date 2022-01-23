package com.example.spacedim.modele

import com.squareup.moshi.Json

enum class UIType {
    BUTTON, SWITCH, SHAKE
}

data class UIElement(val id: Int, @Json(name = "type") val uiType: UIType, val content: String)

