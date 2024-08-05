package com.alperen.cryptocurrency.domain.repository

import com.alperen.cryptocurrency.data.remote.dto.todo_dto.TodoDto

interface ToDoRepository {
    suspend fun getToDos(page: Int, limit: Int): List<TodoDto>
}