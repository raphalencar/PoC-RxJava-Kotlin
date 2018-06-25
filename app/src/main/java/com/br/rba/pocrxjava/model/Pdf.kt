package com.br.rba.pocrxjava.model

import com.google.gson.annotations.SerializedName

class Pdf {

    @SerializedName("downloadLink")
    var downloadLink: String? = null
    @SerializedName("isAvailable")
    var isAvailable: Boolean? = null

}
