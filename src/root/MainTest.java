package root;

import java.io.IOException;
import java.util.List;

public class MainTest {

	public static void main(String[] args) throws IOException {
		// String url = "src/rootTest/input.txt";
		DriverTrip dt = new DriverTrip();
		System.out.println(args[0]);
		List<String> inputList = dt.readFile(args[0]);
		dt.splitLines(inputList);
		dt.outputRes();
	}

}
