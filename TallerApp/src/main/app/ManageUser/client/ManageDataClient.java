package main.app.ManageUser.client;

import java.util.Scanner;

import domain.entities.Client;

public class ManageDataClient {
	
	public ManageDataClient() {}
	
	public static Client giveDataClient()
	{
		System.out.println("Enter client data:");
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce DNI/NIF: ");
		String dni = scanner.nextLine();
		System.out.print("Introduce you name: ");
		String name = scanner.nextLine();
		System.out.print("Introduce you last name: ");
		String lastName = scanner.nextLine();
		System.out.print("Introduce you email:");
		String email = scanner.nextLine();
		System.out.println("Your email is " + email);
		
		Client newClient = new Client(dni, name, lastName, email);
		
		return newClient;
	}

}
