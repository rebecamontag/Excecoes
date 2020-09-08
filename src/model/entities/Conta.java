package model.entities;

import model.exceptions.DomainException;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta(Integer numero, String titular, Double saldo) {
		if (saldo < 0) {
			throw new DomainException("Erro: Não é possível lançar um saldo negativo");
		}
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		if (saldo < 0) {
			throw new DomainException("Erro: Não é possível lançar um saldo negativo");
		}
		if (limiteSaque < 0) {
			throw new DomainException("Erro: Não é possível ter um limite de saque negativo");
		}
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(Double quantia) {
		saldo += quantia;
	}

	public void saque(Double quantia) {
		if (quantia > getLimiteSaque()) {
			throw new DomainException("Erro: A quantia excede o limite de saque");
		}
		if (quantia > getSaldo()) {
			throw new DomainException("Erro: Saldo insuficiente");
		}
		saldo -= quantia;
	}

	@Override
	public String toString() {
		return "Novo saldo: $ " + String.format("%.2f", getSaldo());
	}

}
