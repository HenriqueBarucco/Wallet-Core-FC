package com.henriquebarucco.msbalancefc.application.balance

import com.henriquebarucco.msbalancefc.application.balance.dto.BalanceOfIdUseCaseDto.Input
import com.henriquebarucco.msbalancefc.application.balance.dto.BalanceOfIdUseCaseDto.Output
import com.henriquebarucco.msbalancefc.application.usecase.UseCase
import com.henriquebarucco.msbalancefc.domain.balance.repository.BalanceOfIdRepository
import com.henriquebarucco.msbalancefc.domain.shared.exception.ResourceNotFoundException
import kotlin.jvm.Throws

class BalanceOfIdUseCase(
    private val balanceOfIdRepository: BalanceOfIdRepository,
) : UseCase<Input, Output> {
    @Throws(ResourceNotFoundException::class)
    override fun execute(input: Input): Output {
        val balance = this.balanceOfIdRepository.ofId(input.id) ?: throw ResourceNotFoundException("Balance not found")

        return Output(
            id = balance.id,
            amount = balance.amount,
        )
    }
}
