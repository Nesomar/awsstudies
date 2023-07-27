package br.com.academy.awsstudies.application.usecase

import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.application.outputs.CommentsService
import br.com.academy.awsstudies.builders.CommentsBuilder
import br.com.academy.awsstudies.domain.Comments
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CommentsUsecaseimplTest {

    @RelaxedMockK
    lateinit var commentsService: CommentsService

    private lateinit var commentsUsecaseimpl: CommentsUsecaseimpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        commentsUsecaseimpl = CommentsUsecaseimpl(commentsService)
    }

    @Test
    fun `devera retornar todos os comentarios cadastrados na base`() {

        val commentsParams = CommentsParams(null)

        val comments = listOf(
            CommentsBuilder.builder(),
            CommentsBuilder.builder(),
            CommentsBuilder.builder(),
            CommentsBuilder.builder()
        )

        every { commentsService.getComments(commentsParams) } returns comments

        Assertions.assertDoesNotThrow { commentsUsecaseimpl.getComments(commentsParams) }

        verify(exactly = 1) { commentsService.getComments(commentsParams) }
    }

    @Test
    fun `devera retornar todos os comentarios cadastrados para o determinado post`() {

        val commentsParams = CommentsParams(Int.MAX_VALUE)

        val comments = listOf(CommentsBuilder.builder())

        every { commentsService.getComments(commentsParams) } returns comments

        Assertions.assertDoesNotThrow { commentsUsecaseimpl.getComments(commentsParams) }

        verify(exactly = 1) { commentsService.getComments(commentsParams) }

    }


}