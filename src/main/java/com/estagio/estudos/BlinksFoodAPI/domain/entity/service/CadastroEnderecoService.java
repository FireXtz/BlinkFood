package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import java.util.List;
import java.util.stream.Collectors;

import com.estagio.estudos.BlinksFoodAPI.dto.EnderecoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.Endereco;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.AddressException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.EnderecoRepository;

@Service
public class CadastroEnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ModelMapper modelMapper;
	private static final String MSG_NOT_FOUND_ADDRESS = "Não foi Possivel achar o endreço com este id:";

	public List<EnderecoDTO> listAll() {
		return enderecoRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	public EnderecoDTO addEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = convertDtoToEntity(enderecoDTO);
		Endereco createdEndereco = enderecoRepository.save(endereco);
		return convertEntityToDto(createdEndereco);
	}
	public EnderecoDTO findByEnderecos(Long id,EnderecoDTO enderecoDTO) {
		return enderecoRepository.findById(id).map(endereco -> convertEntityToDto(endereco))
				.orElseThrow(() -> new AddressException(String.format(MSG_NOT_FOUND_ADDRESS) + id));
	}
	public EnderecoDTO  updateEnderecos( Long id,EnderecoDTO enderecoDTO) {
		return enderecoRepository.findById(id).map(enderecoUdpate -> {
			Endereco endereco = convertDtoToEntity(enderecoDTO);
			enderecoUdpate.setBairro(endereco.getBairro());
			Endereco update = enderecoRepository.save(enderecoUdpate);
			return convertEntityToDto(update);
		}).orElseThrow(() -> new AddressException(String.format(MSG_NOT_FOUND_ADDRESS) + id));
	}
	public EnderecoDTO  remove (Long id,EnderecoDTO enderecoDTO) {
		return enderecoRepository.findById(id).map(endereco -> {
			Endereco enderecos = convertDtoToEntity(enderecoDTO);
			enderecoRepository.deleteById(id);
			return convertEntityToDto(enderecos);
		}).orElseThrow(() -> new AddressException(String.format(MSG_NOT_FOUND_ADDRESS) + id));

	}
	private EnderecoDTO convertEntityToDto(Endereco endereco){
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
			EnderecoDTO enderecoDTO = new EnderecoDTO();
			enderecoDTO = modelMapper.map(endereco,EnderecoDTO.class);
			return enderecoDTO;
	}
	private Endereco convertDtoToEntity(EnderecoDTO enderecoDTO){
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
			Endereco endereco = new Endereco();
			endereco = modelMapper.map(enderecoDTO,Endereco.class);
			return endereco;
	}

}
