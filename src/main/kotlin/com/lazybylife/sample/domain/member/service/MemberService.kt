package com.lazybylife.sample.domain.member.service

import com.lazybylife.sample.domain.member.dto.MemberResponse
import com.lazybylife.sample.domain.member.dto.SignUpRequest
import com.lazybylife.sample.domain.member.persistence.dao.MemberDao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val dao: MemberDao
) {

    @Transactional
    fun signUp(request: SignUpRequest) : MemberResponse {
        val member = dao.create(request)
        return MemberResponse(member)
    }
}