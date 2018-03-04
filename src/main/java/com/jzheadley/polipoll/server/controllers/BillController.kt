package com.jzheadley.polipoll.server.controllers

import com.jzheadley.polipoll.server.models.Bill
import com.jzheadley.polipoll.server.repositories.BillRepository
import com.jzheadley.polipoll.server.utils.ResponseUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

//@RestController
//@RequestMapping("/api/bill")
    class BillController(val billRepository: BillRepository){

    
    @GetMapping("/{id}")
    fun getBillById(@PathVariable("id") billId: String): ResponseEntity<Bill> = ResponseUtil.wrapOrNotFound(Optional.ofNullable(billRepository.findById(billId)))


}