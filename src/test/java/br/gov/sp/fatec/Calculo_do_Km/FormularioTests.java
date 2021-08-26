package br.gov.sp.fatec.Calculo_do_Km;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.FormularioRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class FormularioTests {

	@Autowired
	FormularioRepository formRepo;

	@Autowired
	UsuarioRepository usuarioRepo; 


	@Test
	void contextLoads() {
	}

	// save
	@Test
    void testaCriacaoFormulario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Lucas");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("renault kwid");
		form.setValorAutomovel(new BigDecimal("40000"));
		formRepo.save(form);

		assertEquals("renault kwid", form.getModelo());
		assertNotNull(form.getId());
	}	
	
	// delete
	// @Test
    // void testaDeleteFormulario() {
	// 	Formulario formulario = formRepo.buscaFormularioPorIdQuery(1l);
	// 	formRepo.delete(formulario);

	// 	Formulario auxForm = formRepo.buscaFormularioPorIdQuery(1l);
	// }

	// update
	@Test
	void testaAtualizacaoFormulario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Joao");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		Formulario form = new Formulario();
		form.setUsuario(usuario);
		form.setModelo("Honda Civic");
		form.setValorAutomovel(new BigDecimal("90000"));
		formRepo.save(form);

		form.setModelo("Fiat Palio");

		assertEquals("Fiat Palio", form.getModelo());
	}

	// restrições (exceptions)
	

	// teste repository
	@Test
	void testaBuscaFormularioPorModeloQuery() {
		List<Formulario> formulario = formRepo.buscaFormularioPorModeloQuery("Corolla");
		assertNotNull(formulario);
	}

	@Test
	void testaBuscaTodosFormularioPorUsuarioNomeQuery() {
		List<Formulario> formulario = formRepo.buscaTodosFormularioPorUsuarioNomeQuery("victor");
		assertNotNull(formulario);
	}

	// relacionamentos
	@Test
	void tesaBuscaFormularioPorUsuarioNomeEValorQuery() {
		List<Formulario> formulario = formRepo.buscaFormularioPorUsuarioNomeEValorQuery("hercules", new BigDecimal("5001"));
		assertTrue(formulario.isEmpty());
	}

}
