package br.com.mitro.backendchallenge.adapter.http.fonoapi

import org.slf4j.LoggerFactory
import org.springframework.cloud.openfeign.FallbackFactory
import org.springframework.stereotype.Component

@Component
class FonoApiFallbackFactory(val fonoApiStaticFallback: FonoApiStaticFallback) :
    FallbackFactory<FonoApi> {

    companion object {
        private val log = LoggerFactory.getLogger(FonoApiFallbackFactory::class.java)
    }

    override fun create(cause: Throwable?): FonoApi {
        log.error("Unexpected error while fetching data on FonoApi, fallback will return default value.", cause)
        return fonoApiStaticFallback
    }
}