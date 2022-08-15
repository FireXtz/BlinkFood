package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Restaurante;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.EateryNotFoundException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.RestauranteRepository;
import com.estagio.estudos.BlinksFoodAPI.dto.RestauranteDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroRestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String MSG_EATERY_NOT_FOUND = "Restaurante não localizado verifique seu id:";

    public List <RestauranteDTO> findAll (){
        return restauranteRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    public RestauranteDTO saveRestaurante (RestauranteDTO restauranteDTO){
       Restaurante restaurante = convertDtoToEntity(restauranteDTO);
       Restaurante createdRest = restauranteRepository.save(restaurante);
       return convertEntityToDto(createdRest);
    }
    public RestauranteDTO finById(Long id){
        return restauranteRepository.findById(id)
                .map(restaurante -> convertEntityToDto(restaurante))
                .orElseThrow(()-> new EateryNotFoundException(String.format(MSG_EATERY_NOT_FOUND) + id));
    }
    public RestauranteDTO updateRestauranteByid (Long id, RestauranteDTO restauranteDTO){
        return  restauranteRepository.findById(id)
                .map(restUpdate -> {
                    Restaurante restaurante = convertDtoToEntity(restauranteDTO);
                    restUpdate.setNome(restaurante.getNome());
                    restUpdate.setTaxafrete(restaurante.getTaxafrete());
                    restUpdate.setCozinha(restaurante.getCozinha());
                    restUpdate.setDataCadastro(restaurante.getDataCadastro());
                    Restaurante restUpdated = restauranteRepository.save(restUpdate);
                    return convertEntityToDto(restUpdated);
                }).orElseThrow(()-> new EateryNotFoundException(String.format(MSG_EATERY_NOT_FOUND)+ id));
    }
    public RestauranteDTO deleteById(Long id, RestauranteDTO restauranteDTO){
       return restauranteRepository.findById(id)
               .map(restaurante -> {
                   Restaurante restaurantes = convertDtoToEntity(restauranteDTO);
                   restauranteRepository.deleteById(id);
                   return convertEntityToDto(restaurantes);
               }) .orElseThrow(()-> new EateryNotFoundException(String.format(MSG_EATERY_NOT_FOUND) + id));
    }
    private RestauranteDTO convertEntityToDto(Restaurante restaurante){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
         RestauranteDTO restauranteDTO = new RestauranteDTO();
         restauranteDTO = modelMapper.map(restaurante,RestauranteDTO.class);
         return restauranteDTO;
    }

    private Restaurante convertDtoToEntity(RestauranteDTO restauranteDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Restaurante restaurante = new Restaurante();
        restaurante = modelMapper.map(restauranteDTO,Restaurante.class);
        return restaurante;
    }
}
