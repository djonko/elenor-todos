package net.intact.tuto

import graphql.schema.DataFetcher
import jakarta.inject.Singleton
import net.intact.tuto.client.TodoApiClient
import net.intact.tuto.dto.Todo
import net.intact.tuto.model.toDto
import java.util.stream.Stream

@Singleton
class TodoResolver(private val todoApiClient: TodoApiClient) {

    fun getTodos(): DataFetcher<Stream<Todo>> {
        val todos = todoApiClient.getTodos().map {
            it.toDto()
        }

        return DataFetcher {
            todos.toStream()
        }

    }

}