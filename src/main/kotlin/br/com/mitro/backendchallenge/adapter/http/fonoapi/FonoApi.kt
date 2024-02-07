package br.com.mitro.backendchallenge.adapter.http.fonoapi

import br.com.mitro.backendchallenge.adapter.http.fonoapi.dto.PhoneDetailsResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "\${feign.name}", url = "\${feign.url}", fallbackFactory = FonoApiFallbackFactory::class)
interface FonoApi {
    @GetMapping("/v1/getdevice")
    fun getDevice(
        @RequestParam("token") token: String,
        @RequestParam("device") device: String,
        @RequestParam("brand") brand: String? = null,
        @RequestParam("position") position: Int? = null,
    ): PhoneDetailsResponse
}