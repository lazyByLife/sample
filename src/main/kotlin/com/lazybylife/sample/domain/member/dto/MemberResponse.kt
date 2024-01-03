package com.lazybylife.sample.domain.member.dto

import com.lazybylife.sample.domain.member.persistence.entity.Member
import java.time.LocalDateTime

data class MemberResponse(
    val id: Long,
    val email: String,
    val createdAt: LocalDateTime
) {
    constructor(member: Member) : this(
        id = member.id!!,
        email = member.email,
        createdAt = member.createdAt
    )
}
