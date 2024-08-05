package com.alperen.cryptocurrency.data.repository

import com.alperen.cryptocurrency.data.remote.TodoApi
import com.alperen.cryptocurrency.data.remote.dto.todo_dto.TodoDto
import com.alperen.cryptocurrency.domain.repository.ToDoRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val api: TodoApi
) : ToDoRepository {
    override suspend fun getToDos(page: Int, limit: Int): List<TodoDto> {
        delay(3000L)
        return api.getTodos(page, limit)
    }
}