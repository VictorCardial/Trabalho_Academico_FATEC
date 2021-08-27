package br.gov.sp.fatec.Calculo_do_Km.service;

import java.math.BigDecimal;
import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;


public interface FormularioService {

    // public Formulario buscarFormularioPorId(Long id);

    // public List<Formulario> buscarFormularioPorModelo(String modelo);

    public Formulario criaFormulario (String nome, String senha, String modelo, BigDecimal valorCarro);

    // public void deleteFormulario(Long id);

    // public Formulario updateFormulario(Long id, String nome, String senha, String autorizacao);

}
