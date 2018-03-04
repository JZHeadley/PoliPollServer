package com.jzheadley.polipoll.server.repositories

import com.jzheadley.polipoll.server.models.Bill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@SuppressWarnings("unused")
@Repository
interface BillRepository : JpaRepository<Bill, Long>