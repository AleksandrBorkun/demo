package epam.homework.task13;
import static java.lang.System.out;

public class chekThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProgrammerBook p = new ProgrammerBook("Prog Book", "Savin", "RUS", 1, 150, 2);
		ProgrammerBook p2 = new ProgrammerBook("Java", "G.Shild", "ENG", 2, 2500, 8);
		
		
		out.println(p.equals(p2));
		out.println(p.hashCode());
		out.println(p2.hashCode());
		out.println(p.toString());
		out.print(p2.toString());
		
		
		
	}

}
