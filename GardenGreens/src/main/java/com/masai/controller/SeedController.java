package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.SeedsExceptions;
import com.masai.model.Seeds;
import com.masai.service.SeedsServices;



@RestController
@RequestMapping("/seedservice")
public class SeedController {
	
	@Autowired
	private SeedsServices sService;
	

	@PostMapping("/Seeds/{key}")
	public ResponseEntity<Seeds> addSeeds(@RequestBody Seeds seeds, @PathVariable("key") String key) throws SeedsExceptions {
		
		Seeds newSeeds = sService.addPSeed(seeds, key);

		return new ResponseEntity<Seeds>(newSeeds, HttpStatus.ACCEPTED);
		
		
	}
	
	
	@PostMapping("/Seeds")
	public ResponseEntity<Seeds> updateSeeds(@RequestBody Seeds Seeds, @RequestParam("key") String key) throws SeedsExceptions {
		
		Seeds newSeeds = sService.updateSeed(Seeds, key);

		return new ResponseEntity<Seeds>(newSeeds, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@DeleteMapping("/Seeds/{seedId}/{key}")
	public ResponseEntity<Seeds> deleteSeeds(@PathVariable("key") Integer seedId, @PathVariable("key") String key) throws SeedsExceptions {
		
		Seeds newSeeds = sService.deleteSeed(seedId, key);

		return new ResponseEntity<Seeds>(newSeeds, HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@GetMapping("/Seeds/{SeedsId}")
	public ResponseEntity<Seeds> viewSeedsById(@PathVariable("SeedsId") Integer SeedsId) throws SeedsExceptions {
		
		Seeds newSeeds = sService.viewSeedById(SeedsId);

		return new ResponseEntity<Seeds>(newSeeds, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@GetMapping("/Seeds/{commonName}")
	public ResponseEntity<List<Seeds>> viewSeedByCommonName(@PathVariable("commonName") String commonName) throws SeedsExceptions {
		
		List<Seeds> SeedsList = sService.viewSeedByCommonName(commonName);

		return new ResponseEntity<List<Seeds>>(SeedsList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@GetMapping("/Seeds")
	public ResponseEntity<List<Seeds>> viewAllSeeds() throws SeedsExceptions {
		
		List<Seeds> SeedsList = sService.viewAllSeeds();

		return new ResponseEntity<List<Seeds>>(SeedsList, HttpStatus.ACCEPTED);
		
		
		
	}
	
//	@GetMapping("/Seeds/{typeOfSeed}")
//	public ResponseEntity<List<Seeds>>viewAllSeedsByType(@Valid @PathVariable("typeOfSeed") String typeOfSeed) throws SeedsExceptions {
//		
//		List<Seeds> SeedsList = sService.viewAllSeedsByType(typeOfSeed);
//		
//		return new ResponseEntity<List<Seeds>>(SeedsList, HttpStatus.ACCEPTED);
//		
//		
//		
//	}
	
	
	
	
	
	
	
	

}
