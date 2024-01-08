package com.lazybylife.sample.global.advice

import com.lazybylife.sample.global.exception.BadRequestException
import com.lazybylife.sample.global.exception.NotFoundException
import com.lazybylife.sample.global.wrapper.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequest(exception: BadRequestException): ErrorResponse {
        return ErrorResponse(exception.error, exception.description)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: NotFoundException): ErrorResponse {
        return ErrorResponse(exception.error, exception.description)
    }
}