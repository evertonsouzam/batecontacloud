package br.com.everton.bateconta.batecontacloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everton.bateconta.batecontacloud.component.UsuarioComponent;
import br.com.everton.bateconta.batecontacloud.model.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioComponent usuarioComponet;
	
	@GetMapping("/login/{nome}/{senha}")
	public Usuario login(@PathVariable(value= "nome") String nome, @PathVariable(value= "senha") String senha) {
		System.out.println("############");
		System.out.println("nome:" + nome);
		System.out.println("############");
		
		if (nome != null && senha != null) {
			Usuario usuario = usuarioComponet.buscarUsuario(nome);
			if (usuario.getSenha().equals(senha)) {
				System.out.println("true");
				return usuario;
			}
		}
		System.out.println("false");
		return new Usuario();
	}
	
	@GetMapping("/buscar/{nome}")
	public Usuario buscar(@PathVariable(value= "nome") String nome) {
		System.out.println("############");
		System.out.println("buscar:" + nome);
		System.out.println("############");
		
		return usuarioComponet.buscarUsuario(nome);
		
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody Usuario usuario) {
		usuarioComponet.salvar(usuario);
	}
	
}
