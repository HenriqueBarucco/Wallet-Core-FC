package com.henriquebarucco.msbalancefc.domain.balance.repository

import com.henriquebarucco.msbalancefc.domain.balance.Balance

interface BalanceOfIdRepository {
    fun ofId(id: String): Balance?
}
