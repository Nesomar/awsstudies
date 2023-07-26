package br.com.academy.awsstudies.adapters.http.dto

data class PostsResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
