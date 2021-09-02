package br.gov.sp.fatec.Calculo_do_Km.service;

import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;

public interface SegurancaService {
    
    public Usuario cadastroUsuario(String nome, String senha, String autorizacao);

}
