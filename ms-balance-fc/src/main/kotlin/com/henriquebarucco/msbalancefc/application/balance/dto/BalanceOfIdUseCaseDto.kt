package com.henriquebarucco.msbalancefc.application.balance.dto

class BalanceOfIdUseCaseDto {
    data class Input(
        val id: String,
    )

    data class Output(
        val id: String,
        val balance: Double,
    )
}
