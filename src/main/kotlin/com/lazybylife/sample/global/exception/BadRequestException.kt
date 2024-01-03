package com.lazybylife.sample.global.exception

class BadRequestException(
    error: ErrorCode,
    description: String,
    throwable: Throwable = Throwable()
) : SampleException(error, description, throwable) {

    constructor(error: ErrorCode) : this(error, error.getDescription())
    constructor(description: String) : this(ErrorCode.BAD_REQUEST, description)
    constructor() : this(ErrorCode.BAD_REQUEST, ErrorCode.BAD_REQUEST.getDescription())
}