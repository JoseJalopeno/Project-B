package dev.soer.game;

import java.util.Scanner;

import dev.soer.fixtures.Room;

public class Main { 
	
	static boolean running = true;
	static RoomManager rm = new RoomManager();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.lineSeparator());
		
		rm.init();
		Player p = new Player(rm.startingRoom);
		instructions();
		while(running) {
			printRoom(p);
			String input = sc.next();
			String[] command = input.split(" ");
			parse(command, p);
		}
		if (!running) {
			System.out.println("Thanks for playing");
		}
		sc.close();
	}

	private static void printRoom(Player player) {
		System.out.println("Name: " + player.getCurrentRoom().getName());
		System.out.println("\nDescription: " + player.getCurrentRoom().getLongDescription());
		System.out.println();
		if(player.getCurrentRoom().getExit("North") != null) {
			System.out.println("North: " + player.getCurrentRoom().getExit("North").getName());
		}
		if(player.getCurrentRoom().getExit("East") != null) {
			System.out.println("East: " + player.getCurrentRoom().getExit("East").getName());
		}
		if(player.getCurrentRoom().getExit("South") != null) {
			System.out.println("South: " + player.getCurrentRoom().getExit("South").getName());
		}
		if(player.getCurrentRoom().getExit("West") != null) {
			System.out.println("West: " + player.getCurrentRoom().getExit("West").getName());
		}
	}
	
	private static void parse(String[] command, Player player) {
		String action = command[0].toLowerCase();
		String direction = null;
		if (command.length > 1) {
			direction = command[1].toLowerCase();
		}
		if(action.equals("go")) {
			if(player.getCurrentRoom().getExit(direction) != null) {
				Room move = player.getCurrentRoom().getExit(direction);
				if(!move.getName().equals("Secret")) {
					player.setCurrentRoom(move);
				}
				else if(player.hasKey && move.getName().equals("Secret")) {
					player.setCurrentRoom(move);
				}
				else {
					System.out.println("Looks like you need a key\n");
				}
			}
			else {
				System.out.println("There is no exit in that direction\n");
			}
		}
		else if(action.equals("look")) {
			if(player.getCurrentRoom().hasKey()) {
				System.out.println("There is a key here\n");
			}
			else {
				System.out.println("There is nothing in the room\n");
			}
			
		}
		else if(action.equals("grab") && player.getCurrentRoom().getName().equals("Bathroom")) {
			player.hasKey = true;
			System.out.println("You grab the key. Wonder what is inside the secret room\n");
		}
		else if(action.equals("instructions")) {
			instructions();
		}
		else if(action.equals("map")) {
			map(player);
		}
		else if(action.equals("quit")) {
			running = false;
		}
	}
	
	private static void instructions() {
		System.out.println(":::::INSTRUCTIONS:::::");
		System.out.println("To move around type: go + any direction");
		System.out.println("To quit game type: quit");
		System.out.println("To see a map type: map");
		System.out.println("To look around a room type: look");
		System.out.println("To grab object type: grab");
		System.out.println("Grab only works if room has an object");
		System.out.println("To see instructions again type: instructions");
		System.out.println("::::::::::::::::::::::");
	}
	
	private static void map(Player p) {
		if(p.hasKey) { // prints the map with the secret room as open
			System.out.println("********************South*******************");
			System.out.println("--------------------------------------------");
			System.out.println("|                     |                    |");
			System.out.println("|    Living Room      |      Bedroom       |");
			System.out.println("|                     |                    |");
			System.out.println("|                     |  ------------------|");
			System.out.println("|                               |          |");
			System.out.println("|-   -----------------|         | Bathroom |");
			System.out.println("|           |         | Hallway            |");
			System.out.println("| Entry Way      ?    |         |          |");
			System.out.println("|           |         |         |          |");
			System.out.println("|-   -----------------|   -----------------|");
			System.out.println("|                     |                    |");
			System.out.println("|                     |                    |");
			System.out.println("|      Dining Room    |       Kitchen      |");
			System.out.println("|                                          |");
			System.out.println("|                     |                    |");
			System.out.println("--------------------------------------------");
			System.out.println("********************North*******************");
		}
		else { // prints the map with the secret room closed
			System.out.println("********************South*******************");
			System.out.println("--------------------------------------------");
			System.out.println("|                     |                    |");
			System.out.println("|    Living Room      |      Bedroom       |");
			System.out.println("|                     |                    |");
			System.out.println("|                     |  ------------------|");
			System.out.println("|                               |          |");
			System.out.println("|-   -----------------|         | Bathroom |");
			System.out.println("|           |         | Hallway            |");
			System.out.println("| Entry Way |         |         |          |");
			System.out.println("|           |         |         |          |");
			System.out.println("|-   -----------------|   -----------------|");
			System.out.println("|                     |                    |");
			System.out.println("|                     |                    |");
			System.out.println("|      Dining Room    |       Kitchen      |");
			System.out.println("|                                          |");
			System.out.println("|                     |                    |");
			System.out.println("--------------------------------------------");
			System.out.println("********************North*******************");
		}			
	}
	
}
