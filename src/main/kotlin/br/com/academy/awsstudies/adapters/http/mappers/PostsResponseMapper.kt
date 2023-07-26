package br.com.academy.awsstudies.adapters.http.mappers

import br.com.academy.awsstudies.adapters.http.dto.PostsResponse
import br.com.academy.awsstudies.domain.Posts

object PostsResponseMapper {

    fun Posts.toResponse() : PostsResponse =
        PostsResponse(
            userId = this.userId,
            id = this.id,
            title = this.title,
            body = this.body
        )
}