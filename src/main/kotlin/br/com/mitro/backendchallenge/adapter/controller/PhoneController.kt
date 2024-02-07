package br.com.mitro.backendchallenge.adapter.controller

import br.com.mitro.backendchallenge.domain.Phone
import br.com.mitro.backendchallenge.usecase.PhoneUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/phones")
class PhoneController(val phoneUseCase: PhoneUseCase) {

    @GetMapping
    fun getAvailablePhones(@RequestParam("searchTerm") searchTerm: String?): ResponseEntity<List<Phone>> {
        return ResponseEntity.ok(phoneUseCase.getAvailablePhones(searchTerm))
    }

    @PostMapping("/{phoneId}")
    fun bookPhone(
        @PathVariable("phoneId") phoneId: Long,
        @RequestParam("user") user: String,
    ): ResponseEntity<Any> {
        phoneUseCase.bookPhone(phoneId, user)
        return ResponseEntity.ok().build()
    }

    @PutMapping("/{phoneId}")
    fun returnBookedPhone(@PathVariable("phoneId") phoneId: Long) {
        phoneUseCase.returnBookedPhone(phoneId)
    }
}