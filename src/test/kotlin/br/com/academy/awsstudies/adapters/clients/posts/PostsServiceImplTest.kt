package br.com.academy.awsstudies.adapters.clients.posts

import br.com.academy.awsstudies.builders.CommentsBuilder
import br.com.academy.awsstudies.builders.PostsBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class PostsServiceImplTest {

    @RelaxedMockK
    lateinit var postsClient: PostsClient

    private lateinit var postsServiceImpl: PostsServiceImpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        postsServiceImpl = PostsServiceImpl(postsClient)
    }

    @Test
    fun `devera retornar todos os posts cadastrados`() {

        every { postsClient.getAll() } returns listOf(PostsBuilder.dtoBuilder(), PostsBuilder.dtoBuilder())

        assertDoesNotThrow { postsServiceImpl.getAll() }

        verify(exactly = 1) { postsClient.getAll() }
    }

    @Test
    fun `devera lancar uma exeception caso ocorra um erro na chamada ao cliente`() {

        every { postsClient.getAll() } throws Exception()

        assertThrows<Exception> { postsServiceImpl.getAll() }

    }

    @Test
    fun `devera retornar o post pelo id informado`() {

        val id = Int.MAX_VALUE

        every { postsClient.getById(id) } returns PostsBuilder.dtoBuilder()

        assertDoesNotThrow { postsServiceImpl.getById(id) }

        verify(exactly = 1) { postsClient.getById(id) }
    }

    @Test
    fun `devera lancar uma exeception caso ocorra um erro ao tentar recuperar o post por id`() {

        val id = Int.MAX_VALUE

        every { postsClient.getById(id) } throws Exception()

        assertThrows<Exception> { postsServiceImpl.getById(id) }

    }

    @Test
    fun `devera retornar os comentarios do post pelo id informado`() {

        val id = Int.MAX_VALUE

        every { postsClient.getComments(id) } returns listOf(CommentsBuilder.dtoBuilder(), CommentsBuilder.dtoBuilder())

        assertDoesNotThrow { postsServiceImpl.getComments(id) }

        verify(exactly = 1) { postsClient.getComments(id) }
    }

    @Test
    fun `devera lancar uma exception quando tentar recuperar os comentarios do post pelo id informado`() {

        val id = Int.MAX_VALUE

        every { postsClient.getComments(id) } throws Exception()

        assertThrows<Exception> { postsServiceImpl.getComments(id) }

    }
}