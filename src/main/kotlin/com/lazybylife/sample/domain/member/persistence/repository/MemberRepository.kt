package com.lazybylife.sample.domain.member.persistence.repository

import com.lazybylife.sample.domain.member.code.MemberStatus
import com.lazybylife.sample.domain.member.persistence.entity.Member
import com.lazybylife.sample.domain.member.persistence.repository.custom.MemberCustomRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface MemberRepository : JpaRepository<Member, Long>, MemberCustomRepository {

    fun existsByEmail(email: String) : Boolean

    // NO USE
    fun findByStatus(status: MemberStatus) : List<Member>

    // NO USE
    @Query("SELECT member FROM Member member WHERE member.email like %:domain% AND member.createdAt >= :startAt AND member.createdAt < :endAt")
    fun querySearch(@Param("domain") domain: String, @Param("startAt") startAt: LocalDateTime, @Param("endAt") endAt: LocalDateTime) : List<Member>

}