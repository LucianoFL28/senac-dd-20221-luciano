package executavel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dao.EnderecoDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.LinhaTelefonica;
import model.entity.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] argumentos) {
		testarCrudEndereco();
		
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		
//		Endereco endereco1 = new Endereco("Mauro Ramos", "10", "Florian�polis", 
//				"SC", "88320-005"); 
//		
//		Telefone t1 = new Telefone("48", "3232-5555", Telefone.TIPO_FIXO, true);
//		Telefone t2 = new Telefone("47", "3232-1010", Telefone.TIPO_MOVEL, true);
//		LinhaTelefonica l1 = new LinhaTelefonica(t1, 10, LocalDateTime.now(), null);
//		LinhaTelefonica l2 = new LinhaTelefonica(t2, 10, LocalDateTime.now(), null);
//		
//		List<LinhaTelefonica> linhasDoPele = new ArrayList<LinhaTelefonica>();
//		linhasDoPele.add(l1);
//		linhasDoPele.add(l2);
//		
//		Cliente pele = new Cliente("Edson Arantes", "01001011100", 
//				endereco1, linhasDoPele);
//		
//		clientes.add(pele);
//		
//		for(LinhaTelefonica linha: pele.getLinhas()) {
//			System.out.println(linha.getTelefone().toString());
//		}
	}

	private static void testarCrudEndereco() {
		//Violando o MVC, pois o main vai chamar a camada de modelo
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco novo = new Endereco("Anita Garibaldi", "300", "Florian�polis", 
				"SC", "88320005");
		
		System.out.println("#Teste de insert");
		dao.inserir(novo);
		
		int idDoNovoEndereco = novo.getId();
		System.out.println(idDoNovoEndereco > 0 ? "Salvou novo endere�o" : "N�o salvou");
		
		novo.setRua("Rua alterada");
		
		System.out.println("#Teste de update");
		boolean atualizou = dao.atualizar(novo);
		
		System.out.println(atualizou ? "Endere�o atualizado" : "Endere�o n�o atualizado");
		
		System.out.println("#Teste de select");
		Endereco enderecoConsultado = dao.consultar(idDoNovoEndereco);
		System.out.println("Endere�o consultado por id (" + idDoNovoEndereco + "): " 
				+ enderecoConsultado.toString());

		System.out.println("#Teste de delete");
		dao.remover(novo.getId());
		
		System.out.println("#Teste de select");
		Endereco enderecoConsultadoAposRemocao = dao.consultar(idDoNovoEndereco);
		System.out.println(enderecoConsultadoAposRemocao == null ? "Endere�o n�o existe (ok)" : 
			"Endere�o n�o foi devidamente exclu�do");
		//////////////
		
	}
}
