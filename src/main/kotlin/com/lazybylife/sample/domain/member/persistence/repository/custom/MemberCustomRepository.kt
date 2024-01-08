package com.lazybylife.sample.domain.member.persistence.repository.custom

import com.lazybylife.sample.domain.member.dto.SearchMemberRequest
import com.lazybylife.sample.domain.member.persistence.entity.Member
import org.springframework.data.domain.Page

interface MemberCustomRepository {

    fun search(request: SearchMemberRequest) : Page<Member>
}