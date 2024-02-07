package br.com.mitro.backendchallenge.adapter.gateway

import br.com.mitro.backendchallenge.adapter.http.fonoapi.FonoApi
import br.com.mitro.backendchallenge.domain.Phone
import br.com.mitro.backendchallenge.domain.PhoneDetails
import br.com.mitro.backendchallenge.gateway.PhoneDetailsGateway
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class FonoApiPhoneDetailsGatewayImpl(
    val fonoApi: FonoApi,
    @Value("\${fono.api.token}")
    val token: String,
) : PhoneDetailsGateway {
    override fun getPhoneDetails(phone: Phone): PhoneDetails {
        return fonoApi.getDevice(token, device = phone.name).toDomain()
    }
}