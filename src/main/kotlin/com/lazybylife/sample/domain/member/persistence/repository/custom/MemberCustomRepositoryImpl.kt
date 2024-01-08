package com.lazybylife.sample.domain.member.persistence.repository.custom

import com.lazybylife.sample.domain.member.code.MemberStatus
import com.lazybylife.sample.domain.member.dto.SearchMemberRequest
import com.lazybylife.sample.domain.member.persistence.entity.Member
import com.lazybylife.sample.domain.member.persistence.entity.QMember.member
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class MemberCustomRepositoryImpl(
    private val factory: JPAQueryFactory
) : MemberCustomRepository {
    override fun search(request: SearchMemberRequest): Page<Member> {
        val memberList =  searchList(request)
            .select(member)
            .fetch()

        val count = whereCondition(request)
            .select(member.count())
            .fetchOne() ?: 0L

        return PageImpl(memberList, request.pageable, count)
    }

    private fun searchList(request: SearchMemberRequest) : JPAQuery<*> {
        return whereCondition(request)
            .offset(request.pageable.offset)
            .limit(request.pageable.pageSize.toLong())
    }

    private fun whereCondition(request: SearchMemberRequest) : JPAQuery<*> {
        return factory
            .from(member)
            .where(
                eqStatus(request.status),
                likeDomain(request.domain),
                goeStartAt(request.startAt),
                ltEndAt(request.endAt)
            )
    }

    private fun eqStatus(status: MemberStatus?) : BooleanExpression? {
        return status?.let { member.status.eq(status) }
    }

    private fun likeDomain(domain: String?) : BooleanExpression? {
        return domain?.let { member.email.like("%$domain%") }
    }

    private fun goeStartAt(startAt: LocalDateTime?) : BooleanExpression? {
        return startAt?.let { member.createdAt.goe(startAt) }
    }

    private fun ltEndAt(endAt: LocalDateTime?) : BooleanExpression? {
        return endAt?.let { member.createdAt.lt(endAt) }
    }
}