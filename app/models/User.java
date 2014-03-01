package models;

public class User {
	private int id;
	private String handle;
	private String address;
	
	public User(int id, String handle, String address) {
		super();
		this.id = id;
		this.handle = handle;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
