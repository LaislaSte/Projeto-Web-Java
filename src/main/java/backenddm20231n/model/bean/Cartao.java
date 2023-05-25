package backenddm20231n.model.bean;

import java.sql.Date;

public class Cartao {
	
	private int id;
	private String numeroSerie;
	private String banco;
	private Date dataVencimento;
	
	public Cartao(int id) {
		super();
		this.id = id;
	}
	public Cartao(String banco) {
		super();
		this.banco = banco;
	}

	public Cartao(String numeroSerie, String banco, Date dataVencimento) {
		super();
		this.numeroSerie = numeroSerie;
		this.banco = banco;
		this.dataVencimento = dataVencimento;
	}
	
	public Cartao(int id, String numeroSerie, String banco, Date dataVencimento) {
		super();
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.banco = banco;
		this.dataVencimento = dataVencimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", numeroSerie=" + numeroSerie + ", banco=" + banco
				+ ", dataVencimento=" + dataVencimento + "]";
	}
	
}
