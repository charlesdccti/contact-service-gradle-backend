package br.charles.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.charles.model.Mongo;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class CalculoController {
	
	private String resultado;
	private Double imc;

	//--> lista para simulaçao de mongodb
	private ArrayList<Mongo> mongodb = new ArrayList<Mongo>();
	
	
	@RequestMapping(value = "/imc/{peso}/altura/{altura}", method = RequestMethod.GET)
	public String findByPesoAndAltura(@PathVariable final Double peso, @PathVariable final Double altura) {
		
		imc = peso/(altura*altura);
		
		if(imc < 18.5)
			resultado = "MAGREZA";
		else
			if(peso < 18.5 && imc < 24.9)
				resultado = "NORMAL";
			else
				if(imc < 25 && imc < 29.9)
					resultado = "SOBREPESO";
				else 
					if(imc < 30 && imc < 39.9)
						resultado = "OBESIDADE";
					else 					
						if(imc > 40)
							resultado = "OBESIDADE GRAVE";
		
		return resultado;
	}


	@GetMapping(value = "/mongodb")
	public Iterable<Mongo> listMongoDB() {
		return this.mongodb;
	}


	@RequestMapping(value = "/mongodb/{chave}", method = RequestMethod.GET)
	public String findValorByChave(@PathVariable final Integer chave) {
	
		for (Mongo mongo : this.mongodb) {
			if( chave == mongo.getChave())	
				return mongo.getValor();
		}
		return null;
	}


	@PostMapping(value = "/mongodb")
	public Mongo postByMongo(@RequestBody Mongo mongo) {

		if(mongo != null){
			this.mongodb.add(mongo);
			return mongo;
		}
		return null;
	}

}



