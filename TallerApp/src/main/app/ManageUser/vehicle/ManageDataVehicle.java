package main.app.ManageUser.vehicle;

import java.util.Scanner;

public class ManageDataVehicle {

	public ManageDataVehicle() {
	}

	public static String giveDataVehicle() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce license plate: ");
		String licensePlate = scanner.nextLine();

		return licensePlate;

	}
}
