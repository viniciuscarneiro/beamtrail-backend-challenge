package br.com.mitro.backendchallenge.adapter.repository.h2

import br.com.mitro.backendchallenge.adapter.repository.h2.entity.PhoneEntity
import org.springframework.data.repository.CrudRepository

interface H2PhoneRepository : CrudRepository<PhoneEntity, Long> {
    override fun findAll(): List<PhoneEntity>
    fun findPhoneEntitiesByNameIsLikeIgnoreCaseOrBrandNameIsLikeIgnoreCase(
        name: String,
        brandName: String,
    ): List<PhoneEntity>?

    fun findPhoneEntityByIdAndAvailableIs(id: Long, available: Boolean): PhoneEntity?
    fun findPhoneEntityById(id: Long): PhoneEntity?
}