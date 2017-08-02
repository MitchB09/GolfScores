package com.realscores.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.realscores.obj.RoundScore;
import com.realscores.service.roundscore.IRoundScoreService;

@RequestMapping("/rounds/scores")
public class RoundScoreController {
	
	@Autowired
	IRoundScoreService roundScoreService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<RoundScore>> getRoundScoresByRoundById(
			@PathVariable("id") int roundId){		
		List<RoundScore> roundScores = roundScoreService.getRoundScoresByRoundId(roundId);
		return new ResponseEntity<List<RoundScore>>(roundScores, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createRoundScore(@RequestBody RoundScore roundScore, UriComponentsBuilder builder){		
		boolean flag = roundScoreService.addRoundScore(roundScore);
		if (flag == false) {
	      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/players/{id}").buildAndExpand(roundScore.getPlayerRoundId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<RoundScore> updatePlayer(@RequestBody RoundScore roundScore) {
		roundScoreService.updateRoundScore(roundScore);
		return new ResponseEntity<RoundScore>(roundScore, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable("id") Integer roundScoreId) {
		roundScoreService.deleteRoundScore(roundScoreId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
