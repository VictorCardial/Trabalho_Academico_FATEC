package br.gov.sp.fatec.Calculo_do_Km.service;

import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;

public interface UsuarioService {

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Usuario criaUsuario(String nome, String senha, String autorizacao);

    public void deleteUsuario(Long id);

    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao);
    
}
