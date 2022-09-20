package net.intact.tuto.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class Meta(
    val assigneeTo: String
)

@Introspected
data class Todo(
    val id: Int?,
    val description: String,
    val completed: Boolean,
    val meta: Meta
)

