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
    
    @Override
    public Formulario buscarFormularioPorId(Long id){
        if(id != null && id > 0) {
            Formulario formulario = formRepo.querybuscaFormularioPorId(id);
            return formulario;
        }
        return null;
    }

    @Override
    public List<Formulario> buscarFormularioPorModelo (String modelo) {
        List<Formulario> formulario = formRepo.querybuscaFormularioPorModelo(modelo);

        if(!(formulario.isEmpty())) { // negação de vazio 
            return formulario;
        }
        return null;
    }

    @Override
    public List<Formulario> buscaFormularioPorUsuarioNomeEValorSuperior(String nome, BigDecimal valor) {
        if(nome != "" /*&& valor.compareTo(val)*/) {
            List<Formulario> formulario = formRepo.queryBuscaFormularioPorUsuarioNomeEValorSuperior(nome, valor);
            return formulario;
        }
        
        return null;
    }

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

    @Override
    public void deleteFormulario(Long id){
        Formulario formulario = formRepo.querybuscaFormularioPorId(id);
            if(id != null && id > 0) {
                formRepo.deleteById(formulario.getId());
            }
    }

    @Override
    public Formulario updateFormulario (Long id, String modelo, BigDecimal valorCarro) {
        Formulario formulario = formRepo.querybuscaFormularioPorId(id);
            if(id != null && id > 0) { 
                formulario.setModelo(modelo);
                formulario.setValor_automovel(valorCarro);
                formRepo.save(formulario);
                return formulario;
            }
        return null;
    }
}