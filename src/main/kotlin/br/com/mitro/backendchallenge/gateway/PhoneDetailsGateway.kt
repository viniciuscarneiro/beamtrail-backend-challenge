package br.com.mitro.backendchallenge.gateway

import br.com.mitro.backendchallenge.domain.Phone
import br.com.mitro.backendchallenge.domain.PhoneDetails

interface PhoneDetailsGateway {
    fun getPhoneDetails(phone: Phone): PhoneDetails
}