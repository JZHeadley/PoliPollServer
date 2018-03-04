package com.jzheadley.polipoll.server.models

import java.sql.Date
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "User")
data class User(
        @Id
        val userId: String? = UUID.randomUUID().toString(),
        val name: String? = "",
        val dob: Date? = Date(-1),
        val race: String? = "",
        val gender: String? = "",
        val maritalStatus: String? = "",
        val religion: String? = "",
        val annHouseholdIncome: String? = "",
        val politicalStanding: String? = "",
        val numChildren: Int? = -1,
        val sexualOrientation: String? = "")