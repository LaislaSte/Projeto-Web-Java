package backenddm20231n.model.bean;

/*
create table fateczsdmn20222.pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  cpf VARCHAR(255),
  tipo VARCHAR(255),
  email VARCHAR(255),
  primary key (id));
*/

/**
 *
 * @author User
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private String cpf;
    private String tipo;
    private String email;

    public Pessoa(int id) {
        this.id = id;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf, String tipo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
        this.email = email;
    }

    public Pessoa(int id, String nome, String cpf, String tipo, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", tipo=" + tipo + ", email=" + email + "]";
	}
}
