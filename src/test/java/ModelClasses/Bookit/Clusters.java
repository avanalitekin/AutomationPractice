package ModelClasses.Bookit;

import java.util.List;

public class Clusters {
	
	int id;
	String name;
	List<Rooms> rooms;
	List<Clusters> clusters;
	Rooms room;
	
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
	public List<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}
	public List<Clusters> getClusters() {
		return clusters;
	}
	public void setClusters(List<Clusters> clusters) {
		this.clusters = clusters;
	}
	public Rooms getRoom() {
		return room;
	}
	public void setRoom(Rooms room) {
		this.room = room;
	}
}
