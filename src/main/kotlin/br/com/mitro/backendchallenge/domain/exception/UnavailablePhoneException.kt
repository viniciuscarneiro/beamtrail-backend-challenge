package br.com.mitro.backendchallenge.domain.exception

class UnavailablePhoneException(override val message: String) : RuntimeException(message) {
}