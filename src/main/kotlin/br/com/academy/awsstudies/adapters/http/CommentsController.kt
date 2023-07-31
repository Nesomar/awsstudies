package br.com.academy.awsstudies.adapters.http

import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.adapters.http.dto.CommentsResponse
import br.com.academy.awsstudies.adapters.http.mappers.CommentsResponseMapper.toResponse
import br.com.academy.awsstudies.application.inputs.CommentsUsecase
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comments")
class CommentsController(
    private val commentsUsecase: CommentsUsecase
) {

    @GetMapping
    fun getComments(@SpringQueryMap commentsParams: CommentsParams): List<CommentsResponse> {
        return commentsUsecase.getComments(commentsParams).map { it.toResponse() }
    }
}