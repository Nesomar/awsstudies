package br.com.academy.awsstudies.adapters.clients.posts

import br.com.academy.awsstudies.adapters.clients.comments.mapper.CommentsDTOMapper.toDomain
import br.com.academy.awsstudies.adapters.clients.posts.mapper.PostsDTOMapper.toDomain
import br.com.academy.awsstudies.application.outputs.PostsService
import br.com.academy.awsstudies.domain.Comments
import br.com.academy.awsstudies.domain.Posts
import feign.FeignException
import org.springframework.stereotype.Service

@Service
class PostsServiceImpl(
    private val postsClient: PostsClient
) : PostsService {

    override fun getAll(): List<Posts> {
        try {
            return postsClient.getAll().map { it.toDomain() }
        } catch (exception: FeignException) {
            throw exception
        }
    }

    override fun getById(id: Int): Posts {
        try {
            return postsClient.getById(id).toDomain()
        } catch (exception: FeignException) {
            throw exception
        }
    }

    override fun getComments(id: Int): List<Comments> {
        try {
            return postsClient.getComments(id).map { it.toDomain() }
        } catch (exception: FeignException) {
            throw exception
        }
    }
}