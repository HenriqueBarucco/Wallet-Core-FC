package com.henriquebarucco.msbalancefc.application.balance.dto

class UpdateBalanceUseCaseDto {
    data class Input(
        val id: String,
        val balance: Double,
    )
}
