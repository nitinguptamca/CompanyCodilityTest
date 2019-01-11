package company.creditsuisse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Each line contains an employee name, a salary (in Rs. thousands per month),
 * the name of the company, and the name of the manager of that employee - all
 * separated by commas. You may assume that employee name, company name, and
 * manager name do not contain any commas, and that salary is an integer. The
 * special manager name NOBODY indicates that this employee does not have a
 * manager (and is hence the CEO of the company). You can assume that there is
 * only one CEO in each company.
 * 
 * Currently, the existing program reads the input and creates an
 * ArrayList<String> from the lines of input. Then it calls a method processData
 * on this ArrayList, and prints the returned data to the output file.
 * Unfortunately, processData currently does not do anything useful - it just
 * returns an empty `Map.
 * 
 * You have to modify processData to compute the minimum salary of any employee
 * in each company. Thus, processData will return a Map that maps each company
 * name to the minimum salary in that company. In other words, the map will
 * contain each company name as a key, and the minimum salary in that company as
 * the value for that entry.
 */
class Company {
	String employeeName;
	int salary;
	String companyName;
	String managerName;

	public Company(String employeeName, int salary, String companyName, String managerName) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.companyName = companyName;
		this.managerName = managerName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getManagerName() {
		return managerName;
	}

	@Override
	public String toString() {
		return "Company [employeeName=" + employeeName + ", salary=" + salary + ", companyName=" + companyName
				+ ", managerName=" + managerName + "]";
	}

}

public class ProcessingData {
	// java7 solution1
	public static List<Company> listOfLine = new ArrayList<Company>();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\workspace\\CompanyCodilityTest\\src\\company\\creditsuisse\\input.txt"));
		String line = br.readLine();

		while (line != null) {
			String[] arras = line.split("\\,");
			/// System.out.println(line);
			listOfLine.add(new Company(arras[0], Integer.parseInt(arras[1].trim()), arras[2], arras[3]));
			line = br.readLine();
		}
		br.close();
		listOfLine.forEach(System.out::println);
		System.out.println("******************************************");
		Map<String, Integer> process = listOfLine.stream()
				.collect(Collectors.toMap(Company::getEmployeeName, Company::getSalary));
		// Employee name with salary
		process.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println("************************");
		// processData to compute the minimum salary of any employee in each company.
		Comparator<Company> comparator = Comparator.comparing(Company::getSalary);
		Optional<Company> process2 = listOfLine.stream()
				.collect(Collectors.minBy(Comparator.comparing(Company::getSalary)));
		/*listOfLine.stream().collect(Collectors.toMap(Company::getCompanyName,
				BinaryOperator.maxBy(Comparator.comparing(Company::getSalary))));

		System.out.println("************************" + process2);
*/
	}

	/*
	 * public static void main(String[] args) throws IOException { Path path =
	 * Paths.get(
	 * "D:\\workspace\\CompanyCodilityTest\\src\\company\\creditsuisse\\input.txt");
	 * Stream<String> companydetail= Files.lines(path).flatMap(line ->
	 * Arrays.stream(line.trim().split(",")));
	 * 
	 * }
	 */

}
