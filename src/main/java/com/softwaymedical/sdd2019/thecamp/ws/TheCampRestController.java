package com.softwaymedical.sdd2019.thecamp.ws;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaymedical.sdd2019.thecamp.entity.Equipe;
import com.softwaymedical.sdd2019.thecamp.entity.Equipes;
import com.softwaymedical.sdd2019.thecamp.entity.Participants;

@RestController
@RequestMapping("/thecamp")
public class TheCampRestController {

	@PostMapping("/equipes")
	public Equipes equipes(@RequestBody Participants participants) {
		List<Equipe> equipes = new ArrayList<Equipe>();  		
		return new Equipes(equipes);
	}

}	