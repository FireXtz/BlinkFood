package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Estado;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.StatesNotFoundException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.EstadoRepository;
import com.estagio.estudos.BlinksFoodAPI.dto.EstadoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroEstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String MSG_NOT_FOUND_STATES="Não foi Possivel achar o estado com este id:";

    public List <EstadoDTO> listAll(){
        return estadoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
}
    public EstadoDTO addEstado(EstadoDTO estadoDTO){
        Estado estado = convertDtoToEntity(estadoDTO);
        Estado createdEstado = estadoRepository.save(estado);
        return convertEntityToDto(createdEstado);
    }

    public EstadoDTO findById(Long id){
        return estadoRepository.findById(id)
            .map(estado -> convertEntityToDto(estado))
            .orElseThrow(()->  new StatesNotFoundException (String.format(MSG_NOT_FOUND_STATES)+id));
}
    public EstadoDTO updateByid(Long id,EstadoDTO estadoDTO){
        return estadoRepository.findById(id)
            .map(updateEstado -> {
                Estado estado = convertDtoToEntity(estadoDTO);
            updateEstado.setEstado(estado.getEstado());
            Estado update = estadoRepository.save(updateEstado);
            return convertEntityToDto(update);
            }).orElseThrow(()->  new StatesNotFoundException (String.format(MSG_NOT_FOUND_STATES)+id));
}
    public EstadoDTO deleteById(Long id, EstadoDTO estadoDTO){
        return estadoRepository.findById(id)
            .map(estado -> {
                Estado estados = convertDtoToEntity(estadoDTO);
                estadoRepository.deleteById(id);
                return convertEntityToDto(estados);
            }).orElseThrow(()-> new StatesNotFoundException(String.format(MSG_NOT_FOUND_STATES)+id));

    }
    private EstadoDTO convertEntityToDto(Estado estado){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO = modelMapper.map(estado, EstadoDTO.class);
        return estadoDTO;
    }
    private Estado convertDtoToEntity(EstadoDTO estadoDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Estado estado = new Estado();
        estado = modelMapper.map(estadoDTO,Estado.class);
        return estado;
    }

}
