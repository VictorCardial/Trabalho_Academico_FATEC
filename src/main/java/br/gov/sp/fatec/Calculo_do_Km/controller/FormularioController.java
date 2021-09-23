package br.gov.sp.fatec.Calculo_do_Km.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.Calculo_do_Km.entity.Formulario;
import br.gov.sp.fatec.Calculo_do_Km.service.FormularioService;

@RestController
@RequestMapping(value = "/formulario")
@CrossOrigin
public class FormularioController {

    @Autowired
    FormularioService formService;

    @JsonView(View.FormularioResumo.class)
    @GetMapping()
    public List<Formulario> buscarTodos() {
        return formService.buscarTodosFormularios();
    }

    @JsonView(View.FormularioCompleto.class)
    @GetMapping(value = "/{id}")
    public Formulario buscarPorId(@PathVariable("id") Long id) {
        return formService.buscarFormularioPorId(id);
    }

    @JsonView(View.FormularioResumo.class)
    @GetMapping(value = "/modelo")
    public List<Formulario> buscarPorNome(@RequestParam(value="modelo") String modelo) {
        return formService.buscarFormularioPorModelo(modelo);
    }

    // @JsonView(View.FormularioResumo.class)
    // @PostMapping
    // public ResponseEntity<Formulario> cadastraNovoFormulario (@RequestBody Formulario formulario,
    //        UriComponentsBuilder uriComponentsBuilder) {
    //     formulario = formService.criaFormulario(, senha, modelo, valorCarro)
    // }

}
