package br.gov.sp.fatec.Calculo_do_Km.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.repository.FormularioRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;
import br.gov.sp.fatec.Calculo_do_Km.service.FormularioService;

@SpringBootTest
@Transactional
@Rollback
public class FormularioTestService {

    @Autowired
	FormularioRepository formRepo;

	@Autowired
	UsuarioRepository usuarioRepo; 

    @Autowired
    private FormularioService formServ;


	@Test
	void contextLoads() {
	}

    @Test
    void testaCriacaoFormulario() {
		Formulario formulario = formServ.criaFormulario ("Matheus", "123", "Ford Ka", new BigDecimal("40000"));
        assertNotNull(formulario);
	}	
    
}
