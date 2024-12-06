package com.henriquebarucco.msbalancefc.application.usecase

interface InputUseCase<INPUT> {
    fun execute(input: INPUT)
}
