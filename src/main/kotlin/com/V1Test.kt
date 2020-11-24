package com


import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
class V1Test {

    @GetMapping(
        value = ["/test"],
        produces = [MediaType.TEXT_PLAIN_VALUE]
    )
    fun main(): Mono<String> {
        return Mono.just("Hello")
    }

}