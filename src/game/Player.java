package game;

import fixtures.Room;

public class Player {
	
	private Room room;
	private String name;
	
	// constructor
	public Player(String aName, Room aRoom) {
		this.name = aName;
		this.room = aRoom;
	}
	
	// getters and setters
	public Room getRoom() {
		return this.room;
	}
	
	public void setRoom(Room aRoom) {
		this.room = aRoom;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
