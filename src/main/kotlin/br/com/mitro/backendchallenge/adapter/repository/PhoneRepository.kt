package br.com.mitro.backendchallenge.adapter.repository

import br.com.mitro.backendchallenge.domain.Phone

interface PhoneRepository {
    fun findPhoneByNameOrBrand(searchTerm: String): List<Phone>
    fun saveOrUpdatePhone(phone: Phone)
    fun findAvailablePhoneById(id: Long): Phone?
    fun findPhoneById(id: Long): Phone?
    fun findAllPhones(): List<Phone>
}
