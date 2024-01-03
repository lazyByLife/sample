package com.lazybylife.sample.global.exception

open class SampleException(
    val error: ErrorCode,
    val description: String,
    throwable: Throwable?
) : RuntimeException(error.name, throwable) {

    constructor() : this(ErrorCode.SAMPLE_ERROR, ErrorCode.SAMPLE_ERROR.getDescription(), null)
    constructor(error: ErrorCode) : this(error, error.getDescription(), null)
    constructor(error: ErrorCode, description: String) : this(error, description, null)
}