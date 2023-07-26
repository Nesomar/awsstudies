package br.com.academy.awsstudies.adapters.http.mappers

import br.com.academy.awsstudies.adapters.http.dto.CommentsResponse
import br.com.academy.awsstudies.domain.Comments

object CommentsResponseMapper {

    fun Comments.toResponse(): CommentsResponse =
        CommentsResponse(
            postId = this.postId,
            id = this.id,
            name = this.name,
            email = this.email,
            body = this.body
        )
}