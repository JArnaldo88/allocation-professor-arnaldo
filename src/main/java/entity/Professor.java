package entity;

public class Professor {

	private long id;
	private String name;
	private String cpf;
	private long departamentid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getDepartamentid() {
		return departamentid;
	}

	public void setDepartamentid(long departamentid) {
		this.departamentid = departamentid;
	}

}
