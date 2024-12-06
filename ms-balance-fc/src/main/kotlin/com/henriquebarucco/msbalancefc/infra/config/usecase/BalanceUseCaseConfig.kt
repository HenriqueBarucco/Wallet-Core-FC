package com.henriquebarucco.msbalancefc.infra.config.usecase

import com.henriquebarucco.msbalancefc.application.balance.BalanceOfIdUseCase
import com.henriquebarucco.msbalancefc.application.balance.UpdateBalanceUseCase
import com.henriquebarucco.msbalancefc.domain.balance.repository.BalanceOfIdRepository
import com.henriquebarucco.msbalancefc.domain.balance.repository.SaveBalanceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BalanceUseCaseConfig(
    private val balanceOfIdRepository: BalanceOfIdRepository,
    private val saveBalanceRepository: SaveBalanceRepository,
) {
    @Bean
    fun updateBalanceUseCase() =
        UpdateBalanceUseCase(
            balanceOfIdRepository = balanceOfIdRepository,
            saveBalanceRepository = saveBalanceRepository,
        )

    @Bean
    fun balanceOfIdRepository() = BalanceOfIdUseCase(balanceOfIdRepository = balanceOfIdRepository)
}
