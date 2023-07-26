package br.com.academy.awsstudies.adapters.clients.posts

import br.com.academy.awsstudies.adapters.clients.comments.dto.CommentsDTO
import br.com.academy.awsstudies.adapters.clients.posts.dto.PostsDTO
import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "postsClient", url = "https://jsonplaceholder.typicode.com")
interface PostsClient {

    @GetMapping(value = ["/posts"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
     fun getAll(): List<PostsDTO>

    @GetMapping(value = ["/posts/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
     fun getById(@PathVariable id: Int): PostsDTO

    @GetMapping(value = ["/posts/{id}/comments"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
     fun getComments(@PathVariable id: Int): List<CommentsDTO>
}