package model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer id;
	
	List<Seller> list;
	
	public Department() {
	}
	
	public Department(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", id=" + id + "]";
	}

}
