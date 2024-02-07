package br.com.mitro.backendchallenge.adapter.repository.h2.entity

import br.com.mitro.backendchallenge.domain.Phone
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "phone_entity")
data class PhoneEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @Column(name = "brand_name")
    val brandName: String,
    var available: Boolean = true,
    @Column(name = "booked_time")
    var bookedTime: LocalDateTime? = null,
    @Column(name = "booked_by")
    var bookedBy: String? = null,
    var technology: String? = null,
    var bands2g: String? = null,
    var bands3g: String? = null,
    var bands4g: String? = null,
) {
    fun toDomain(): Phone {
        return Phone(
            id = this.id,
            name = this.name,
            brandName = this.brandName,
            available = this.available,
            bookedTime = this.bookedTime,
            bookedBy = this.bookedBy,
            technology = this.technology,
            bands2g = this.bands2g,
            bands3g = this.bands3g
        )
    }

    companion object {
        fun fromDomain(phone: Phone): PhoneEntity {
            return PhoneEntity(
                id = phone.id,
                name = phone.name,
                brandName = phone.brandName,
                available = phone.available,
                bookedTime = phone.bookedTime,
                bookedBy = phone.bookedBy,
                technology = phone.technology,
                bands2g = phone.bands2g,
                bands3g = phone.bands3g
            )
        }
    }
}