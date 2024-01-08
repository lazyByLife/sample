package com.lazybylife.sample.domain.member.persistence.entity

import com.lazybylife.sample.domain.member.code.MemberStatus
import com.lazybylife.sample.domain.member.dto.SignUpRequest
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String,

    @Enumerated(EnumType.STRING)
    val status: MemberStatus,

    @Column
    val createdAt: LocalDateTime,

) {
    constructor(request: SignUpRequest) : this(
        email = request.email,
        status = MemberStatus.ENABLE,
        createdAt = LocalDateTime.now()
    )
}