package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import root.DriverTrip;
import root.Trip;

public class TripTestNeg {

	DriverTrip dt = null;
	List<Trip> resList = null;

	String url = "src/test/input_neg.txt";

	@Before
	public void setUp() throws Exception {
		dt = new DriverTrip();
		List<String> inputList = dt.readFile(url);
		dt.splitLines(inputList);
		resList = dt.sortDriverTrip();
	}

	// test bob without trip
	@Test
	public void testBobNoTrip() {
		Trip trip = resList.get(2);
		String expStr = "Bob: 0 miles";
		assertEquals(expStr, trip.toString());
	}

	// test Alex start time > end time
	@Test
	public void testAlexTimeOutOfRange() {
		Trip trip = resList.get(1);
		String expStr = "Alex: 0 miles";
		assertEquals(expStr, trip.toString());
	}

	// test Kim miles < 5
	@Test
	public void testKimMiles5() {
		Trip trip = resList.get(3);
		String expStr = "Kim: 0 miles";
		assertEquals(expStr, trip.toString());
	}

	// test Dan miles > 100
	@Test
	public void testDanMiles100() {
		Trip trip = resList.get(0);
		String expStr = "Dan: 17 miles @ 35 mph";
		assertEquals(expStr, trip.toString());
	}

}
