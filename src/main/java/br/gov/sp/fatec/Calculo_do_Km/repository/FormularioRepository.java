package br.gov.sp.fatec.Calculo_do_Km.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {

    // public Formulario findById (Long id);

    @Query("select f from Formulario f where f.modelo =?1")
    public List<Formulario> buscaFormularioPorId(Long id);

    public List<Formulario> findByAll();

    @Query("select f from Formulario f inner join f.modelo d where d.modelo =?1")
    public List<Formulario> buscaFormularioPorModelo(String modelo);

    @Query("select f from Formulario f inner join f.modelo d where d.modelo =?1 and d.valor_automovel = ?2")
    public List<Formulario> buscaFormularioPorModeloEValor(String modelo, BigDecimal valor);

    // @Query("select f from Filme f inner join f.diretor d where d.nome =?1")
    // public List<Filme> buscaFilmePorDiretor(String diretor);

    // @Query("select f from Filme f inner join f.diretor d where f.nome = ?1 and d.nome = ?2")
    // public Formulario buscaFilmePorNomeEDiretor(String filme, String diretor);
}
