package main.app.ManageUser.brand;

import java.util.Scanner;
import java.util.Map.Entry;

import domain.entities.Brand;

public class ManageDataBrand {

	public static boolean noEstaBrand;

	public ManageDataBrand() {}

	public static Brand giveDataBrandVehicle() {
		Scanner scanner = new Scanner(System.in);

		boolean esta = false;
		Brand newBrand = null;

		System.out.print("Introduce el codigo de la marca (Renault: 1111, Seat:2222, etc.): ");
		int codeBrand = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Introduce el nombre de la marca: ");
		String nameCommertial = scanner.nextLine();
		System.out.println("Introduce el lugar: ");
		String place = scanner.nextLine();

		newBrand = new Brand(codeBrand, nameCommertial, place);

		return newBrand;

	}
}
