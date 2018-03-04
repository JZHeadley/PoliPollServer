package com.jzheadley.polipoll.server.repositories

import com.jzheadley.polipoll.server.models.Bill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@SuppressWarnings("unused")
@Repository
interface BillRepository : JpaRepository<Bill, Long>{
    @Query(value = "SELECT bill_id FROM bill", nativeQuery = true)
    override fun findAll(): MutableList<Bill>?

    @Query(value = "SELECT bill_id FROM bill", nativeQuery = true)
    fun findById(billId: String): Bill?

    @Query(value = "SELECT summary From bill", nativeQuery = true)
    fun getSummary(billId: String): Bill?

    @Query(value = "Select date_found From bill", nativeQuery = true)
    fun getDate(): MutableList<Bill>?

}