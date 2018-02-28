package br.com.everton.bateconta.batecontacloud.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.everton.bateconta.batecontacloud.model.Conta;
import br.com.everton.bateconta.batecontacloud.repository.ContaRepository;

@Component
public class ContaComponent {

	@Autowired
	ContaRepository contaRepository;
	UsuarioComponent usuarioComponent;
	
	public void deletarProduto(Conta conta) {
		
		contaRepository.delete(buscarProduto(conta.getUsuario(), conta.getProduto()));
	}
	
	public void deletarConta(String usuario) {
		
		contaRepository.delete(buscarConta(usuario));
	}
	
	public void salvar(Conta conta) {
		
		Conta contaRetorno = buscarProduto(conta.getUsuario(), conta.getProduto());
		if(contaRetorno != null) {
			conta.setId(contaRetorno.getId());
		}
		contaRepository.save(conta);
	}
		
	public List<Conta> buscarConta(String usuario) {

		List<Conta> contas = contaRepository.findContaByUsuario(usuario);
		if(contas.isEmpty()) {
			System.out.println("Nao achou contas para o usuario" + usuario);
			Conta conta = new Conta();
			conta.setProduto("Edite este produto ou adicione um novo atraves do +");
			conta.setQuantidade(0);
			conta.setValor(0.00);
			contas.add(conta);
		}
		System.out.println("Entrou no buscar conta :" + contas.size());
		return contas;
		
		
				
	}

	public Conta buscarProduto(String usuario, String produto) {
		List<Conta> contas = buscarConta(usuario);
		for (Conta conta : contas) {
			if (conta.getProduto() != null && conta.getProduto().equals(produto)) {
				return conta;
			}
		}
		return null;
	}

	public List<Conta> buscarTodos() {
		return contaRepository.findAll();
	}

	public Double valorConta(String usuario) {
		List<Conta> contas = buscarConta(usuario);
		Double total = 0.00;
		
		for (Conta conta : contas) {
			if(conta.getValor() != null && conta.getQuantidade() > 0 ) {
				Double valor = conta.getValor() * conta.getQuantidade();
				total += valor;
			}
			
		}
		return total;
	}
		
}
