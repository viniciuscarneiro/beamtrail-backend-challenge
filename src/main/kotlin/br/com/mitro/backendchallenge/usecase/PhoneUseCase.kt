package br.com.mitro.backendchallenge.usecase

import br.com.mitro.backendchallenge.domain.Phone


interface PhoneUseCase {
    fun getAvailablePhones(searchTerm: String?): List<Phone>
    fun bookPhone(phoneId: Long, user: String)
    fun returnBookedPhone(phoneId: Long)
}