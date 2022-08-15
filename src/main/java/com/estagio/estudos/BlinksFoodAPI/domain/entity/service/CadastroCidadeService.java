package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cidade;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.CityNotFoundException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.CidadeRepository;
import com.estagio.estudos.BlinksFoodAPI.dto.CidadeDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CadastroCidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String MSG_NOT_FOUND_EXCEPTION = "Nenhuma cidade encontrada com este id:";
    public CidadeDTO addCidade(CidadeDTO cidadeDTO){
      Cidade cidade = convertDtoToEntity(cidadeDTO);
      Cidade createdCidade = cidadeRepository.save(cidade);
      return convertEntityToDto(createdCidade);
    }

    public List <CidadeDTO> listAll (){
        return cidadeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public CidadeDTO findByid(Long id,CidadeDTO cidadeDTO){
        return cidadeRepository.findById(id)
                .map(cidade -> convertEntityToDto(cidade))
                .orElseThrow(() ->  new CityNotFoundException(String.format(MSG_NOT_FOUND_EXCEPTION)));
    }
    public CidadeDTO updateById(Long id,CidadeDTO cidadeDTO){
        return cidadeRepository.findById(id)
                .map(cidadeUpdate -> {
                    Cidade cidade = convertDtoToEntity(cidadeDTO);
                    cidadeUpdate.setCidade(cidade.getCidade());
                    Cidade update = cidadeRepository.save(cidadeUpdate);
                    return convertEntityToDto(update);
                }).orElseThrow(() ->  new CityNotFoundException(String.format(MSG_NOT_FOUND_EXCEPTION)+id));
    }

    public CidadeDTO deleteById(Long id, CidadeDTO cidadeDTO) {
        return cidadeRepository.findById(id)
                .map(cidade -> {
                    Cidade cidades = convertDtoToEntity(cidadeDTO);
                    cidadeRepository.deleteById(id);
                    return convertEntityToDto(cidades);
                }).orElseThrow(()-> new CityNotFoundException(String.format(MSG_NOT_FOUND_EXCEPTION)+id));
    }
    private CidadeDTO convertEntityToDto(Cidade cidade){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO = modelMapper.map(cidade,cidadeDTO.getClass());
        return cidadeDTO;
    }

    private Cidade convertDtoToEntity(CidadeDTO cidadeDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Cidade cidade = new Cidade();
        cidade = modelMapper.map(cidadeDTO,Cidade.class);
        return cidade;
    }
}
