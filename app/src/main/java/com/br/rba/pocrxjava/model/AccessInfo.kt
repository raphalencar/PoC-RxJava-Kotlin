package com.br.rba.pocrxjava.model

import com.google.gson.annotations.SerializedName

class AccessInfo {

    @SerializedName("accessViewStatus")
    var accessViewStatus: String? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("embeddable")
    var embeddable: Boolean? = null
    @SerializedName("epub")
    var epub: com.br.rba.pocrxjava.model.Epub? = null
    @SerializedName("pdf")
    var pdf: com.br.rba.pocrxjava.model.Pdf? = null
    @SerializedName("publicDomain")
    var publicDomain: Boolean? = null
    @SerializedName("quoteSharingAllowed")
    var quoteSharingAllowed: Boolean? = null
    @SerializedName("textToSpeechPermission")
    var textToSpeechPermission: String? = null
    @SerializedName("viewability")
    var viewability: String? = null
    @SerializedName("webReaderLink")
    var webReaderLink: String? = null

}
