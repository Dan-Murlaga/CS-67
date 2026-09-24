public class Student extends Person{
	private double gpa;
	
	public Student(String n, int a, double g)
	{
		super(n, a);
		gpa = g;
	}
	
	public void setGPA(double g)
	{
		gpa = g;
	}
	
	public double getGPA()
	{
		return gpa;
	}
	
	public void study()
	{
		gpa += 0.01;
	}
	
	public String toString()
	{
		String returnString = "";
		returnString += "Student: " + "\n";
		returnString += " name: " + name + "\n";
		returnString += " age: " + age + "\n";
		returnString += " gpa: " + gpa + "\n";
		return returnString;
	}
}
