package com.alperen.cryptocurrency.ui

import com.alperen.cryptocurrency.domain.model.ToDo

data class ToDoListState(
    val isLoading: Boolean = false,
    val todos: List<ToDo>? = emptyList(),
    val error: String? = ""
)