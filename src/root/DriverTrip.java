package root;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DriverTrip {

	Map<String, Trip> map = new HashMap<>();

	// split Driver
	public void splitDriver(String[] strs) {
		if (strs != null && strs.length > 0) {
			if (strs[0].equals("Driver") && !map.containsKey(strs[0])) {
				if (strs.length < 2) {
					throw new ArrayIndexOutOfBoundsException("It must contains two sets of data.");
				}
				Trip t = new Trip();
				t.setDriverName(strs[1]);
				map.put(strs[1], t);
			}
		}
	}

	// split Trip
	public void splitTrip(String[] strs) {
		if (strs != null && strs.length > 0) {
			if (strs[0].equals("Trip")) {
				if (strs.length < 5) {
					throw new ArrayIndexOutOfBoundsException("It must contains four sets of data.");
				}
				if (map.containsKey(strs[1])) {
					Trip trip = map.get(strs[1]);
					int min = dateDiff(strs[2], strs[3]); // get minutes
					double miles = Double.valueOf(strs[4]);
					Double mph;
					try {
						mph = miles * 60 / min;
					} catch (NumberFormatException e) {
						throw new NumberFormatException("The MPH must be numbers.");
					}
					if (mph > 5 && mph < 100) { // Discard any trips that average a speed of less than 5 mph or greater
												// than 100 mph.
						trip.setDriverMin(trip.getDriverMin() + min);
						trip.setDriverMiles(trip.getDriverMiles() + miles);
					}
				}
			}
		}
	}

	// Calculate the number of minutes between two times
	public static int dateDiff(String startTime, String endTime) {
		try {
			SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");
			long from = simpleFormat.parse(startTime).getTime();
			long to = simpleFormat.parse(endTime).getTime();
			int minutes = (int) ((to - from) / (1000 * 60));
			return minutes;
		} catch (ParseException e) {
			
		}
		return 0;
	}

	// Sort the output by most miles driven to least.
	public List<Trip> sortDriverTrip() {
		List<Entry<String, Trip>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Trip>>() {
			public int compare(Map.Entry<String, Trip> o1, Map.Entry<String, Trip> o2) {
				return (int) (o2.getValue().getDriverMiles() - o1.getValue().getDriverMiles());
			}
		});

		List<Trip> res = new ArrayList<>();
		for (Entry<String, Trip> t : list) {
			res.add(t.getValue());
		}
		return res;
	}

	// read File
	public List<String> readFile(String url) throws IOException {
		List<String> inputList = new ArrayList<>();
		File file = new File(url);
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String lineStr = null;
		while ((lineStr = br.readLine()) != null) {
			inputList.add(lineStr);
		}
		br.close();
		return inputList;
	}

	// Handling every row data
	public void splitLines(List<String> inputList) {
		for (int i = 0; i < inputList.size(); i++) {
			String[] strs = inputList.get(i).split(" ");
			splitDriver(strs);
			splitTrip(strs);
		}
	}

	// output method
	public void outputRes() {
		PrintWriter wr = new PrintWriter(System.out);
		List<Trip> list = sortDriverTrip();
		for (Trip t : list) {
			wr.println(t);
		}
		wr.println();
		wr.close();
	}
}
