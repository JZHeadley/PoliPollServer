package com.jzheadley.polipoll.server.models

import java.sql.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "User")
data class User(
        @Id
        val userId: String,
        val name: String,
        val dob: Date,
        val race: String,
        val gender: String,
        val maritalStatus: String,
        val religion: String,
        val annHouseholdIncome: String,
        val politicalStanding: String,
        val numChildren: Int,
        val sexualOrientation: String)