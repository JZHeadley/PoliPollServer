package com.jzheadley.polipoll.server.models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "Vote")
class Vote(
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val voteId: Long,
        @OneToOne
        @JoinColumn(name = "userId")
        val user: User,
        @OneToOne
        @JoinColumn(name = "billId")
        val bill: Bill,
        val date: Date,
        val supporting: Boolean,
        val comments: String) {
}