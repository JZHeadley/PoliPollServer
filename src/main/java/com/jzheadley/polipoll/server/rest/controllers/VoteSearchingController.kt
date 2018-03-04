package com.jzheadley.polipoll.server.rest.controllers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jzheadley.polipoll.server.repositories.VoteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
class VoteSearchingController(private val voteRepo: VoteRepository, private val gson: Gson) {
    @GetMapping("votes/stats/{race}")
    fun getNumYesNoByRace(@PathParam("race") race: String): ResponseEntity<String>? {
        var numYes = voteRepo.numOfYesByRace(race)
        var numNo = voteRepo.numOfNoByRace(race)
        var gson: Gson = GsonBuilder().create()
        return ResponseEntity.ok(gson.toJson("{" +
                "yes:" + numYes +
                " no:" + numNo +
                "}"))
    }


}