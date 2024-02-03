package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer() {
	}
	
	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		if (salaryIncome/12 >= 5000) {
			return salaryIncome * 0.2;
		} else if (salaryIncome/12 >= 3000 && salaryIncome/12 < 5000) {
			return salaryIncome * 0.1;
		} else {
			return 0;
		}
	}
	
	public double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double spendingRebate = healthSpending + educationSpending;
		double maxSpending = grossTax() * 0.3;
		if (maxSpending > spendingRebate) {
			return spendingRebate;
		} else {
			return maxSpending;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return "\nImposto bruto total: " 
				+ String.format("%.2f", grossTax())
				+ "\nAbatimento " 
				+ String.format("%.2f", taxRebate())
				+ "\nImposto devido: " 
				+ String.format("%.2f", netTax());
	}
	
}