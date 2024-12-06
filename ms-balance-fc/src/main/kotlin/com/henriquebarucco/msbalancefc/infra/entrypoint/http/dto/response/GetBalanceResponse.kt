package com.henriquebarucco.msbalancefc.infra.entrypoint.http.dto.response

data class GetBalanceResponse(
    val id: String,
    val amount: Double,
)
