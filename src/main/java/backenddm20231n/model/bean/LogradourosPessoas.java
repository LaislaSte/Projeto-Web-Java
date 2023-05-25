package backenddm20231n.model.bean;

public class LogradourosPessoas {
	
	private int id;
	private int idP;
	private int idL;
	private Pessoa pessoa;
	private Logradouro logradouro;
	private String obs;
	
	public LogradourosPessoas(String obs) {
		super();
		this.obs = obs;
	}
	public LogradourosPessoas(int id) {
		super();
		this.id = id;
	}
	public LogradourosPessoas(int idP, int idL, String obs) {
		super();
		this.idP = idP;
		this.idL = idL;
		this.obs = obs;
	}
	public LogradourosPessoas(int id, int idP, int idL, String obs) {
		super();
		this.id = id;
		this.idP = idP;
		this.idL = idL;
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
	public int getIdL() {
		return idL;
	}
	public void setIdL(int idL) {
		this.idL = idL;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Logradouro getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "LogradourosPessoas [id=" + id + ", idP=" + idP + ", idL=" + idL + "\n pessoa=" + pessoa + "\n logradouro="
				+ logradouro + "obs="+ obs + "]";
	}
}
