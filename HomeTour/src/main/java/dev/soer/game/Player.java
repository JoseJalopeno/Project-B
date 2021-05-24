package dev.soer.game;

import dev.soer.fixtures.Room;

public class Player {

	Room currentRoom;
	boolean hasKey;
	
	public Player(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setKey(boolean hasKey) {
		this.hasKey = hasKey;
	}

}
