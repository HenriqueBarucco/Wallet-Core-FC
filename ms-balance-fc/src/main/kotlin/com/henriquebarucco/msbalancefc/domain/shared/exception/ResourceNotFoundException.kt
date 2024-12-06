package com.henriquebarucco.msbalancefc.domain.shared.exception

class ResourceNotFoundException(
    override val message: String?,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause)
