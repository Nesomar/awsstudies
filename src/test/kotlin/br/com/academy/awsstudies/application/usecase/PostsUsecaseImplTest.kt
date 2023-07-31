package br.com.academy.awsstudies.application.usecase

import br.com.academy.awsstudies.application.outputs.PostsService
import br.com.academy.awsstudies.builders.CommentsBuilder
import br.com.academy.awsstudies.builders.PostsBuilder
import br.com.academy.awsstudies.domain.Comments
import br.com.academy.awsstudies.domain.Posts
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PostsUsecaseImplTest {

    @RelaxedMockK
    lateinit var postsService: PostsService

    private lateinit var postsUsecaseImpl: PostsUsecaseImpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        postsUsecaseImpl = PostsUsecaseImpl(postsService)
    }

    @Test
    fun `devera retornar todos os posts cadastrados na base`() {

        every { postsService.getAll() } returns listOf(
            PostsBuilder.builder(),
            PostsBuilder.builder(),
            PostsBuilder.builder(),
            PostsBuilder.builder()
        )

        assertDoesNotThrow { postsUsecaseImpl.getAll() }

        verify(exactly = 1) { postsService.getAll() }

    }

    @Test
    fun `devera retornar o post cadastrado pelo id informado`() {

        val id = Int.MAX_VALUE

        every { postsService.getById(id) } returns PostsBuilder.builder()

        assertDoesNotThrow { postsUsecaseImpl.getById(id) }

        verify(exactly = 1) { postsService.getById(id) }
    }

    @Test
    fun `devera recuperar os comentarios de um determinado post`() {

        val id = Int.MAX_VALUE

        every { postsService.getComments(id) } returns listOf(CommentsBuilder.builder(), CommentsBuilder.builder())

        assertDoesNotThrow { postsUsecaseImpl.getComments(id) }

        verify(exactly = 1) { postsService.getComments(id) }
    }

}