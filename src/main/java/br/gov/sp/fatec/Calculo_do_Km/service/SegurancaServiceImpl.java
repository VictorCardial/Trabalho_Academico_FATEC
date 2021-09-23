package br.gov.sp.fatec.Calculo_do_Km.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.AutorizacaoRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;
import br.gov.sp.fatec.Calculo_do_Km.exception.RegistroNaoEncontradoException;

@Service
public class SegurancaServiceImpl implements SegurancaService{

    @Autowired
    public UsuarioRepository userRepo;

    @Autowired
    public AutorizacaoRepository autRepo;

    @Override
    @Transactional
    public Usuario cadastroUsuario(String nome, String senha, String autorizacao) {

        Autorizacao aut = autRepo.findByNome(autorizacao);

        if(aut==null){
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }

        Usuario user = new Usuario();
        user.setNome(nome);
        user.setSenha(senha);
        user.setAutorizacoes(new HashSet<Autorizacao>());
        user.getAutorizacoes().add(aut);
        userRepo.save(user);

        return user;
    }
    
    @Override
    public List<Usuario> buscarTodosUsuarios() {
      return userRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
      Optional<Usuario> usuarioOp = userRepo.findById(id);
      if(usuarioOp.isPresent()) {
        return usuarioOp.get();
      }
      throw new RegistroNaoEncontradoException("Usuário não encontrado!");
    }

    @Override
    public Usuario buscarUsuarioPorNome(String nome) {
      Usuario usuario = userRepo.findByNome(nome);
      if(usuario != null) {
        return usuario;
      }
      throw new RegistroNaoEncontradoException("Usuário não encontrado!");
    }

    @Transactional
    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao) {

        Autorizacao aut = autRepo.findByNome(autorizacao);
        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }

        return userRepo.findById(id)
           .map(user -> {
               user.setNome(nome);
               user.setSenha(senha);
               Usuario updated = userRepo.save(user);

               return updated;
        }).orElse(null);

    }

    public void deleteUsuario(Long id) {
      userRepo.deleteById(id);       
    }

    @Override
    public Autorizacao buscarAutorizacaoPorNome(String nome) {
      Autorizacao autorizacao = autRepo.findByNome(nome);
      if(autorizacao != null) {
        return autorizacao;
      }
      throw new RegistroNaoEncontradoException("Autorização não encontrada!");
    }
    
}
