package br.com.valemobitesteback.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.valemobitesteback.dao.CustomerDAO;

public class TesteCustomer {

	public static void main(String[] args) throws SQLException {

		List<CustomerAccount> listaCustomer = incluirCustomers();

		CustomerDAO customerMedia = new CustomerDAO();

		List<CustomerAccount> custumers = new ArrayList<CustomerAccount>();

		custumers = customerMedia.calculaMediaCustomers2(listaCustomer);
		
	 

	}

	public static List<CustomerAccount> incluirCustomers() throws SQLException {

		// Criando customers
		CustomerAccount customer1 = new CustomerAccount();
		customer1.setCpfCnpj("44944432190");
		customer1.setNomeCustomer("Gabriel Araujo");
		customer1.setValorTotal(559);

		CustomerAccount customer2 = new CustomerAccount();
		customer2.setCpfCnpj("44944432191");
		customer2.setNomeCustomer("Caique Andrade");
		customer2.setValorTotal(560);

		CustomerAccount customer3 = new CustomerAccount();
		customer3.setCpfCnpj("44944432192");
		customer3.setNomeCustomer("Guilherme José");
		customer3.setValorTotal(561);

		CustomerAccount customer4 = new CustomerAccount();
		customer4.setCpfCnpj("44944432193");
		customer4.setNomeCustomer("Marcela Fernandes");
		customer4.setValorTotal(562);

		// Passando objetos para DAO
		CustomerDAO ct1 = new CustomerDAO();
		ct1.inserirCustomer(customer1);

		CustomerDAO ct2 = new CustomerDAO();
		ct2.inserirCustomer(customer2);

		CustomerDAO ct3 = new CustomerDAO();
		ct3.inserirCustomer(customer3);

		CustomerDAO ct4 = new CustomerDAO();
		ct4.inserirCustomer(customer4);

		List<CustomerAccount> listaCustomer = new ArrayList<CustomerAccount>();
		listaCustomer.add(customer1);
		listaCustomer.add(customer2);
		listaCustomer.add(customer3);
		listaCustomer.add(customer4);

		return listaCustomer;
	}
	
	
}
