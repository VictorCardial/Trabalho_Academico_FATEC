package br.gov.sp.fatec.Calculo_do_Km.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.FormularioRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@Service("FormularioService")
public class FormularioServiceImpl implements FormularioService {

    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    FormularioRepository formRepo;
    
    // @Override
    // public Formulario buscarFormularioPorId(Long id){
    //     return null;

    // }
    

    // @Override
    // public List<Formulario> buscarFormularioPorModelo (String modelo){
    //     List<Formulario> formulario = formRepo.querybuscaFormularioPorModelo(modelo);

    //     if(formulario!=null) {
    //         return formulario;
    //     }
    // }

    @Override
    @Transactional
    public Formulario criaFormulario (String nome, String senha, String modelo, BigDecimal valorCarro) {
        Usuario user = userRepo.findByNome(nome);

        if(user == null) {
            user = new Usuario();
            user.setNome(nome);
            user.setSenha(senha);
            userRepo.save(user);
        }

        Formulario formulario = new Formulario();
        formulario.setUsuario(user);
		formulario.setModelo(modelo);
		formulario.setValorAutomovel(valorCarro);
		formRepo.save(formulario);

        return formulario;
    }

    // @Override
    // public void deleteFormulario(Long id){

    // }

    // @Override
    // public Formulario updateFormulario(Long id, String nome, String senha, String autorizacao){
    //     return null;
    // }

}
