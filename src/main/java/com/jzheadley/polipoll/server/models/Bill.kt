package com.jzheadley.polipoll.server.models

import javax.persistence.*

@Entity
@Table(name = "Bill")
class Bill(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val billId: Long?,
        val summary: String?,
        val urlToArticle: String?)