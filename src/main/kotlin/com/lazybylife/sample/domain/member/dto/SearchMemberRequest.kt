package com.lazybylife.sample.domain.member.dto

import com.lazybylife.sample.domain.member.code.MemberStatus
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

data class SearchMemberRequest(
    val status: MemberStatus?,
    val domain: String?,
    val startAt: LocalDateTime?,
    val endAt: LocalDateTime?,
    val pageable: Pageable
) {
}