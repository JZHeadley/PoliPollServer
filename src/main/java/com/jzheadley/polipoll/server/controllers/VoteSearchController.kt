package com.jzheadley.polipoll.server.controllers

import com.jzheadley.polipoll.server.repositories.BillRepository
import com.jzheadley.polipoll.server.repositories.VoteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/vote/search")
class VoteSearchController(val voteRepository: VoteRepository) {
    @GetMapping("raceSearch")
    fun getblah(@RequestParam("race") race: String) : ResponseEntity<Unit>? {
        return ResponseEntity.ok(voteRepository.findNumberVotesByRaceSupporting(race))


    }
}
