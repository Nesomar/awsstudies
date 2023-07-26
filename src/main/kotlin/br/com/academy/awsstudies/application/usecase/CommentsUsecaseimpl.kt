package br.com.academy.awsstudies.application.usecase

import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.application.inputs.CommentsUsecase
import br.com.academy.awsstudies.application.outputs.CommentsService
import br.com.academy.awsstudies.domain.Comments
import org.springframework.stereotype.Component

@Component
class CommentsUsecaseimpl(
    private val commentsService: CommentsService
) : CommentsUsecase {

    override fun getComments(commentsParams: CommentsParams): List<Comments> =
        commentsService.getComments(commentsParams)
}