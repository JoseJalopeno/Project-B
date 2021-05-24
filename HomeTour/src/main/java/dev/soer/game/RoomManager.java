package dev.soer.game;

import dev.soer.fixtures.Room;

public class RoomManager {

	Room startingRoom;
	Room[] rooms;
	
	public RoomManager() {
		this.rooms = new Room[7];
	}
	/*
	 * 0 Entry way -> Living room and Dining room
	 * 1 Living room -> Small hallway and Entry way
	 * 2 Dining room -> Kitchen and Entry way
	 * 3 Kitchen -> dining room and small hallway
	 * 4 Small hallway -> small bedroom and bathroom and kitchen and living room
	 * 5 Small bedroom -> small hallway
	 * 6 Bathroom -> small hallway
	 */
	public void init() {
		Room entryWay = new Room(
				"The Entryway",
				"a small entryway",
				"A small entryway to a house. To the south there is the living room. "
				+ "The north is the dining room. ", false);
		this.rooms[0] = entryWay;
        this.startingRoom = entryWay;
        
        Room livingRoom = new Room(
			"Living Room", "the living room", 
			"The main room for the family in the house. To the north is the small entryway. \n"
			+ "To the west is a small hallway. ", false);
        this.rooms[1] = livingRoom;
        
        Room diningRoom = new Room(
			"Dining Room", "a small dining room", 
			"The dining room with a table set for five and a china cabinet. \n"
			+ "To the south there is a living room. To the west is the kitchen. ", false);
        this.rooms[2] = diningRoom;
        
        Room kitchen = new Room(
			"Kitchen", "a large kitchen",
			"A large kitchen. To the south there is a small hallway.\n"
			+ "To the east there is the diningroom. ", false);
        this.rooms[3] = kitchen;
	
        Room smallHallway = new Room("Small Hallway", "small connecting hallway",
        		"Kitchen to the north. A small bedroom to the south.\n "
        		+ "Bathroom to the west. Living room to the east. ", false);
        this.rooms[4] = smallHallway;
        
        Room smallBedroom = new Room("Small bedroom", "a small bedroom", 
        		"A small bedroom currently used as an office. To the north there is a small hallway. ", false);
        this.rooms[5] = smallBedroom;
        
        Room bathroom = new Room("Bathroom", "small bathroom",
        		"small bathroom with a washer and dryer. To the east is a small hallway. ", true);
        this.rooms[6] = bathroom;
        
        Room secretRoom = new Room("Secret", "Secret Room",
        		"Did you ever hear the tragedy of Darth Plagueis The Wise? I thought not. It’s not a story the Jedi would tell you.\n"
        		+ "It’s a Sith legend. Darth Plagueis was a Dark Lord of the Sith, so powerful and so wise he could use\n"
        		+ "the Force to influence the midichlorians to create life… He had such a knowledge of the dark side\n" 
        		+ "that he could even keep the ones he cared about from dying. The dark side of the Force is a pathway\n" 
        		+ "to many abilities some consider to be unnatural. He became so powerful… the only thing he was afraid\n"
        		+ "of was losing his power, which eventually, of course, he did. Unfortunately, he taught his apprentice\n" 
        		+ "everything he knew, then his apprentice killed him in his sleep. Ironic. He could save others from death, but not himself.", false);        		
        
        /*
         * North: 0
         * East: 1
         * South: 2
         * West: 3
         */
        Room[] entryExits = {diningRoom, null, livingRoom, secretRoom};
        entryWay.setExits(entryExits);
        
        Room[] livingExits = {entryWay, null, null, smallHallway};
        livingRoom.setExits(livingExits);
        
        Room[] diningExits = {null, null, entryWay, kitchen};
        diningRoom.setExits(diningExits);

        Room[] kitchenExits = {null, diningRoom, smallHallway, null};
        kitchen.setExits(kitchenExits);
        
        Room[] hallwayExits = {kitchen, livingRoom, smallBedroom, bathroom};
        smallHallway.setExits(hallwayExits);
        
        Room[] bedroomExits = {smallHallway, null, null, null};
        smallBedroom.setExits(bedroomExits);
        
        Room[] bathExits = {null, smallHallway, null, null};
        bathroom.setExits(bathExits); 
               
	}
	
}
