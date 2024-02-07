package br.com.mitro.backendchallenge.adapter.gateway

import br.com.mitro.backendchallenge.adapter.repository.PhoneRepository
import br.com.mitro.backendchallenge.domain.Phone
import br.com.mitro.backendchallenge.gateway.PhoneGateway
import org.springframework.stereotype.Component

@Component
class PhoneGatewayImpl(val phoneRepository: PhoneRepository) : PhoneGateway {

    override fun getPhoneBySearchTerm(searchTerm: String?): List<Phone> {
        return searchTerm?.let {
            phoneRepository.findPhoneByNameOrBrand(it)
        } ?: phoneRepository.findAllPhones()

    }

    override fun getAvailablePhoneById(id: Long): Phone? {
        return phoneRepository.findAvailablePhoneById(id)
    }

    override fun getPhoneById(id: Long): Phone? {
        return phoneRepository.findPhoneById(id)
    }

    override fun persistPhone(phone: Phone) {
        phoneRepository.saveOrUpdatePhone(phone)
    }
}