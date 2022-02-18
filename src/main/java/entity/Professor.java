package entity;

public class Professor {
	
	private long id;
	private String name;
	private String cpf;
	private long departamentid;
	
	
	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", departamentid=" + departamentid + "]";
	}

}
