package com.jzheadley.polipoll.server.repositories

import com.jzheadley.polipoll.server.models.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@SuppressWarnings("unused")
@Repository
interface VoteRepository : JpaRepository<Vote, Long> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) from vote v join user u where v.user_id = u.user_id and race like concat('%', :race,'%') and supporting=true")
    fun numOfYesByRace(@Param("race") race: String): Int

    @Query(nativeQuery = true, value = "SELECT COUNT(*) from vote v join user u where v.user_id = u.user_id and race like concat('%', :race,'%') and supporting=false ")
    fun numOfNoByRace(@Param("race") race: String): Int

    @Query(nativeQuery = true, value = "SELECT " +
            "  count(*) " +
            "FROM vote v" +
            "  JOIN user u" +
            "  JOIN bill b " +
            "WHERE b.bill_id = v.bill_id AND v.user_id = u.user_id" +
            "      AND race LIKE concat('%', :race, '%')" +
            "      AND b.bill_id = :billId;")
    fun numOfYesByRaceForBill(@Param("billId") billId: Long, @Param("race") race: String): Int
}