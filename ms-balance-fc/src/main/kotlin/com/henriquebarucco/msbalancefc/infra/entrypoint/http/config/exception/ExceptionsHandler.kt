package com.henriquebarucco.msbalancefc.infra.entrypoint.http.config.exception

import com.henriquebarucco.msbalancefc.domain.shared.exception.ResourceNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionsHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(
        e: ResourceNotFoundException,
        request: HttpServletRequest,
    ): ResponseEntity<StandardError> {
        val status = HttpStatus.NOT_FOUND
        val err =
            StandardError(
                status = status.value(),
                message = e.message,
                path = request.requestURI,
            )

        return ResponseEntity.status(status).body(err)
    }
}
