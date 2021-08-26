package br.gov.sp.fatec.Calculo_do_Km;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.repository.AutorizacaoRepository;
import br.gov.sp.fatec.Calculo_do_Km.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class AutorizacaoTest {

	@Autowired
    private AutorizacaoRepository autRepo;

	@Autowired
    private UsuarioRepository userRepo;

	@Test
	void contextLoads() {
	}

	/*Testando a classe de autorizacao*/

	/*save*/

	@Test
	void TestaInsercaoAutorizacao()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);
		assertNotNull(aut.getId());
	}

	/*delete*/
	/*update*/
	/*buscar(id)*/
	/*restrições (exceptions)*/
	/*relacionamentos*/

	/**Relacionamento N:N entre Autorizacao e Usuario */
	@Test
	void TesteAutorizacaoNparaNUsuario()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);
		Usuario user = new Usuario();
		user.setNome("NomeUser");
		user.setSenha("SenhaUser");
		user.setAutorizacoes(new HashSet<Autorizacao>());
		user.getAutorizacoes().add(aut);
		userRepo.save(user);

		assertNotNull(aut.getId());
	}

	/*teste repository*/

	@Test
	void TesteFindByNomeAutorizacao()
	{
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTER");
		autRepo.save(aut);
		assertNotNull(autRepo.findByNome("ROLE_TESTER"));
	}

}