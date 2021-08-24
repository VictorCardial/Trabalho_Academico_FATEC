package br.gov.sp.fatec.Calculo_do_Km.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.Calculo_do_Km.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String autorizacao);
    
}