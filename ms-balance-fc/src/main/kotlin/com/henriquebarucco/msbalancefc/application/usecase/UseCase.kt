package com.henriquebarucco.msbalancefc.application.usecase

interface UseCase<INPUT, OUTPUT> {
    fun execute(input: INPUT): OUTPUT
}
