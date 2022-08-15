package com.estagio.estudos.BlinksFoodAPI.domain.entity.service;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.FormaPagamento;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.StatesNotFoundException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.FormaPagamentoRepository;
import com.estagio.estudos.BlinksFoodAPI.dto.FormaPagamentoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroFormaPagamentoService {
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String MSG_NOT_FOUND_FORM_PAYMOUNT = "Não foi possivel achar essa forma de pagamento, id usado:";
    public List<FormaPagamentoDTO> listAllFormasPamentos(){
        return formaPagamentoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    public FormaPagamentoDTO addFormaspagamentos(FormaPagamentoDTO formaPagamentoDTO){
       FormaPagamento formaPagamento = convertDtoToEntity(formaPagamentoDTO);
       FormaPagamento createdFormaPagamento = formaPagamentoRepository.save(formaPagamento);
       return convertEntityToDto(createdFormaPagamento);
    }
    public FormaPagamentoDTO findFormasPagamentosbyId(Long id){
        return formaPagamentoRepository.findById(id)
                .map(formaPagamento -> convertEntityToDto(formaPagamento))
                .orElseThrow(()-> new StatesNotFoundException(String.format(MSG_NOT_FOUND_FORM_PAYMOUNT)+id));
    }
    public FormaPagamentoDTO updateFormasPagamentosbyId(Long id, FormaPagamentoDTO formaPagamentoDTO){
        return formaPagamentoRepository.findById(id)
                .map(updateFormaPagamentos -> {
                    FormaPagamento formaPagamento = convertDtoToEntity(formaPagamentoDTO);
                    updateFormaPagamentos.setFormapagamento(formaPagamento.getFormapagamento());
                     FormaPagamento updated = formaPagamentoRepository.save(updateFormaPagamentos);
                    return convertEntityToDto(updated);
                }).orElseThrow(()-> new StatesNotFoundException(String.format(MSG_NOT_FOUND_FORM_PAYMOUNT)+id));
    }
    public FormaPagamentoDTO deleteFormaPagamentoByid(Long id,FormaPagamentoDTO formaPagamentoDTO){
     return formaPagamentoRepository.findById(id)
             .map(formaPagamento1 -> {
                 FormaPagamento formaPagamento = convertDtoToEntity(formaPagamentoDTO);
                 formaPagamentoRepository.deleteById(id);
                 return convertEntityToDto(formaPagamento);
             }).orElseThrow(() -> new StatesNotFoundException(String.format(MSG_NOT_FOUND_FORM_PAYMOUNT)+id));
    }
    private FormaPagamentoDTO convertEntityToDto(FormaPagamento formaPagamento){
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.LOOSE);
                FormaPagamentoDTO formaPagamentoDTO = new FormaPagamentoDTO();
                formaPagamentoDTO = modelMapper.map(formaPagamento,FormaPagamentoDTO.class);
                return formaPagamentoDTO;
    }
    private FormaPagamento convertDtoToEntity(FormaPagamentoDTO formaPagamentoDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento = modelMapper.map(formaPagamentoDTO,FormaPagamento.class);
        return formaPagamento;
    }
}
