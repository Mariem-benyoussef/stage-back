package com.example.stage.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage.model.Stagiaire;
import com.example.stage.repository.StagiaireRepository;
import com.example.stage.service.StagiaireService;
import com.example.stagiaire.exception.ResourceNotFoundException;



@Service
@Transactional
public class StagiaireServiceImpl implements StagiaireService{

	private StagiaireRepository stagiaireRepository;
	
	@Autowired
	public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
		super();
		this.stagiaireRepository=stagiaireRepository;
	}

	@Override
	public Stagiaire saveStagiaire(Stagiaire stagiaire) {
		return stagiaireRepository.save(stagiaire);
	}
	
	@Override
	public List<Stagiaire> getAllStagiaires() {
		return stagiaireRepository.findAll();
	}
	
	@Override
	public Stagiaire getStagiaireById(long id) {
		return stagiaireRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Stagiaire", "Id", id));
		
	}
	
	@Override
	public Stagiaire updateStagiaire(Stagiaire stagiaire, long id) {

		Stagiaire existingStagiaire = stagiaireRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Stagiaire", "Id", id)); 
		
		existingStagiaire.setNom(stagiaire.getNom());
		existingStagiaire.setPrenom(stagiaire.getPrenom());
		existingStagiaire.setEmail(stagiaire.getEmail());
		existingStagiaire.setTel(stagiaire.getTel());

		stagiaireRepository.save(existingStagiaire);
		return existingStagiaire;
	}

	@Override
	public void deleteStagiaire(long id) {

		stagiaireRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Stagiaire", "Id", id));
		stagiaireRepository.deleteById(id);
	}

}
