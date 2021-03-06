package com.jzheadley.polipoll.server.rest.controllers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jzheadley.polipoll.server.repositories.VoteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class VoteSearchingController(private val voteRepo: VoteRepository, private val gson: Gson) {
    @GetMapping("votes/stats/{race}")
    fun getNumYesNoByRace(@PathVariable("race") race: String): ResponseEntity<String>? {
        var numYes: Int = voteRepo.numOfYesByRace(race)
        var numNo: Int = voteRepo.numOfNoByRace(race)
        var gson: Gson = GsonBuilder().create()
        return ResponseEntity.ok(gson.toJson("{" +
                "yes:" + numYes +
                ", no:" + numNo +
                "}"))
    }


}