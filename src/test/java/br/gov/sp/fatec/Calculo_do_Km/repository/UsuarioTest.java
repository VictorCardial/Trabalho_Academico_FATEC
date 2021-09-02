package br.gov.sp.fatec.Calculo_do_Km.repository;

import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
class UsuarioTest {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

	@Test
	void contextLoads() {
	}


    /*save*/

    @Test
    void TesteSaveUsuario()
    {
        Usuario user = new Usuario();
        user.setNome("NomeTest");
        user.setSenha("SenhaTest");
        userRepo.save(user);
        assertNotNull(user.getId());
    }

    /*delete*/

    @Test
    void TesteDeleteUsuario()
    {
        Usuario user = new Usuario();
        user.setNome("NomeTeste");
        user.setSenha("SenhaTeste");
        userRepo.save(user);

        userRepo.deleteById(user.getId());
        Optional opt = userRepo.findById(user.getId());
        assertEquals(Optional.empty(),opt);
    }

    /*update*/

    @Test
    void TesteUpdateUsuario()
    {
        Usuario user = new Usuario();
        user.setNome("NomeTeste");
        user.setSenha("SenhaTeste");
        userRepo.save(user);

        Usuario seguser = userRepo.findById(user.getId()).get();
        seguser.setNome("NomeTeste2");
        assertEquals("SenhaTeste",seguser.getSenha());
    }
    //.get() no final do método

    /*@Test
    void TestaUpdateUsuario2()
    {
        Usuario user = new Usuario();
        user.setId(2L);
        user.setNome("NomeTest");
        userRepo.save(user);
        assertEquals("123",user.getSenha());
    }*/
    //UsuarioTest.TestaUpdateUsuario2:84 expected: <123> but was: <null>

    /**Tentei tirar o Transactional e Rollback, porém, não funcionou e retornou DataIntegrityViolation*/


    /*buscar(id)*/


    /*restrições (exceptions)*/
    /*relacionamentos*/
    /*teste repository*/
}