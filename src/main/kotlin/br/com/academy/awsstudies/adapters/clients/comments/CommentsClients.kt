package br.com.academy.awsstudies.adapters.clients.comments

import br.com.academy.awsstudies.adapters.clients.comments.dto.CommentsDTO
import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "commentsClient", url = "https://jsonplaceholder.typicode.com")
interface CommentsClients {

    @GetMapping(value = ["/comments"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getComments(@SpringQueryMap commentsParams: CommentsParams): List<CommentsDTO>
}