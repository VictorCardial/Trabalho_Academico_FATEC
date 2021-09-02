package br.gov.sp.fatec.Calculo_do_Km.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.AutorizacaoRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

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

        if(aut==null)
        {
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
    
}
