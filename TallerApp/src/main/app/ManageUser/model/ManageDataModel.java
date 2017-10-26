package main.app.ManageUser.model;

import java.util.Scanner;

import domain.entities.Model;

public class ManageDataModel {

	public static boolean noEstaModel;

	public ManageDataModel() {}

	public static Model giveDataModelVehicle() {
		Scanner scanner = new Scanner(System.in);

		boolean esta = false;
		Model newModel = null;

		System.out.print("Introduce el c�digo del modelo (Megane: 11, Ibiza: 22, etc.): ");
		int codeModel = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Introduce el nombre commercial del vehiculo: ");
		String commertialName = scanner.nextLine();
		System.out.print("Introduce el a�o del vehiculo: ");
		int year = scanner.nextInt();

		newModel = new Model(codeModel, commertialName, year);

		return newModel;

	}
}
