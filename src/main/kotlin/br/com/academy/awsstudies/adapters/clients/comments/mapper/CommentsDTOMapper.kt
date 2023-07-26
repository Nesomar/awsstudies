package br.com.academy.awsstudies.adapters.clients.comments.mapper

import br.com.academy.awsstudies.adapters.clients.comments.dto.CommentsDTO
import br.com.academy.awsstudies.domain.Comments

object CommentsDTOMapper {

    fun CommentsDTO.toDomain(): Comments =
        Comments(
            postId = this.postId,
            id = this.id,
            name = this.name,
            email = this.email,
            body = this.body
        )
}