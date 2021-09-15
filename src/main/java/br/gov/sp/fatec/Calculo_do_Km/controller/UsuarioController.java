package br.gov.sp.fatec.Calculo_do_Km.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.Calculo_do_Km.entity.Usuario;
import br.gov.sp.fatec.Calculo_do_Km.service.SegurancaService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

  @Autowired
  private SegurancaService segurancaService;

  @GetMapping()
  public List<Usuario> buscarTodos() {
    return segurancaService.buscarTodosUsuarios();
  }

}
