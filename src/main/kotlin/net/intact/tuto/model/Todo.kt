package net.intact.tuto.model

import io.micronaut.core.annotation.Introspected
import net.intact.tuto.dto.Meta
import net.intact.tuto.dto.Todo

@Introspected
data class MetaModel(
    val assigneeTo: String
)

@Introspected
data class TodoModel(
    val id: Int,
    val description: String,
    val completed: Boolean,
    val meta: MetaModel
)

fun TodoModel.toDto(): Todo {
    val model = this
    return Todo(
        id = model.id,
        description = model.description,
        completed = model.completed,
        meta = Meta(model.meta.assigneeTo)
    )
}
