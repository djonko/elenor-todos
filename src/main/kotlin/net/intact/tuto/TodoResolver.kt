package net.intact.tuto

import com.fasterxml.jackson.databind.ObjectMapper
import graphql.schema.DataFetcher
import jakarta.inject.Singleton
import net.intact.tuto.client.TodoApiClient
import net.intact.tuto.dto.Todo
import net.intact.tuto.input.TodoInput
import net.intact.tuto.input.toModel
import net.intact.tuto.model.toDto
import java.util.stream.Stream

@Singleton
class TodoResolver(
    private val todoApiClient: TodoApiClient,
    private val objectMapper: ObjectMapper
) {

    fun getTodos(): DataFetcher<Stream<Todo>> = DataFetcher {
        val todos = todoApiClient.getTodos().map {
            it.toDto()
        }
        todos.toStream()
    }

    fun getTodoById() = DataFetcher {
        val idTodo = it.getArgument<Int>("id")
        todoApiClient.getTodoById(idTodo).map { response -> response.toDto() }.toFuture()
    }

    fun addTodo() = DataFetcher { env ->
        val todo = objectMapper.convertValue(env.arguments["input"], TodoInput::class.java)

        todoApiClient.addTodo(
            todo.toModel()
        ).map { response -> response.toDto() }.toFuture()
    }

}