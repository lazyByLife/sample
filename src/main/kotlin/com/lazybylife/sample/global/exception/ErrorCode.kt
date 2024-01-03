package com.lazybylife.sample.global.exception

enum class ErrorCode(private val description: String) {
    SAMPLE_ERROR("미정의 에러"),
    BAD_REQUEST("잘못된 요청");

    fun getDescription(): String {
        return description
    }
}