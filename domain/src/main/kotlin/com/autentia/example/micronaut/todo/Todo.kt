package com.autentia.example.micronaut.todo

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime

@Introspected
data class Todo(
    val id: Int? = null,
    val title: String,
    val creationDate: LocalDateTime,
    val doneDate: LocalDateTime? = null
)
