package Question4;


public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedSequentialSearchST<String, Double> GPAs = new OrderedSequentialSearchST<>();
		GPAs.put("A+", 4.33);
		GPAs.put("A", 4.00);
		GPAs.put("A-", 3.67);
		GPAs.put("B+", 3.33);
		GPAs.put("B", 3.00);
		GPAs.put("B-", 2.67);
		GPAs.put("C+", 2.33);
		GPAs.put("C", 2.00);
		GPAs.put("C-", 1.67);
		GPAs.put("D", 1.00);
		GPAs.put("F", 0.00);
        
        String[] letterGrades = {"A+", "B", "C-"};
        int count = letterGrades.length;
        
        double totalNumericalGPA = 0;

        for (String letterGrade : letterGrades) {
        	double gpa = GPAs.get(letterGrade);
        	System.out.println("Grade: " + letterGrade + "; From Table: " + GPAs.get(letterGrade));
            totalNumericalGPA += gpa;
        }

        System.out.println("Your grade is: " + (totalNumericalGPA / count));
	}

}
