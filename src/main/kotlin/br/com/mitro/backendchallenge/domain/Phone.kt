package br.com.mitro.backendchallenge.domain

import java.time.LocalDateTime

data class Phone(
    val id: Long,
    val name: String,
    val brandName: String,
    var available: Boolean,
    var bookedTime: LocalDateTime? = null,
    var bookedBy: String? = null,
    var technology: String? = null,
    var bands2g: String? = null,
    var bands3g: String? = null,
    var bands4g: String? = null,
)