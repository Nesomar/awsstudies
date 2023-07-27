package br.com.academy.awsstudies.builders

import br.com.academy.awsstudies.adapters.clients.posts.dto.PostsDTO
import br.com.academy.awsstudies.domain.Posts

object PostsBuilder {

    fun builder(): Posts = Posts(
        id = Int.MAX_VALUE,
        body = "\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
        title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        userId = Int.MAX_VALUE
    )

    fun dtoBuilder(): PostsDTO = PostsDTO(
        id = Int.MAX_VALUE,
        body = "\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
        title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        userId = Int.MAX_VALUE
    )
}