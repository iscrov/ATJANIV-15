package ua.org.oa.grishin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author iscrov
 * 
 */

public class Saloon {
	private static ArrayList<Auto> cars = new ArrayList<Auto>();

	public static void main(String[] args) {
		System.out.println("Добро пожаловать в программу учета автомобилей!");
		consoleOutput();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			switch (input.next()) {
			case "1":
				createAuto();
				consoleOutput();
				break;
			case "2":
				System.out.println("Vvedite kolichestvo vvodimuh mashin: ");
				int n;
				try {
					n = input.nextInt();
				} catch (Exception e) {
					System.out
							.println("Vu vveli nekorrektno dannue. Povtorite vvod.");
					return;
				}
				createAuto(n);
				consoleOutput();
				break;
			case "3":
				System.out.println("Srednij probeg mashin salona raven ---> "
						+ getMean());
				consoleOutput();
				break;
			case "4":
				viewCars(4, 0);
				consoleOutput();
				break;
			case "5":
				System.out
						.println("----- Otobragenie mashun kotorue >= ukazannogo znacheniya ------");
				System.out.println("Vvedite neobhodimoe znacheniye probega: ");
				viewCars(5, input.nextInt());
				consoleOutput();
				break;
			case "6":
				viewCars(6, 0);
				consoleOutput();
				break;
			case "7":
				System.out
						.println("----- Otobragenie mashun kotorue <= ukazannogo znacheniya ------");
				System.out.println("Vvedite neobhodimoe znacheniye probega: ");
				viewCars(7, input.nextInt());
				consoleOutput();
				break;
			case "m":
				consoleOutput();
			case "q":
				System.out.println("Programma budet zavershena.........");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	public static void createAuto() {
		Auto auto = new Auto();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Vvedite pogalujsta proizvoditela: ");
		auto.setProizvoditel(input.next());
		System.out.println("Vvedite pogalujsta marku: ");
		auto.setMarka(input.next());
		System.out.println("Vvedite pogalujsta god vupuska: ");
		try {
			auto.setGodVupuska(input.nextInt());
		} catch (Exception e) {
			System.out
					.println("Osuschectvlen nekorrektnyj vvod. Povtorite vvod");
			return;
		}
		System.out.println("Vvedite pogalujsta probeg: ");
		try {
			auto.setProbeg(input.nextInt());
		} catch (Exception e) {
			System.out
					.println("Osuschectvlen nekorrektnyj vvod. Povtorite vvod");
			return;
		}
		System.out
				.println("Ozenite pogalujsta sostojanie machinu (1 - плохое, 2 - допустимое, 3 -не плохое‚ 4 - хорошее, 5 - новый автомобиль ");
		try {
			auto.setSostoyanie(input.nextInt());
		} catch (Exception e) {
			System.out
					.println("Osuschectvlen nekorrektnyj vvod. Povtorite vvod");
			return;
		}
		cars.add(auto);
		System.out.println("@ -------> Auto yspeshno dobavleno.");
	}

	public static void createAuto(int n) {

		for (int i = 0; i < n; i++) {
			createAuto();
		}
	}

	private static void consoleOutput() {
		String str2 = "file.txt";
		Scanner scanner = new Scanner(Saloon.class.getResourceAsStream(str2));

		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}

	public static double getMean() {
		int sum = 0;
		for (int i = 0; i < getCars().size(); i++) {
			if (getCars().get(i).getProbeg() != 0) {

			}
			sum += getCars().get(i).getProbeg();

		}
		return sum / getCars().size();
	}

	public static ArrayList<Auto> getCars() {
		return cars;
	}

	public static void setCars(ArrayList<Auto> cars) {
		Saloon.cars = cars;
	}

	public static void viewCars(int n, int z) {
		double d;
		switch (n) {
		case 4:
			d = getMean();
			for (int i = 0; i < getCars().size(); i++) {
				if ((double) getCars().get(i).getProbeg() >= d) {
					System.out.println(getCars().get(i).toString());
				} else {
					System.out.println("Net mashun po zadannum kriteriyam.");
				}
			}
			break;
		case 5:
			for (int i = 0; i < getCars().size(); i++) {
				if ((double) getCars().get(i).getProbeg() >= z) {
					System.out.println(getCars().get(i).toString());
				} else {
					System.out.println("Net mashun po zadannum kriteriyam.");
				}
			}
			break;
		case 6:
			d = getMean();
			for (int i = 0; i < getCars().size(); i++) {
				if ((double) getCars().get(i).getProbeg() <= d) {
					System.out.println(getCars().get(i).toString());
				} else {
					System.out.println("Net mashun po zadannum kriteriyam.");
				}
			}
			break;
		case 7:
			for (int i = 0; i < getCars().size(); i++) {
				if ((double) getCars().get(i).getProbeg() <= z) {
					System.out.println(getCars().get(i).toString());
				} else {
					System.out.println("Net mashun po zadannum kriteriyam.");
				}
			}
			break;
		default:
			break;
		}
	}
}
