package dev.soer.fixtures;

public class Room extends Fixture {

	Room[] exits = new Room[4]; // 0 - North, 1 - East, 2 - South, 3 - West
	
	// constructor
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		int index = -1;
		direction = direction.toUpperCase();
		switch (direction) {
		case "NORTH":
			index = 0;
			break;
		case "EAST":
			index = 1;
			break;
		case "SOUTH":
			index = 2;
			break;
		case "WEST":
			index = 3;
			break;	
		default: 
			System.out.println("Enter a direction...");
			return null;
		}
		
		// If statement checks if there is actually a room in certain direction
		if (index >= this.exits.length || this.exits[index] == null) {
			System.out.println("There is no room in that direction");
			
			// Return the current room is there is not a room in that direction
			return null;
		}
		
		return this.exits[index];
	}

	// setter for exits
	public void setExits(Room[] exits) {
		this.exits = exits;
	}

	// Overloaded setter method. Allows us to set single exit based on index...
	public void setExits(Room exit, int index) {
		this.exits[index] = exit;
	}	
	
}
