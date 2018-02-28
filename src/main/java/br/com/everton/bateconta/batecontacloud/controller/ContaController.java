package br.com.everton.bateconta.batecontacloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everton.bateconta.batecontacloud.component.ContaComponent;
import br.com.everton.bateconta.batecontacloud.model.Conta;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

	@Autowired
	public ContaComponent contaComponet;
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody Conta conta) {
		
		contaComponet.salvar(conta);
	}
	
	@GetMapping("/buscarProduto/{usuario}/{produto}")
	public Conta buscarProduto(@PathVariable(value= "usuario") String usuario, @PathVariable(value= "produto") String produto) {
		System.out.println("############");
		System.out.println("buscar Produtos:" + usuario);
		System.out.println("############");
		
		return contaComponet.buscarProduto(usuario , produto);
		
	}
	
	@GetMapping("/buscarConta/{usuario}")
	public List<Conta> buscarConta(@PathVariable(value= "usuario") String usuario) {
		System.out.println("############");
		System.out.println("buscar Produtos:" + usuario);
		System.out.println("############");
		
		return contaComponet.buscarConta(usuario);
		
	}
	
	@GetMapping("/valorConta/{usuario}")
	public Double valorConta(@PathVariable(value= "usuario") String usuario) {
		System.out.println("############");
		System.out.println("Valor Conta para :" + usuario);
		System.out.println("############");
		
		return contaComponet.valorConta(usuario);
		
	}

	@DeleteMapping("/delete/{usuario}/{produto}")
	public void apagarProdutoConta(@PathVariable(value= "usuario") String usuario, @PathVariable(value= "produto") String produto) {
    try {
        Conta conta = new Conta();
        conta.setUsuario(usuario);
        conta.setProduto(produto);
        contaComponet.deletarProduto(conta);
    } catch (Exception e) {
        
    }
	}
	
	@DeleteMapping("/delete/{usuario}")
	public void apagarConta(@PathVariable(value= "usuario") String usuario) {
    try {
        contaComponet.deletarConta(usuario);
    } catch (Exception e) {
        
    }
	}
	
	@GetMapping("/buscarTodos")
	public List<Conta> buscarProduto() {
		System.out.println("############");
		System.out.println("buscar Todos Produtos:");
		System.out.println("############");
		
		return contaComponet.buscarTodos();
		
	}
}
