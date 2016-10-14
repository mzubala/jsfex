package pl.bottega.jsfex.user.model;

public class Role {

	private Long id;

	private String name;

	public Role(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role() {
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
