package com.autentia.example.micronaut.todo

import java.time.LocalDateTime

data class Todo(
    val id: Int? = null,
    val title: String,
    val creationDate: LocalDateTime,
    val doneDate: LocalDateTime? = null
)
