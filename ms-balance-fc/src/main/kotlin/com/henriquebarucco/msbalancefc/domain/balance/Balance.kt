package com.henriquebarucco.msbalancefc.domain.balance

import java.time.LocalDateTime

data class Balance(
    val id: String,
    var amount: Double,
    var updatedAt: LocalDateTime? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    companion object {
        fun new(
            id: String,
            amount: Double,
        ): Balance = Balance(id = id, amount = amount)
    }

    fun update(amount: Double) {
        this.amount = amount
        this.updatedAt = LocalDateTime.now()
    }
}
