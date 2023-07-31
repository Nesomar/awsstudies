package br.com.academy.awsstudies.adapters.http

import br.com.academy.awsstudies.application.inputs.PostsUsecase
import br.com.academy.awsstudies.builders.CommentsBuilder
import br.com.academy.awsstudies.builders.PostsBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class PostsControllerTest {

    @RelaxedMockK
    lateinit var postsUsecase: PostsUsecase

    lateinit var postsController: PostsController

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        postsController = PostsController(postsUsecase)
    }

    @Test
    fun `devera retornar todos os posts cadastrados`() {

        val posts =
            listOf(PostsBuilder.builder(), PostsBuilder.builder(), PostsBuilder.builder(), PostsBuilder.builder())

        every { postsUsecase.getAll() } returns posts

        assertDoesNotThrow { postsController.getAll() }

        verify(exactly = 1) { postsUsecase.getAll() }
    }

    @Test
    fun `devera retornar todos os posts cadastrados pelo id informado`() {

        val id = Int.MAX_VALUE

        val posts = PostsBuilder.builder()

        every { postsUsecase.getById(id) } returns posts

        assertDoesNotThrow { postsController.getById(id) }

        verify(exactly = 1) { postsUsecase.getById(id) }
    }

    @Test
    fun `devera retornar todos os comentarios do posts informado`() {

        val id = Int.MAX_VALUE

        val comments =
            listOf(CommentsBuilder.builder(), CommentsBuilder.builder(), CommentsBuilder.builder(), CommentsBuilder.builder())

        every { postsUsecase.getComments(id) } returns comments

        assertDoesNotThrow { postsController.getComments(id) }

        verify(exactly = 1) { postsUsecase.getComments(id) }
    }
}