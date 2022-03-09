package com.example.stage.service;

import java.util.List;

import com.example.stage.model.Stagiaire;



public interface StagiaireService {
	Stagiaire saveStagiaire(Stagiaire stagiaire);
	List<Stagiaire> getAllStagiaires();
	Stagiaire getStagiaireById(long id);
	Stagiaire updateStagiaire(Stagiaire stagiaire, long id);
	void deleteStagiaire(long id);
}