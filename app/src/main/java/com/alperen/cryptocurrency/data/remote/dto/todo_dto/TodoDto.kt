package com.alperen.cryptocurrency.data.remote.dto.todo_dto

import com.alperen.cryptocurrency.domain.model.ToDo

data class TodoDto(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)

fun TodoDto.toModel(): ToDo = ToDo(id, title)