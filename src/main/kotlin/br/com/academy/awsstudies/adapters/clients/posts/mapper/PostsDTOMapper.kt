package br.com.academy.awsstudies.adapters.clients.posts.mapper

import br.com.academy.awsstudies.adapters.clients.posts.dto.PostsDTO
import br.com.academy.awsstudies.domain.Posts

object PostsDTOMapper {
    fun PostsDTO.toDomain() : Posts =
        Posts(
            userId = this.userId,
            id = this.id,
            title = this.title,
            body = this.body
        )
}