package br.gov.sp.fatec.Calculo_do_Km.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {

    @Query("select f from Formulario f where f.modelo =?1")
    public Formulario buscaFormularioPorId(Long id);

    @Query("select f from Formulario f")
    public Formulario buscaTodosFormularios();

    @Query("select f from Formulario f where f.modelo =?1")
    public List<Formulario> buscaFormularioPorModelo(String modelo);

    @Query("select f from Formulario f inner join f.usuario d where d.nome =?1 and f.valor_automovel = ?2")
    public List<Formulario> buscaFormularioPorModeloEValor(String nome, BigDecimal valor);

    // @Query("select f from Filme f inner join f.diretor d where d.nome =?1")
    // public List<Filme> buscaFilmePorDiretor(String diretor);

    // @Query("select f from Filme f inner join f.diretor d where f.nome = ?1 and d.nome = ?2")
    // public Formulario buscaFilmePorNomeEDiretor(String filme, String diretor);
}
