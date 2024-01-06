package com.example.instargram.global.error

import com.example.instargram.global.error.exception.BusinessException
import com.example.instargram.global.error.exception.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.time.LocalDateTime
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BusinessException) {
            val errorCode = e.errorCode
            val errorResponse = ErrorResponse(errorCode.status, errorCode.message, LocalDateTime.now())
            writeErrorResponse(response, errorCode.status, errorResponse)
        }
    }

    @Throws(IOException::class)
    private fun writeErrorResponse(response: HttpServletResponse, status:Int, errorResponse:
    ErrorResponse) {
        response.status = status
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        objectMapper.writeValue(response.writer,errorResponse)
    }
}
