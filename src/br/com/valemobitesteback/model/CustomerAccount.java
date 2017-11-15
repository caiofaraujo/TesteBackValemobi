package br.com.valemobitesteback.model;

public class CustomerAccount {

	String cpfCnpj;
	String nomeCustomer;
	boolean ativo;
	double valorTotal;
	
	public CustomerAccount() {

	}
	
	public CustomerAccount(String cpfCnpj, String nome, double valor) {
		this.cpfCnpj = cpfCnpj;
		this.nomeCustomer = nome;
		this.valorTotal = valor;
		this.ativo = true;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNomeCustomer() {
		return nomeCustomer;
	}

	public void setNomeCustomer(String nomeCustomer) {
		this.nomeCustomer = nomeCustomer;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
