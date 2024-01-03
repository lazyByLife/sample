package com.lazybylife.sample.domain.member.persistence.repository

import com.lazybylife.sample.domain.member.persistence.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
}