package com.autentia.example.micronaut.todo.persistence

import com.autentia.example.micronaut.todo.Todo

interface TodoRepository {

    fun findAll(): List<Todo>

    fun findBy(id: Int): Todo

}
