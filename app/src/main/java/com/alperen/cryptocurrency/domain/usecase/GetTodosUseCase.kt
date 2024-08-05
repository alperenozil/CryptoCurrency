package com.alperen.cryptocurrency.domain.usecase

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alperen.cryptocurrency.common.Resource
import com.alperen.cryptocurrency.data.remote.dto.todo_dto.toModel
import com.alperen.cryptocurrency.domain.model.ToDo
import com.alperen.cryptocurrency.domain.repository.ToDoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(
    private val repo: ToDoRepository
): PagingSource<Int, ToDo>() {
    /*suspend operator fun invoke(): Flow<Resource<List<ToDo>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repo.getToDos(1,20).map { it.toModel() }
            emit(Resource.Success(result))
        } catch (e: HttpException) { // if response code doesnt start with 2
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) { // no internet connection
            emit(Resource.Error(e.localizedMessage ?: "network error"))
        }
    }*/

    override fun getRefreshKey(state: PagingState<Int, ToDo>): Int? = state.anchorPosition


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ToDo> {

        val page = params.key ?: 1
        val response = repo.getToDos(page = page, limit = 15)
        return try {
            LoadResult.Page(
                data = response.map { it.toModel() },
                prevKey = null,
                nextKey = if (response.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}