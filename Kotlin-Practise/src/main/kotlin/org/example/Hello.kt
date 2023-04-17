package org.example

import kotlinx.coroutines.*
import org.jetbrains.annotations.TestOnly

fun main(args: Array<String>) {
    GlobalScope.launch(Dispatchers.IO) {
        println("Coroutine stared:${Thread.currentThread().name}")
        delay(1000L)
        println("Hello World!")
    }

    Thread.sleep(3000L)
}