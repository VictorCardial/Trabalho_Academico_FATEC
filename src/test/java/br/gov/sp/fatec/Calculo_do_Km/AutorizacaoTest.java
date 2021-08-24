package br.gov.sp.fatec.Calculo_do_Km;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;
import br.gov.sp.fatec.Calculo_do_Km.repository.AutorizacaoRepository;

@SpringBootTest
@Transactional
@Rollback
class AutorizacaoTest {

	@Autowired
    private AutorizacaoRepository autRepo;

	@Test
	void contextLoads() {
	}

	/*Testando a classe de autorizacao*/

    /*Testando insercao*/
	@Test
    void testaCriacaoAutorizacao() {
		Autorizacao aut = new Autorizacao();
		aut.setNome("ROLE_TESTE");
		autRepo.save(aut);
		
		assertNotNull(aut.getId());
	}

    /*Testando modificacao*/
	@Test
    void testamodificacaoAutorizacao() {
		Autorizacao aut = autRepo.getById(3l);
		aut.setNome("ROLE_TESTANDO");

		assertEquals("ROLE_TESTANDO", aut.getNome());
	}

    /*Testando delecao*/

    /*Testando busca*/

    /*Testando restricoes*/

    /*Testando relacionamento (se houver)*/

    /*Testando exceptions...*/

}