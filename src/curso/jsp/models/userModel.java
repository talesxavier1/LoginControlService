package curso.jsp.models;

public class UserModel {
	private long id;
	private String email;
	private String password;
	private String nome;
	private String telefone;
	
	public UserModel() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	
	public void mostrar() {
		System.out.println("id:" + id) ;
		System.out.println("nome:" + nome) ;
		System.out.println("email: " + email) ;
		System.out.println("pass: " + password) ;
		System.out.println("------------------------------------");
	}


	
}
