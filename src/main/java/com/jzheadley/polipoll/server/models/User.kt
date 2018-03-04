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
        val maritalStatus: Enum<MaritalStatus>,
        val religion: String,
        val annHouseholdIncome: Double,
        val politicalStanding: Enum<PoliticalStanding>,
        val numChildren: Int,
        val sexualOrientation: Enum<Sexuality>)