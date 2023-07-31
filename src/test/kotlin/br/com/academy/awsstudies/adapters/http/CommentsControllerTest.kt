package br.com.academy.awsstudies.adapters.http

import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.application.inputs.CommentsUsecase
import br.com.academy.awsstudies.builders.CommentsBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CommentsControllerTest {

    @RelaxedMockK
    lateinit var commentsUsecase: CommentsUsecase

    private lateinit var commentsController: CommentsController

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        commentsController = CommentsController(commentsUsecase)
    }

    @Test
    fun `devera retornar todos os comentarios`() {

        val commentsParams = CommentsParams(null)

        every { commentsUsecase.getComments(commentsParams) } returns listOf(CommentsBuilder.builder())

        assertDoesNotThrow { commentsController.getComments(commentsParams) }

        verify(exactly = 1) { commentsUsecase.getComments(commentsParams) }
    }
}



