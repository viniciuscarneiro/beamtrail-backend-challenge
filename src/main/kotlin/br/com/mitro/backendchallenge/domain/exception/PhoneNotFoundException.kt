package br.com.mitro.backendchallenge.domain.exception

class PhoneNotFoundException(override val message: String) : RuntimeException(message) {
}