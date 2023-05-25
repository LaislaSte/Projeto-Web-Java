package backenddm20231n.model.bean;

public class Pedido {
	private int id;
	private int idP;
	private int idL;
	private Pessoa pessoa;
	private Livro livro;
	private int quantidade;
	private String obs;

	public Pedido(int id) {
		super();
		this.id = id;
	}

	public Pedido(int id, int idP, int idL) {
		super();
		this.id = id;
		this.idP = idP;
		this.idL = idL;
	}

	public Pedido(int idP, int idL, int quantidade, String obs) {
		super();
		this.idP = idP;
		this.idL = idL;
		this.quantidade = quantidade;
		this.obs = obs;
	}

	public Pedido(String obs) {
		super();
		this.obs = obs;
	}

	public Pedido(int id, int idP, int idL, int quantidade, String obs) {
		super();
		this.id = id;
		this.idP = idP;
		this.idL = idL;
		this.quantidade = quantidade;
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

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idP=" + idP + ", idL=" + idL + "\n pessoa=" + pessoa + "\n livro=" + livro
				+ "\n quantidade=" + quantidade + ", obs=" + obs + "]";
	}

	public double calcularTotalPedido() {
		return livro.getValor() * quantidade;
	}

}
