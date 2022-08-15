package com.estagio.estudos.BlinksFoodAPI.controller;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Restaurante;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.repository.RestauranteRepository;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.service.CadastroRestauranteService;
import com.estagio.estudos.BlinksFoodAPI.dto.RestauranteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<RestauranteDTO> listAll() {
        return cadastroRestauranteService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteDTO adcionar(@RequestBody RestauranteDTO restauranteDTO) {
        return cadastroRestauranteService.saveRestaurante(restauranteDTO);
    }
    @GetMapping("/por-taxa-frete")
    public List<Restaurante> findBetween( BigDecimal taxaInicial,BigDecimal taxaFinal){
        return restauranteRepository.findBytaxafreteBetween(taxaInicial,taxaFinal);
    }
    @GetMapping(value = "{restaurantesId}")
    public RestauranteDTO findByIdRest(@PathVariable("restaurantesId") Long id) {
        return cadastroRestauranteService.finById(id);
    }
    @PutMapping(value = "{restaurantesId}")
    public RestauranteDTO atualizar(@RequestBody RestauranteDTO restauranteDTO, @PathVariable("restaurantesId")Long id){
       return cadastroRestauranteService.updateRestauranteByid(id,restauranteDTO);
    }
    @DeleteMapping(value = "{restaurantesId}")
    @ResponseStatus(HttpStatus.CONFLICT)
    public RestauranteDTO deleteById( @PathVariable ("restaurantesId")Long id, @RequestBody RestauranteDTO restauranteDTO){
       return cadastroRestauranteService.deleteById(id,restauranteDTO);
    }
}
