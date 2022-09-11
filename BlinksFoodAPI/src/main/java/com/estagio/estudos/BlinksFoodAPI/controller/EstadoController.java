package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Estado;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroEstadoService;
import com.estagio.estudos.BlinksFoodAPI.dto.EstadoDTO;
import com.estagio.estudos.BlinksFoodAPI.dto.RestauranteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	@Autowired
	private CadastroEstadoService cadastroEstadoService;

	@GetMapping
	public List<EstadoDTO> listAll() {
		return cadastroEstadoService.listAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoDTO adicionar(@RequestBody EstadoDTO estadoDTO) {
		return cadastroEstadoService.addEstado(estadoDTO);
	}

	@GetMapping(value = "/{estadosid}")
	public EstadoDTO getByid(@PathVariable("estadosid") Long id) {
		return cadastroEstadoService.findById(id);
	}

	@PutMapping(value = "/{estadosid}")
	public EstadoDTO atualizar(@RequestBody EstadoDTO estadoDTO, @PathVariable(value = "estadosid") Long id) {
		return cadastroEstadoService.updateByid(id,estadoDTO);
	}
	@DeleteMapping(value = "/{estadosid}")
	public EstadoDTO deletar(@PathVariable(value = "estadosid") Long id,EstadoDTO estadoDTO) {
		return cadastroEstadoService.deleteById(id,estadoDTO);
	}
}
