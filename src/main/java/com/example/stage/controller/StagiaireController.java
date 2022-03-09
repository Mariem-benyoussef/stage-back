package com.example.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stage.model.Stagiaire;
import com.example.stage.service.StagiaireService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("stagiaires")
	public class StagiaireController {
		
		private StagiaireService stagiaireService;

		@Autowired
		public StagiaireController(StagiaireService stagiaireService) {
			super();
			this.stagiaireService = stagiaireService;
		}

		@PostMapping("/add")
		public ResponseEntity<Stagiaire> saveStagiaire(@RequestBody Stagiaire stagiaire){
			return new ResponseEntity<Stagiaire>(stagiaireService.saveStagiaire(stagiaire), HttpStatus.CREATED);
		}


		@GetMapping("/all")
		public List<Stagiaire> getAllStagiaires(){
			return stagiaireService.getAllStagiaires();
		}


		@GetMapping("/all/{id}")
		public ResponseEntity<Stagiaire> getStagiaireById(@PathVariable("id") long stagiaireId){
			return new ResponseEntity<Stagiaire>(stagiaireService.getStagiaireById(stagiaireId), HttpStatus.OK);
		}
		

		@PutMapping("/update/{id}")
		public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable("id") long id
													  ,@RequestBody Stagiaire stagiaire){
			return new ResponseEntity<Stagiaire>(stagiaireService.updateStagiaire(stagiaire, id), HttpStatus.OK);
		}
	

		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteStagiaire(@PathVariable("id") long id){

			stagiaireService.deleteStagiaire(id);
			
			return new ResponseEntity<String>("stagiaire supprimé!.", HttpStatus.OK);
		}
	}

