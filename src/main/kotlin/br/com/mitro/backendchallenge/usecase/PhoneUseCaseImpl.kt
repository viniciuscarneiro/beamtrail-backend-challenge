package br.com.mitro.backendchallenge.usecase

import br.com.mitro.backendchallenge.domain.Phone
import br.com.mitro.backendchallenge.domain.exception.PhoneNotFoundException
import br.com.mitro.backendchallenge.domain.exception.UnavailablePhoneException
import br.com.mitro.backendchallenge.gateway.PhoneDetailsGateway
import br.com.mitro.backendchallenge.gateway.PhoneGateway
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PhoneUseCaseImpl(
    val phoneGateway: PhoneGateway,
    val phoneDetailsGateway: PhoneDetailsGateway,
) : PhoneUseCase {
    override fun getAvailablePhones(searchTerm: String?): List<Phone> {
        return phoneGateway.getPhoneBySearchTerm(searchTerm).map {
            val phoneDetails = phoneDetailsGateway.getPhoneDetails(it)
            it.bands2g = phoneDetails.bands2g
            it.bands3g = phoneDetails.bands3g
            it.bands4g = phoneDetails.bands4g
            it.technology = phoneDetails.technology
            it
        }
    }

    override fun bookPhone(phoneId: Long, user: String) {
        val phone = phoneGateway.getAvailablePhoneById(phoneId)
            ?: throw UnavailablePhoneException("Phone with id $phoneId isn't available.")
        this.book(phone, user)
    }

    private fun book(phone: Phone, user: String) {
        phone.available = false
        phone.bookedTime = LocalDateTime.now()
        phone.bookedBy = user
        phoneGateway.persistPhone(phone)
    }

    override fun returnBookedPhone(phoneId: Long) {
        val phone =
            phoneGateway.getPhoneById(phoneId) ?: throw PhoneNotFoundException("Phone with id $phoneId was not found.")
        phone.available = true
        phone.bookedBy = null
        phoneGateway.persistPhone(phone)
    }
}