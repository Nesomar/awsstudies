package br.com.academy.awsstudies.application.usecase

import br.com.academy.awsstudies.application.inputs.PostsUsecase
import br.com.academy.awsstudies.application.outputs.PostsService
import br.com.academy.awsstudies.domain.Comments
import br.com.academy.awsstudies.domain.Posts
import org.springframework.stereotype.Component

@Component
class PostsUsecaseImpl(
    private val postsService: PostsService
) : PostsUsecase {

    override fun getAll(): List<Posts> = postsService.getAll()

    override fun getById(id: Int): Posts = postsService.getById(id)

    override fun getComments(id: Int): List<Comments> = postsService.getComments(id)
}