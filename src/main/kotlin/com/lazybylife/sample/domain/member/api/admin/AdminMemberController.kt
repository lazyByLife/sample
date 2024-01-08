package com.lazybylife.sample.domain.member.api.admin

import com.lazybylife.sample.domain.member.code.MemberStatus
import com.lazybylife.sample.domain.member.dto.MemberResponse
import com.lazybylife.sample.domain.member.dto.SearchMemberRequest
import com.lazybylife.sample.domain.member.service.MemberService
import com.lazybylife.sample.global.wrapper.PageResponse
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/admin/member")
class AdminMemberController(
    private val service: MemberService
) {

    @GetMapping("")
    fun search(
        @RequestParam(required = false) status: MemberStatus?,
        @RequestParam(required = false) domain: String?,
        @RequestParam(required = false) startAt: LocalDate?,
        @RequestParam(required = false) endAt: LocalDate?,
        @RequestParam(required = false, defaultValue = "1") page: Int,
        @RequestParam(required = false, defaultValue = "20") size: Int
    ) : PageResponse<MemberResponse> {

        val request = SearchMemberRequest(
            status = status,
            domain = domain,
            startAt = startAt?.atStartOfDay(),
            endAt = endAt?.plusDays(1)?.atStartOfDay(),
            pageable = PageRequest.of(page - 1, size)
        )

        return service.search(request)
    }
}