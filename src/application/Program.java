package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int taxPayerAmount = sc.nextInt();
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		for (int i=0; i < taxPayerAmount; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte:", i+1);
			System.out.print("\nRenda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			
			System.out.print("Renda anual com prestação de serviço: ");
			double serviceIncome = sc.nextDouble();
			
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			
			System.out.print("Gastos médicos: ");
			double healthSpending  = sc.nextDouble();
			
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			
			taxPayers.add(new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending));
		}
				
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println();
			System.out.printf("Resumo do %do contribuinte:", taxPayers.indexOf(taxPayer)+1);
			System.out.println(taxPayer);
		}
		
		sc.close();
	}

}
