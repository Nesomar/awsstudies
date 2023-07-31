package br.com.academy.awsstudies.builders

import br.com.academy.awsstudies.adapters.clients.comments.dto.CommentsDTO
import br.com.academy.awsstudies.domain.Comments

object CommentsBuilder {

    fun builder(): Comments = Comments(
        id = Int.MAX_VALUE,
        body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium",
        name = "id labore ex et quam laborum",
        email = "Jayne_Kuhic@sydney.com",
        postId = Int.MIN_VALUE
    )

    fun dtoBuilder(): CommentsDTO = CommentsDTO(
        id = Int.MAX_VALUE,
        body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium",
        name = "id labore ex et quam laborum",
        email = "Jayne_Kuhic@sydney.com",
        postId = Int.MIN_VALUE
    )
}