package br.com.academy.awsstudies.adapters.clients.comments.dto

data class CommentsDTO(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
