package backenddm20231n.model.bean;

public class Logradouro {
	private int id;
    private String cep;
    private String numero;
    private String compl;
	
	public Logradouro(int id) {
		super();
		this.id = id;
	}
	
	public Logradouro(String cep) {
		super();
		this.cep = cep;
	}

	public Logradouro(int id, String cep, String numero, String compl) {
		super();
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.compl = compl;
	}

	public Logradouro(String cep, String numero, String compl) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.compl = compl;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCompl() {
		return compl;
	}
	public void setCompl(String compl) {
		this.compl = compl;
	}
	@Override
	public String toString() {
		return "Logradouro [id=" + id + ", cep=" + cep + ", numero=" + numero + ", compl=" + compl + "]";
	}
	
}
