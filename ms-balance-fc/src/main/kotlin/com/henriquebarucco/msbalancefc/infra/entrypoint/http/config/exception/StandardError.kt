package com.henriquebarucco.msbalancefc.infra.entrypoint.http.config.exception

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class StandardError(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:SS dd-MM-yyyy", timezone = "GMT")
    val timestamp: Instant = Instant.now(),
    val status: Int,
    val message: String?,
    val path: String,
)
