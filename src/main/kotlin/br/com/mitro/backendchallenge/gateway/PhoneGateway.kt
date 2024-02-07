package br.com.mitro.backendchallenge.gateway

import br.com.mitro.backendchallenge.domain.Phone

interface PhoneGateway {
    fun getPhoneBySearchTerm(name: String?): List<Phone>
    fun getAvailablePhoneById(id: Long): Phone?
    fun getPhoneById(id: Long): Phone?
    fun persistPhone(phone: Phone)
}