package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "departament")
public class Departament {
	
	@Id
	private lond id;
	private String name;
	
	
	@Override
	public String toString() {
		return "Departament [name=" + name + "]";
	}

}
