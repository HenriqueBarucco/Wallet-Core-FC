package com.henriquebarucco.msbalancefc.application.usecase

interface InputUseCase<INPUT, OUTPUT> {
    fun execute(input: INPUT): OUTPUT
}
