package com.henriquebarucco.msbalancefc.infra.database.mysql.entity

import com.henriquebarucco.msbalancefc.domain.balance.Balance
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "balances")
data class BalanceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "account_id", nullable = false, unique = true)
    val accountId: String,
    @Column(name = "amount", nullable = false, unique = false)
    val amount: Double,
    @Column(name = "updated_at", nullable = true, unique = false)
    val updatedAt: LocalDateTime?,
    @Column(name = "created_at", nullable = false, unique = false)
    val createdAt: LocalDateTime,
) {
    fun toDomain() =
        Balance(
            id = this.accountId,
            amount = this.amount,
            updatedAt = this.updatedAt,
            createdAt = this.createdAt,
        )
}

fun Balance.toEntity(id: Long?) =
    BalanceEntity(
        id = id,
        accountId = this.id,
        amount = this.amount,
        updatedAt = this.updatedAt,
        createdAt = this.createdAt,
    )
