package com.alperen.cryptocurrency.data.remote

import com.alperen.cryptocurrency.data.remote.dto.todo_dto.TodoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {
    @GET(value = "/todos")
    suspend fun getTodos(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<TodoDto>

}