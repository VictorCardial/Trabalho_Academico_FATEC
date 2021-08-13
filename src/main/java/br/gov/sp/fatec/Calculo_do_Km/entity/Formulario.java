package br.gov.sp.fatec.Calculo_do_Km.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "for_formulario")
public class Formulario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "for_id")
private Long id;

@Column(name = "for_modelo")
private String modelo;

// @Digits(integer=5, fraction=2)
// @Column(name = "for_valor_automovel")
// private BigDecimal  valor_automovel;

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getModelo() {
    return this.modelo;
}

public void setModelo(String modelo) {
    this.modelo = modelo;
}

}