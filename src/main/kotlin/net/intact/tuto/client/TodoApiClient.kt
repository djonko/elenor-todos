package net.intact.tuto.client

import io.micronaut.http.HttpHeaders
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.annotation.Client
import net.intact.tuto.model.TodoModel
import reactor.core.publisher.Flux


@Client("\${api.todo.base-url}")
@Headers(
    Header(name = HttpHeaders.ACCEPT, value = "application/vnd.github.v3+json, application/json"),
    Header(name = HttpHeaders.CONTENT_TYPE, value = "application/json")
)
interface TodoApiClient {

    @Get("/api/todos/?apikey=\${api.todo.api-key}")
    fun getTodos(): Flux<TodoModel>
}