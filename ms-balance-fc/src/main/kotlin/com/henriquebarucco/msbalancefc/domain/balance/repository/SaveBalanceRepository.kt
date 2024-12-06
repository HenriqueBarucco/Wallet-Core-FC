package com.henriquebarucco.msbalancefc.domain.balance.repository

import com.henriquebarucco.msbalancefc.domain.balance.Balance

interface SaveBalanceRepository {
    fun save(balance: Balance)
}
