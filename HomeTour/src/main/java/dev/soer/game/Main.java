package dev.soer.game;

import java.util.Scanner;

import dev.soer.fixtures.Room;

public class Main { 
	
	static boolean running = true;
	
	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.lineSeparator());
		
		rm.init();
		Player p = new Player(rm.startingRoom);
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
			Room move = player.getCurrentRoom().getExit(direction);
			player.setCurrentRoom(move);
		}
		else if(action.equals("quit")) {
			running = false;
		}
	}
}

