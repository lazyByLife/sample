package com.lazybylife.sample.domain.member.persistence.entity

import com.lazybylife.sample.domain.member.dto.SignUpRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String,

    @Column
    val createdAt: LocalDateTime,

) {
    constructor(request: SignUpRequest) : this(
        email = request.email,
        createdAt = LocalDateTime.now()
    )
}