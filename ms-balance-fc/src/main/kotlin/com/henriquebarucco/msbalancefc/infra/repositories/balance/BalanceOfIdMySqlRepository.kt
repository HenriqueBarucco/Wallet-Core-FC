package com.henriquebarucco.msbalancefc.infra.repositories.balance

import com.henriquebarucco.msbalancefc.domain.balance.Balance
import com.henriquebarucco.msbalancefc.domain.balance.repository.BalanceOfIdRepository
import com.henriquebarucco.msbalancefc.infra.database.mysql.repository.BalanceRepository
import org.springframework.stereotype.Service

@Service
class BalanceOfIdMySqlRepository(
    private val balanceRepository: BalanceRepository,
) : BalanceOfIdRepository {
    override fun ofId(id: String): Balance? =
        this.balanceRepository
            .findByAccountId(id)
            .map { it.toDomain() }
            .orElse(null)
}
