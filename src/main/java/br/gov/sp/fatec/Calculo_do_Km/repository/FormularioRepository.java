package br.gov.sp.fatec.Calculo_do_Km.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {

    @Query("select f from Formulario f where f.id =?1")
    public Formulario buscaFormularioPorIdQuery(Long id);

    @Query("select f from Formulario f")
    public Formulario buscaTodosFormulariosQuery();

    @Query("select f from Formulario f where f.modelo =?1")
    public List<Formulario> buscaFormularioPorModeloQuery(String modelo);

    @Query("select f from Formulario f inner join f.usuario u where u.nome =?1 ")
    public List<Formulario> buscaTodosFormularioPorUsuarioNomeQuery(String nome);

    @Query("select f from Formulario f inner join f.usuario u where u.nome =?1 and f.valor_automovel = ?2")
    public List<Formulario> buscaFormularioPorUsuarioNomeEValorQuery(String nome, BigDecimal valor);
    
}
