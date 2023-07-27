package br.com.academy.awsstudies.adapters.clients.comments

import br.com.academy.awsstudies.adapters.http.dto.CommentsParams
import br.com.academy.awsstudies.builders.CommentsBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CommentsServiceImplTest {

    @RelaxedMockK
    lateinit var commentsClients: CommentsClients

    private lateinit var commentsServiceImpl: CommentsServiceImpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        commentsServiceImpl = CommentsServiceImpl(commentsClients)
    }

    @Test
    fun `devera retornar todos os comentarios cadastrados`() {

        val commentsParams = CommentsParams(null)

        every { commentsClients.getComments(commentsParams) } returns listOf(
            CommentsBuilder.dtoBuilder(),
            CommentsBuilder.dtoBuilder()
        )

        assertDoesNotThrow { commentsServiceImpl.getComments(commentsParams) }

        verify(exactly = 1) { commentsClients.getComments(commentsParams) }
    }

    @Test
    fun `devera lancar uma exception caso ocorra algum erro na chamada`() {

        val commentsParams = CommentsParams(null)

        every { commentsClients.getComments(commentsParams) } throws Exception()

        assertThrows<Exception> { commentsServiceImpl.getComments(commentsParams) }

        verify(exactly = 1) { commentsClients.getComments(commentsParams) }

    }
}