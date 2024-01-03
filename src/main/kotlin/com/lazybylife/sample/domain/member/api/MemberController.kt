package com.lazybylife.sample.domain.member.api

import com.lazybylife.sample.domain.member.dto.MemberResponse
import com.lazybylife.sample.domain.member.dto.SignUpRequest
import com.lazybylife.sample.domain.member.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MemberController(
    private val service: MemberService
) {

    @PostMapping("/v1/member")
    fun signUp(@RequestBody request: SignUpRequest) : MemberResponse {
        return service.signUp(request)
    }
}