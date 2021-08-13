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

private float(5,2) valor_automovel;
@Column(name = "for_modelo")

private float(5,2) depreciacao;
@Column(name = "for_modelo")

private float(5,2) km_mes;
@Column(name = "for_modelo")

private float(5,2) km_anual;
@Column(name = "for_modelo")

private float(5,2) valor_depreciação;
@Column(name = "for_modelo")

private float(5,2) ipva;
@Column(name = "for_modelo")

private float(5,2) preco_seguro_anual;
@Column(name = "for_modelo")

private float(5,2) custo_seguro_licenciamento_km;
@Column(name = "for_modelo")

private float(5,2) custo_pneu;
@Column(name = "for_modelo")

private float(5,2) vida_util_pneu;
@Column(name = "for_modelo")

private float(5,2) custo_pneu_km;
@Column(name = "for_modelo")

private float(5,2) custo_troca_oleo;
@Column(name = "for_modelo")

private float(5,2) frequencia_km_troca;
@Column(name = "for_modelo")

private float(5,2) custo_oleo_km;
@Column(name = "for_modelo")

private float(5,2) custo_manutenção_anual;
@Column(name = "for_modelo")

private float(5,2) custo_manutencao_km;
@Column(name = "for_modelo")

private float(5,2) aluguel_mensal;
@Column(name = "for_modelo")

private float(5,2) custo_aluguel_km;
@Column(name = "for_modelo")

private float(5,2) preco_gasolina;
@Column(name = "for_modelo")

private float(5,2) consumo_gasolina;
@Column(name = "for_modelo")

private float(5,2) custo_gasolina_km;
@Column(name = "for_modelo")

private float(5,2) preco_etanol;
@Column(name = "for_modelo")

private float(5,2) consumo_etano;
@Column(name = "for_modelo")

private float(5,2) custo_etanol_km;
@Column(name = "for_modelo")

private float(5,2) preco_gnv;
@Column(name = "for_modelo")

private float(5,2) consumo_gnv;
@Column(name = "for_modelo")

private float(5,2) custo_gnv_km;
@Column(name = "for_modelo")

private float(5,2) salario_me;
@Column(name = "for_modelo")

private float(5,2) custo_salario_km;
@Column(name = "for_modelo")

private float(5,2) custo_total_gasolina_km;
@Column(name = "for_modelo")

private float(5,2) custo_total_gasolina_mensal_km;
@Column(name = "for_modelo")

private float(5,2) custo_total_etanol_km;
@Column(name = "for_modelo")

private float(5,2) custo_total_etanol_mensal_km;
@Column(name = "for_modelo")

private float(5,2) custo_total_gnv_km;
@Column(name = "for_modelo")

private float(5,2) custo_total_gnv_mensal_km;
@Column(name = "for_modelo")

private float(5,2) ganho_medio_corrida_km;
@Column(name = "for_modelo")

private float(5,2) ganho_total;
@Column(name = "for_modelo")

private float(5,2) lucro_final_gasolina;
@Column(name = "for_modelo")

private float(5,2) lucro_final_etanol;
@Column(name = "for_modelo")

private float(5,2) lucro_final_gnv;
@Column(name = "for_modelo")

}