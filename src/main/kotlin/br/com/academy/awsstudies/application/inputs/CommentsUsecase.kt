package br.com.academy.awsstudies.application.inputs

import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.domain.Comments

interface CommentsUsecase {

    /**
     * retrieves all comments, if the postId is informed retrieves only the comments of the informed post
     * @param commentsParams
     * @return Comments
     */
    fun getComments(commentsParams: CommentsParams) : List<Comments>
}