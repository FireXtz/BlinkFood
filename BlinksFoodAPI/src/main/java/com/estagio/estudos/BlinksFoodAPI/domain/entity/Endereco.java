package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity(name = "endereco")
@Table(name = "tbl_endereco")
public class Endereco {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id",nullable = false)
	@Id
	private Long id;
	@Column(name = "endereco_cep",nullable = false)
	private String cep;
	@Column(name = "endereco_logradouro",nullable = false)
	private String logradouro;
	@Column(name = "endereco_numero",nullable = false)
	private String numero;
	@Column(name = "endereco_complemento",nullable = false)
	private String complemento;
	@Column(name = "endereco_bairro",nullable = false)
	private String bairro;
	@ManyToOne
	private Cidade cidade;

}
