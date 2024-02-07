package br.com.mitro.backendchallenge.domain.exception

class UnableToFetchDetailsException(override val message: String) : RuntimeException(message) {
}