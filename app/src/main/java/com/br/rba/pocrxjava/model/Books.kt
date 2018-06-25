package com.br.rba.pocrxjava.model

import com.google.gson.annotations.SerializedName

class Books {
    @SerializedName("items")
    var items: List<Item>? = null
    @SerializedName("kind")
    var kind: String? = null
    @SerializedName("totalItems")
    var totalItems: Long? = null
}