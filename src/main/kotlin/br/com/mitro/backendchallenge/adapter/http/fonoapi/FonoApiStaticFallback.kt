package br.com.mitro.backendchallenge.adapter.http.fonoapi

import br.com.mitro.backendchallenge.adapter.http.fonoapi.dto.PhoneDetailsResponse
import br.com.mitro.backendchallenge.domain.exception.UnableToFetchDetailsException
import org.springframework.stereotype.Component

@Component
class FonoApiStaticFallback : FonoApi {

    private val phones = mapOf(
        "Samsung Galaxy S9" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Samsung Galaxy S8" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Samsung Galaxy S8" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Motorola Nexus 6" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Oneplus 9" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Apple iPhone 13" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Apple iPhone 12" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "Apple iPhone 11" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),
        "iPhone X" to PhoneDetailsResponse(
            technology = "4g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        ),

        "Nokia 3310" to PhoneDetailsResponse(
            technology = "5g",
            bands2g = "B3 (1800)",
            bands3g = "B1 (2100), B5 (850), B8 (900)",
            bands4g = "B1 (2100), B3 (1800), B5 (850), B7 (2600), B28a (700)",
        )
    )

    override fun getDevice(token: String, device: String, brand: String?, position: Int?): PhoneDetailsResponse {
        return phones["$brand $device"] ?: phones[device]
        ?: throw UnableToFetchDetailsException("Unable to fetch phone details fo $brand $device")
    }
}