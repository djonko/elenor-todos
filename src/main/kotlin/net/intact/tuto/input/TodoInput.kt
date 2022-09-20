package net.intact.tuto.input

import io.micronaut.core.annotation.Introspected

@Introspected
data class MetaInput(
    val assigneeTo: String
)

@Introspected
data class TodoInput(
    val id: Int,
    val description: String,
    val completed: Boolean,
    val meta: MetaInput
)