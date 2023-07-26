package br.com.academy.awsstudies.adapters.clients.comments

import br.com.academy.awsstudies.adapters.clients.comments.mapper.CommentsDTOMapper.toDomain
import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.application.outputs.CommentsService
import br.com.academy.awsstudies.domain.Comments
import feign.FeignException
import org.springframework.stereotype.Service

@Service
class CommentsServiceImpl(
    private val commentsClients: CommentsClients
) : CommentsService {

    override fun getComments(commentsParams: CommentsParams): List<Comments> {
        try {
            return commentsClients.getComments(commentsParams).map { it.toDomain() }
        } catch (exception: FeignException) {
            throw exception
        }
    }
}