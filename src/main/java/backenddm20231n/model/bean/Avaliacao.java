package backenddm20231n.model.bean;

public class Avaliacao {

	private int id;
	private int idP;
	private int idL;
	private Pessoa pessoa;
	private Livro livro;
	private String descricao;
	private int nota;

	public Avaliacao(int id) {
		super();
		this.id = id;
	}

	public Avaliacao(int id, int idP, int idL) {
		super();
		this.id = id;
		this.idP = idP;
		this.idL = idL;
	}

	public Avaliacao(String descricao) {
		super();
		this.descricao = descricao;
	}

	public Avaliacao(int idP, int idL, String descricao, int nota) {
		super();
		this.idP = idP;
		this.idL = idL;
		this.descricao = descricao;
		this.nota = nota;
	}

	public Avaliacao(int id, String descricao, int nota) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nota = nota;
	}

	public Avaliacao(int id, int idP, int idL, String descricao, int nota) {
		super();
		this.id = id;
		this.idP = idP;
		this.idL = idL;
		this.descricao = descricao;
		this.nota = nota;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricap) {
		this.descricao = descricap;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", idP=" + idP + ", idL=" + idL + "\n pessoa=" + pessoa + "\n livro=" + livro
				+ "\n descricao=" + descricao + ", nota=" + nota + "]";
	}
}