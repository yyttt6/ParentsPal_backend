package com.example.main.dao.blog

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "comment_reply")
class CommentReply (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment_reply")
    var commentReplyId: Long? = null,

    @Column(name = "id_comment")
    var commentId: Long? = null,

    @Column(name = "id_recipient")
    var recipientId: Long? = null,

    @Column(name = "id_replier")
    var replierId: Long? = null,

    @Column(name = "time")
    var time: LocalDateTime = LocalDateTime.now(), // Default value for time
) {
    // No-arg constructor for JPA
    constructor() : this(null, null, null, null, LocalDateTime.now())
}
