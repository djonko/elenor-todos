package net.intact.tuto.input

import io.micronaut.core.annotation.Introspected
import net.intact.tuto.model.MetaModel
import net.intact.tuto.model.TodoModel
import java.io.Serializable

@Introspected
class MetaInput(
    val assigneeTo: String
)

@Introspected
class TodoInput constructor(
    val description: String,
    val completed: Boolean,
    val meta: MetaInput,
) : Serializable

fun TodoInput.toModel(): TodoModel {
    val todoInput = this
    return TodoModel(
        id = null,
        description = todoInput.description,
        completed = todoInput.completed,
        meta = MetaModel(todoInput.meta.assigneeTo)
    )
}