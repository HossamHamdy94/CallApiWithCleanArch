package com.example.callapiwithcleanarch.domain

interface BaseSuspendableUseCase {

    interface UseCaseWithoutParams<O> {
        suspend fun execute(): O
    }

    interface UseCaseWithParams<I, O> {
        suspend fun execute(input: I): O
    }
}
