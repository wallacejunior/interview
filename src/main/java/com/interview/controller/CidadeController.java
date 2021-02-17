package com.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.interview.entity.CidadeEntity;
import com.interview.exception.InvalidFieldException;
import com.interview.service.CidadeService;
import com.interview.service.serviceImpl.CidadeServiceImpl;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/v1/cidades/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API REST Cidades")
public class CidadeController {

	@Autowired(required=true)
	private CidadeService cidadeService;
	
	@PostMapping
	@ApiOperation(value = "Inserir nova cidade.")
	public CidadeEntity save(@Validated @RequestBody CidadeEntity cidade) throws InvalidFieldException {
		return cidadeService.save(cidade);
	}
	
	@GetMapping("/nome/{nome}")
	@ApiOperation(value = "pesquisa pelo nome.")
	public List<CidadeEntity> findByNome( @PathVariable String nome) throws InvalidFieldException {
		return cidadeService.findByNome(nome);
	}
	
	@GetMapping("/estado/{estado}")
	@ApiOperation(value = "Pesquisa cidade pelo estado")
	public List<CidadeEntity> findByEstado(@PathVariable String estado) throws InvalidFieldException{
		return cidadeService.findByEstado(estado);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidFields(InvalidFieldException ex) {
		return ex.getMessage();
	}
	
}
