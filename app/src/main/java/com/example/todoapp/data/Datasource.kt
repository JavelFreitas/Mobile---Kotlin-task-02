package com.example.todoapp.data

import com.example.todoapp.model.Todo

class Datasource {
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/
    fun loadDefinitions () = mutableListOf<Todo>(
        Todo("Test")
    )

}