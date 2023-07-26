package br.com.academy.awsstudies.adapters.http.dto

data class CommentsResponse(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
