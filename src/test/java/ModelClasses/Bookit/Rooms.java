package ModelClasses.Bookit;

import java.util.List;

public class Rooms {
	int id;
	String name;
	String description;
	int capacity;
	boolean withTV;
	boolean withWhiteBoard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isWithTV() {
		return withTV;
	}
	public void setWithTV(boolean withTV) {
		this.withTV = withTV;
	}
	public boolean isWithWhiteBoard() {
		return withWhiteBoard;
	}
	public void setWithWhiteBoard(boolean withWhiteBoard) {
		this.withWhiteBoard = withWhiteBoard;
	}

}
