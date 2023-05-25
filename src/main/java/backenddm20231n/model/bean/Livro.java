package backenddm20231n.model.bean;


public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private double valor;
	
	public Livro(int id) {
		this.id = id;
	}
	
	public Livro(String autor) {
		super();
		this.autor = autor;
	}

	public Livro(int id, double valor) {
		super();
		this.id = id;
		this.valor = valor;
	}

	public Livro(String titulo, String autor, String genero, String editora, double valor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.valor = valor;
	}

	public Livro(int id, String titulo, String autor, String genero, String editora, double valor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.editora= editora;
		this.valor = valor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", editora="
				+ editora + ", valor=" + valor + "]";
	}
	
}