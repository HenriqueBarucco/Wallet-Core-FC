package com.henriquebarucco.msbalancefc.infra.entrypoint.kafka

import com.henriquebarucco.msbalancefc.application.balance.UpdateBalanceUseCase
import com.henriquebarucco.msbalancefc.application.balance.dto.UpdateBalanceUseCaseDto
import com.henriquebarucco.msbalancefc.infra.entrypoint.kafka.dto.BalanceUpdatedKafkaMessage
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class BalanceUpdatedKafkaConsumer(
    private val updateBalanceUseCase: UpdateBalanceUseCase,
) {
    private val logger = LoggerFactory.getLogger(BalanceUpdatedKafkaConsumer::class.java)

    @KafkaListener(topics = ["balances"], groupId = "my-group")
    fun processBalanceUpdateMessage(message: String) {
        try {
            val balanceUpdatedKafkaMessage = Json.decodeFromString<BalanceUpdatedKafkaMessage>(message)
            val (accountIdFrom, accountIdTo, balanceAccountIdFrom, balanceAccountIdTo) = balanceUpdatedKafkaMessage.payload

            logger.info("Processing message for accounts: $accountIdFrom, $accountIdTo")

            updateBalance(accountIdFrom, balanceAccountIdFrom)
            updateBalance(accountIdTo, balanceAccountIdTo)
        } catch (e: Exception) {
            logger.error("Failed to process message: $message", e)
            throw e
        }
    }

    private fun updateBalance(
        accountId: String,
        balance: Double,
    ) {
        try {
            this.updateBalanceUseCase.execute(
                UpdateBalanceUseCaseDto.Input(
                    id = accountId,
                    balance = balance,
                ),
            )
            logger.info("Successfully updated balance for account: $accountId")
        } catch (e: Exception) {
            logger.error("Failed to update balance for account: $accountId", e)
            throw e
        }
    }
}
