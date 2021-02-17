package com.interview.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.interview.entity.ClienteEntity;
import com.interview.exception.InvalidFieldException;
import com.interview.service.ClienteService;
import com.interview.service.serviceImpl.ClienteServiceImpl;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/clientes/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API REST Clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere um cliente")
	public ClienteEntity insert(@Valid  @RequestBody ClienteEntity clientParam) throws InvalidFieldException{
		return clienteService.save(clientParam);
	}	
	

	@GetMapping("/nome/{clientName}")
	@ApiOperation(value = "Pesquisa o cliente pelo nome")
	public List<ClienteEntity> findByName(@PathVariable @NotNull String clientName) throws InvalidFieldException{
		return clienteService.findByNome(clientName);
	}
	

	@GetMapping("/{id}")
	@ApiOperation(value = "Pesquisa o cliente pelo ID")
	public Optional<ClienteEntity> findById(@PathVariable Long id) throws InvalidFieldException{
		return clienteService.findById(id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um cliente")
	public Boolean deleteById(@PathVariable @NotNull Long id) throws InvalidFieldException{
		return clienteService.deleteById(id);
	}

	@PutMapping
	@ApiOperation(value = "Altera o nome de um cliente")
	public ClienteEntity updateClienteName(@RequestBody ClienteEntity cliente) throws InvalidFieldException{
		return clienteService.updateName(cliente);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidFields(InvalidFieldException ex) {
		return ex.getMessage();
	}

}
