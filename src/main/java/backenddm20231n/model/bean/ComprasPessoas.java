package backenddm20231n.model.bean;

public class ComprasPessoas {
	
	private int id;
	private int idP;
	private int idCom;
	private Pessoa pessoa;
	private Compra compra;
	private String obs;
	
	public ComprasPessoas(String obs) {
		super();
		this.obs = obs;
	}
	public ComprasPessoas(int id) {
		super();
		this.id = id;
	}
	public ComprasPessoas(int idP, int idCom, String obs) {
		super();
		this.idP = idP;
		this.idCom = idCom;
		this.obs = obs;
	}
	public ComprasPessoas(int id, int idP, int idCom, String obs) {
		super();
		this.id = id;
		this.idP = idP;
		this.idCom = idCom;
		this.obs = obs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public int getIdCom() {
		return idCom;
	}
	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "ComprasPessoas [id=" + id + ", idP=" + idP + ", idCom=" + idCom + "\n pessoa=" + pessoa + "\n compra="
				+ compra + "obs="+ obs + "]";
	}
}
