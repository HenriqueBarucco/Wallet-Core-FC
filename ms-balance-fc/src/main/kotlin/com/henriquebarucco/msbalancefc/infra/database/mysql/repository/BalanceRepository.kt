package com.henriquebarucco.msbalancefc.infra.database.mysql.repository

import com.henriquebarucco.msbalancefc.infra.database.mysql.entity.BalanceEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface BalanceRepository : JpaRepository<BalanceEntity, Long> {
    fun findByAccountId(accountId: String): Optional<BalanceEntity>
}
