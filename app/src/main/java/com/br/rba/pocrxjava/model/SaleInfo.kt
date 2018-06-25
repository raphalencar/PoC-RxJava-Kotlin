package com.br.rba.pocrxjava.model

import com.google.gson.annotations.SerializedName

class SaleInfo {

    @SerializedName("buyLink")
    var buyLink: String? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("isEbook")
    var isEbook: Boolean? = null
    @SerializedName("saleability")
    var saleability: String? = null

}
