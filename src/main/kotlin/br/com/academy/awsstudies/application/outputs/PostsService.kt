package br.com.academy.awsstudies.application.outputs

import br.com.academy.awsstudies.domain.Comments
import br.com.academy.awsstudies.domain.Posts

interface PostsService {
    /**
     * Returns all posts
     *
     * @return List<Posts>
     */
    fun getAll(): List<Posts>

    /**
     * Search the post by the id entered
     *
     * @param id
     *
     * @return Posts
     */
    fun getById(id: Int): Posts

    /**
     * Returns all comments, if the postId is entered it returns the comments for that post
     *
     * @param id
     *
     * @return List<Comments>
     */
    fun getComments(id: Int): List<Comments>
}