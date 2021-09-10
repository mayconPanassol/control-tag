package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int quantityProducts = sc.nextInt();

		List<Product> list = new ArrayList<>();

		for (int i = 1; i <= quantityProducts; i++) {

			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Customs fee: ");
				Double customsFree = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFree);
				list.add(product);
			} else {
				if (type == 'u') {
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date date = Product.sdf.parse(sc.next());
					Product product = new UsedProduct(name, price, date);
					list.add(product);
				} else {

					Product product = new Product(name, price);
					list.add(product);
				}
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");

		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	
	}
}
