package com.estagio.estudos.BlinksFoodAPI.controller;

import java.util.List;

import com.estagio.estudos.BlinksFoodAPI.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.Endereco;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.EnderecoRepository;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroEnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	CadastroEnderecoService cadastroEnderecoService;
	@Autowired
	EnderecoRepository enderecoRepository;

	@GetMapping
	public List<EnderecoDTO> listAll() {
		return cadastroEnderecoService.listAll();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDTO addEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		return cadastroEnderecoService.addEndereco(enderecoDTO);
	}

	@GetMapping(value = "{enderecosid}")
	public EnderecoDTO findBy(@PathVariable("enderecosid") Long id,EnderecoDTO enderecoDTO) {
		return cadastroEnderecoService.findByEnderecos(id,enderecoDTO);
	}

	@PutMapping(value = "{enderecosid}")
	public EnderecoDTO updateByid( @PathVariable("enderecosid") Long id, @RequestBody EnderecoDTO enderecoDTO) {
		return cadastroEnderecoService.updateEnderecos(id,enderecoDTO);
	}

	@DeleteMapping(value = "{enderecosid}")
	public EnderecoDTO deleteByid(@PathVariable(value = "enderecosid") Long id, @RequestBody EnderecoDTO enderecoDTO ) {
		return cadastroEnderecoService.remove(id,enderecoDTO);
	}
}
