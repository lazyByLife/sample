package com.lazybylife.sample.domain.member.service

import com.lazybylife.sample.domain.member.dto.MemberResponse
import com.lazybylife.sample.domain.member.dto.SearchMemberRequest
import com.lazybylife.sample.domain.member.dto.SignUpRequest
import com.lazybylife.sample.domain.member.persistence.dao.MemberDao
import com.lazybylife.sample.global.wrapper.PageResponse
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

    @Transactional(readOnly = true)
    fun search(request: SearchMemberRequest) : PageResponse<MemberResponse> {
        val members = dao.search(request)
        val memberResponses = members.content.map {
            MemberResponse(it)
        }
        return PageResponse(members.totalElements, memberResponses)
    }
}