package com.lazybylife.sample.global.wrapper

import com.lazybylife.sample.global.exception.ErrorCode

data class ErrorResponse(val error: ErrorCode, val description: String)