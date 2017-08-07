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

import com.realscores.obj.HoleScore;
import com.realscores.service.roundscore.IRoundScoreService;

@RequestMapping("/rounds")
public class RoundScoreController {
	
	@Autowired
	IRoundScoreService roundScoreService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<HoleScore>> getRoundScoresByRoundById(
			@PathVariable("id") int roundId){		
		List<HoleScore> holeScores = roundScoreService.getRoundScoresByRoundId(roundId);
		return new ResponseEntity<List<HoleScore>>(holeScores, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createRoundScore(@RequestBody HoleScore holeScore, UriComponentsBuilder builder){		
		boolean flag = roundScoreService.addRoundScore(holeScore);
		if (flag == false) {
	      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/players/{id}").buildAndExpand(holeScore.getPlayerRoundId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<HoleScore> updatePlayer(@RequestBody HoleScore holeScore) {
		roundScoreService.updateRoundScore(holeScore);
		return new ResponseEntity<HoleScore>(holeScore, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable("id") Integer roundScoreId) {
		roundScoreService.deleteRoundScore(roundScoreId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
