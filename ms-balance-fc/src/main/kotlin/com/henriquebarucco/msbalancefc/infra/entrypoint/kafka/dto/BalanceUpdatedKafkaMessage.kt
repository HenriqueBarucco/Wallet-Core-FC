package com.henriquebarucco.msbalancefc.infra.entrypoint.kafka.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BalanceUpdatedKafkaMessage(
    @SerialName("Name")
    val name: String,
    @SerialName("Payload")
    val payload: Payload,
)

@Serializable
data class Payload(
    @SerialName("account_id_from")
    val accountIdFrom: String,
    @SerialName("account_id_to")
    val accountIdTo: String,
    @SerialName("balance_account_id_from")
    val balanceAccountIdFrom: Double,
    @SerialName("balance_account_id_to")
    val balanceAccountIdTo: Double,
)
