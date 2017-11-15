package br.com.valemobitesteback.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.valemobitesteback.jdbc.ConnectionFactory;
import br.com.valemobitesteback.model.CustomerAccount;

public class CustomerDAO {

	public String inserirCustomer(CustomerAccount customer) throws SQLException {
		// Abrindo conexão
		Connection connection = new ConnectionFactory().getConnection();

		// Criando statement
		String sql = "INSERT INTO tb_customer_account" + "(id_customer, cpf_cnpj, nm_customer, is_active, vl_total)"
				+ " values(?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		// Populando valores
		stmt.setInt(1, 0);
		stmt.setString(2, customer.getCpfCnpj());
		stmt.setString(3, customer.getNomeCustomer());
		stmt.setBoolean(4, true);
		stmt.setDouble(5, customer.getValorTotal());

		// Executar comando
		stmt.execute();
		stmt.close();

		System.out.println("Inserido com sucesso!");

		String msg = "Inclusão efetuada com sucesso!";
		connection.close();

		return msg;
	}

	public List<CustomerAccount> calculaMediaCustomers2(List<CustomerAccount> listaCustomer) throws SQLException {
		// Abrindo conexão
		Connection connection = new ConnectionFactory().getConnection();

		// Criando statement
		String sql = "SELECT nm_customer, vl_total FROM tb_customer_account" +
				" WHERE vl_total > 560 AND id_customer BETWEEN 1500 AND 2700 ORDER BY vl_total ASC";

		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
				
		List<CustomerAccount> retorno = new ArrayList<>();
		
		while (rs.next()) {
			final Object nome = rs.getObject(1);
	        final Object valor = rs.getObject(2);
	        CustomerAccount ca = new CustomerAccount();
	        ca.setNomeCustomer(nome.toString());
	        ca.setValorTotal(Double.parseDouble(valor.toString()));
	        System.out.println("Nome: " + ca.getNomeCustomer()+"\nValor: "+ca.getValorTotal());	
	        retorno.add(ca);
	        
		}
		double total = 0.0;
		double avg = 0.0;
		for (int i = 0; i < retorno.size(); i++) {
			total += retorno.get(i).getValorTotal();
			 
		}
		
		avg = total / retorno.size();
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println("Media: " + df.format(avg));
		return retorno;
	}
}
