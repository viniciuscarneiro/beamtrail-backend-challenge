package br.com.mitro.backendchallenge.adapter.repository

import br.com.mitro.backendchallenge.adapter.repository.h2.H2PhoneRepository
import br.com.mitro.backendchallenge.adapter.repository.h2.entity.PhoneEntity
import br.com.mitro.backendchallenge.domain.Phone
import org.springframework.stereotype.Component

@Component
class PhoneRepositoryImpl(val h2PhoneRepository: H2PhoneRepository) : PhoneRepository {
    override fun findPhoneByNameOrBrand(searchTerm: String): List<Phone> {
        return h2PhoneRepository.findPhoneEntitiesByNameIsLikeIgnoreCaseOrBrandNameIsLikeIgnoreCase(
            searchTerm,
            searchTerm
        )
            ?.map { it.toDomain() } ?: emptyList()
    }

    override fun saveOrUpdatePhone(phone: Phone) {
        h2PhoneRepository.save(PhoneEntity.fromDomain(phone))
    }

    override fun findAvailablePhoneById(id: Long): Phone? {
        return h2PhoneRepository.findPhoneEntityByIdAndAvailableIs(id, true)?.toDomain()
    }

    override fun findPhoneById(id: Long): Phone? {
        return h2PhoneRepository.findPhoneEntityById(id)?.toDomain()
    }

    override fun findAllPhones(): List<Phone> {
        return h2PhoneRepository.findAll().map { it.toDomain() }
    }
}