package com.jzheadley.polipoll.server.repositories

import com.jzheadley.polipoll.server.models.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestMapping

@SuppressWarnings("unused")
@Repository
interface VoteRepository : JpaRepository<Vote, Long> {
    fun findByUserRace(@Param("race") race: String)

    @Query("SELECT COUNT(*) FROM user JOIN vote ON user.user_id = vote.user_id WHERE race = :race ")
    fun findNumberVotesByRaceSupporting(@Param("race") race : String)


    fun findByUserGender(@Param("gender") gender: String)
    fun countByUserRace(@Param("race") race: String)
}