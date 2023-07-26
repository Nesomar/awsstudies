package br.com.academy.awsstudies.adapters.http

import br.com.academy.awsstudies.adapters.http.dto.CommentsResponse
import br.com.academy.awsstudies.adapters.http.dto.PostsResponse
import br.com.academy.awsstudies.adapters.http.mappers.CommentsResponseMapper.toResponse
import br.com.academy.awsstudies.adapters.http.mappers.PostsResponseMapper.toResponse
import br.com.academy.awsstudies.application.inputs.PostsUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostsController(
    private val postsUsecase: PostsUsecase
) {

    @GetMapping
    fun getAll() : List<PostsResponse> {
        return postsUsecase.getAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) : PostsResponse {
        return postsUsecase.getById(id).toResponse()
    }

    @GetMapping("/{id}/comments")
    fun getComments(@PathVariable id: Int) : List<CommentsResponse> {
        return postsUsecase.getComments(id).map { it.toResponse() }
    }
}