package backenddm20231n.model.bean;

import java.sql.Date;

public class Compra {
	private int id;
	private String formaPagamento;
	private Date data;
	private double total;
	
	public Compra(int id) {
		super();
		this.id = id;
	}
	public Compra(String formaPagamento, Date data, double total) {
		super();
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.total = total;
	}
	public Compra(int id, String formaPagamento) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
	}
	public Compra(Date data) {
		super();
		this.data = data;
	}
	public Compra(int id, String formaPagamento, Date data, double total) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Compra [id=" + id + ", formaPagamento=" + formaPagamento
				+ ", data=" + data + ", total=" + total + "]";
	}
}