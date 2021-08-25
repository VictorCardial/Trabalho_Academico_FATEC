package br.gov.sp.fatec.Calculo_do_Km.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String autorizacao);

    @Query("select a from Autorizacao a")
    public Autorizacao buscaTodasAutorizacaoQuery();

    @Query("select a from Autorizacao a where a.nome =?1")
    public Autorizacao buscaAutorizacaoPorNome(String nome);    
}