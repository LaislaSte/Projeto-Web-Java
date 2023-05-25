package backenddm20231n.model.bean;

public class CartoesPessoas {
	
	private int id;
	private int idP;
	private int idC;
	private Pessoa pessoa;
	private Cartao cartao;
	private String obs;
	
	public CartoesPessoas(String obs) {
		super();
		this.obs = obs;
	}
	public CartoesPessoas(int id) {
		super();
		this.id = id;
	}
	public CartoesPessoas(int idP, int idC, String obs) {
		super();
		this.idP = idP;
		this.idC = idC;
		this.obs = obs;
	}
	public CartoesPessoas(int id, int idP, int idC, String obs) {
		super();
		this.id = id;
		this.idP = idP;
		this.idC = idC;
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
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "CartoesPessoas [id=" + id + ", idP=" + idP + ", idC=" + idC + "\n pessoa=" + pessoa + "\n cartao="
				+ cartao + "obs="+ obs + "]";
	}
}
