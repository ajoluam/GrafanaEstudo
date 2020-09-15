package com.example.grafana.prometheus.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grafana.prometheus.demo.utils.MicrometerService.MicrometerService;

@RestController
public class TestController {
	
	@Autowired
	private MicrometerService micrometerService;
	
	@PostMapping("/message")
	public String teste(
			@RequestParam("id_parceiro") String parceiro,
			@RequestParam("id_pessoa") String pessoa,
			@RequestParam("id_produto") String produto,
			@RequestParam("id_proposta") String proposta,
			@RequestParam("numero_loja") String loja,
			@RequestParam("numero_operador") String operador
			) {
		Map<String, String> mapa = new HashMap<>();
		mapa.put("id_parceiro", parceiro);
		mapa.put("id_pessoa", pessoa);
		mapa.put("id_produto", produto);
		mapa.put("id_proposta", proposta);
		mapa.put("numero_loja", loja);
		mapa.put("numero_operador", operador);
		
		micrometerService.logMetrics(mapa);
		
			
		
		return "Funfou!!!";
	}
	
}
