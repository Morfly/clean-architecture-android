package com.morfly.cleanarchitecture.core.domainlayer


interface Interactor<in I, out O> {

    fun execute(args: I): O
}

interface ArgumentlessInteractor<out O> {

    fun execute(): O
}