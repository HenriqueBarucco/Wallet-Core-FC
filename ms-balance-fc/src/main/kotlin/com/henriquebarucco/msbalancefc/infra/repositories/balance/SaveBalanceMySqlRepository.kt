package com.henriquebarucco.msbalancefc.infra.repositories.balance

import com.henriquebarucco.msbalancefc.domain.balance.Balance
import com.henriquebarucco.msbalancefc.domain.balance.repository.SaveBalanceRepository
import com.henriquebarucco.msbalancefc.infra.database.mysql.entity.toEntity
import com.henriquebarucco.msbalancefc.infra.database.mysql.repository.BalanceRepository
import org.springframework.stereotype.Service

@Service
class SaveBalanceMySqlRepository(
    private val balanceRepository: BalanceRepository,
) : SaveBalanceRepository {
    override fun save(balance: Balance) {
        val entity = this.balanceRepository.findByAccountId(balance.id)
        val id = if (entity.isPresent) entity.get().id else null

        this.balanceRepository.save(balance.toEntity(id))
    }
}
