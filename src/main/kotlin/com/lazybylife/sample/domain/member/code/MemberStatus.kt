package com.lazybylife.sample.domain.member.code

enum class MemberStatus(private val description: String) {

    ENABLE("활성화"),
    DORMANT("휴면"),
    WITHDRAWAL("탈퇴");

    fun getDescription(): String {
        return description
    }
}