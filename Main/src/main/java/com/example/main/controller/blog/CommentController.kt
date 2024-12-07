package com.example.main.controller.blog

import com.example.main.Response
import com.example.main.dao.blog.Comment
import com.example.main.service.blog.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CommentController {
    @Autowired
    private lateinit var commentService: CommentService

    @GetMapping("/comment/{id}")
    fun getComment(@PathVariable("id") id: Long): Response<Comment> {
        return commentService.getCommentById(id)
    }

    @GetMapping("/comment-article/{articleId}")
    fun getArticleList(@PathVariable("articleId") articleId: Long): Response<List<Comment>> {
        return Response.newSuccess(commentService.getCommentsByArticleId(articleId))
    }

    @PostMapping("/comment")
    fun createComment(@RequestBody comment: Comment): Response<Long?> {
        return Response.newSuccess(commentService.createComment(comment))
    }

    @DeleteMapping("/comment/{id}")
    fun deleteComment(@PathVariable id: Long) {
        commentService.deleteCommentById(id)
    }

    @PutMapping("/comment/{id}")
    fun updateComment(@PathVariable id: Long, @RequestParam(required = false) content: String): Response<Comment> {
        return Response.newSuccess(commentService.updateCommentById(id, content))
    }

    @PutMapping("/comment/{aspect}/{id}&{op}")
    fun updateCommentStatus(
        @PathVariable id: Long,
        @PathVariable aspect: String,
        @PathVariable op: Int
    ): Response<Comment> {
        return Response.newSuccess(commentService.updateCommentStatusById(id, aspect, op))
    }
}