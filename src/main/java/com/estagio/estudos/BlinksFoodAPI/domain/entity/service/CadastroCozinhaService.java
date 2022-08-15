package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cozinha;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.KitchenNotFoundException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.CozinhaRepository;
import com.estagio.estudos.BlinksFoodAPI.dto.CozinhaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CadastroCozinhaService {
	@Autowired
	private CozinhaRepository cozinhaRepository;
	@Autowired
	private ModelMapper modelMapper;
	private static final String MSG_KITCHEN_NOT_FOUND = "Cozinha não foi encontrada, verifique o id usado:";
	@Transactional
	public CozinhaDTO adicionar(CozinhaDTO cozinhaDTO) {
		Cozinha cozinha = convertDtoToEntity(cozinhaDTO);
		Cozinha createdCozinha = cozinhaRepository.save(cozinha);
		return convertEntityToDto(createdCozinha);
	}

	public ResponseEntity<Cozinha> findById(Long id) {
		return cozinhaRepository.findById(id).map(cozinha -> ResponseEntity.ok().body(cozinha))
				.orElseThrow(() -> new KitchenNotFoundException(String.format(MSG_KITCHEN_NOT_FOUND) + id));
	}

	public List<CozinhaDTO> listAll() {
		return cozinhaRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	public ResponseEntity<Cozinha> updateCozinhaById(Cozinha cozinha, Long id) {
		return cozinhaRepository.findById(id).map(cozinhaUpdate -> {
			cozinhaUpdate.setNome(cozinha.getNome());
			Cozinha update = cozinhaRepository.save(cozinhaUpdate);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
	}

	@Transactional
	public ResponseEntity<Object> deleteById(Long cozinhaid) {
		return cozinhaRepository.findById(cozinhaid).map(cozinha -> {
			cozinhaRepository.deleteById(cozinhaid);
			cozinhaRepository.flush();
			return ResponseEntity.noContent().build();
		}).orElseThrow(() -> new KitchenNotFoundException(String.format(MSG_KITCHEN_NOT_FOUND) + cozinhaid));
	}

	public CozinhaDTO convertEntityToDto(Cozinha cozinha){
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		CozinhaDTO cozinhaDTO = new CozinhaDTO();
		cozinhaDTO = modelMapper.map(cozinha,CozinhaDTO.class);
		return cozinhaDTO;
	}
	public Cozinha convertDtoToEntity(CozinhaDTO cozinhaDTO){
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		Cozinha cozinha = new Cozinha();
		cozinha = modelMapper.map(cozinhaDTO,Cozinha.class);
		return cozinha;
	}

}
