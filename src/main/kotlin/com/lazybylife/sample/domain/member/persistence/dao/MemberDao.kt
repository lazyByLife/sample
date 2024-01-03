package com.lazybylife.sample.domain.member.persistence.dao

import com.lazybylife.sample.domain.member.dto.SignUpRequest
import com.lazybylife.sample.domain.member.persistence.entity.Member
import com.lazybylife.sample.domain.member.persistence.repository.MemberRepository
import com.lazybylife.sample.global.exception.BadRequestException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberDao(
    private val repository: MemberRepository
) {

    @Transactional
    fun create(request: SignUpRequest) : Member {
        validCreate(request)
        val member = Member(request)
        return repository.save(member)
    }

    fun validCreate(request: SignUpRequest) {
        if (repository.existsByEmail(request.email)) {
            throw BadRequestException("이메일 중복")
        }
    }
}