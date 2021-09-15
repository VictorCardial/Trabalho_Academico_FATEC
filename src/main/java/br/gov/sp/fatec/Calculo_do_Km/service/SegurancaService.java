package br.gov.sp.fatec.Calculo_do_Km.service;

import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;

public interface SegurancaService {
    
    public Usuario cadastroUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Autorizacao buscarAutorizacaoPorNome(String nome);

}
