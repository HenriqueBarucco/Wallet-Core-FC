package com.henriquebarucco.msbalancefc.application.balance

import com.henriquebarucco.msbalancefc.application.balance.dto.UpdateBalanceUseCaseDto.Input
import com.henriquebarucco.msbalancefc.application.usecase.InputUseCase
import com.henriquebarucco.msbalancefc.domain.balance.Balance
import com.henriquebarucco.msbalancefc.domain.balance.repository.BalanceOfIdRepository
import com.henriquebarucco.msbalancefc.domain.balance.repository.SaveBalanceRepository

class UpdateBalanceUseCase(
    private val balanceOfIdRepository: BalanceOfIdRepository,
    private val saveBalanceRepository: SaveBalanceRepository,
) : InputUseCase<Input> {
    override fun execute(input: Input) {
        val balance = this.balanceOfIdRepository.ofId(input.id) ?: Balance.new(input.id, input.balance)

        balance.update(amount = input.balance)

        this.saveBalanceRepository.save(balance)
    }
}
