package com.henriquebarucco.msbalancefc.infra.entrypoint.http

import com.henriquebarucco.msbalancefc.application.balance.BalanceOfIdUseCase
import com.henriquebarucco.msbalancefc.application.balance.dto.BalanceOfIdUseCaseDto
import com.henriquebarucco.msbalancefc.infra.entrypoint.http.dto.response.GetBalanceResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/balances")
@RestController
class BalanceController(
    private val balanceOfIdUseCase: BalanceOfIdUseCase,
) {
    @GetMapping("{id}")
    fun getBalance(
        @PathVariable id: String,
    ): ResponseEntity<GetBalanceResponse> {
        val balance = this.balanceOfIdUseCase.execute(BalanceOfIdUseCaseDto.Input(id))

        return ResponseEntity.ok(GetBalanceResponse(balance.id, balance.amount))
    }
}
