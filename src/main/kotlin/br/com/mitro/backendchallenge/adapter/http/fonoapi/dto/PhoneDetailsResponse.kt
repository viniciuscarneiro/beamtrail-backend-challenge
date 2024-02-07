package br.com.mitro.backendchallenge.adapter.http.fonoapi.dto

import br.com.mitro.backendchallenge.domain.PhoneDetails
import com.fasterxml.jackson.annotation.JsonProperty

data class PhoneDetailsResponse(
    @JsonProperty("technology") val technology: String? = null,
    @JsonProperty("_2g_bands") val bands2g: String? = null,
    @JsonProperty("_3g_bands") val bands3g: String? = null,
    @JsonProperty("_4g_bands") val bands4g: String? = null,
) {
    fun toDomain(): PhoneDetails {
        return PhoneDetails(
            technology = this.technology,
            bands2g = this.bands2g,
            bands3g = this.bands3g,
            bands4g = this.bands4g
        )
    }
}