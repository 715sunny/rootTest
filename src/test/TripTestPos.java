package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import root.DriverTrip;
import root.Trip;

public class TripTestPos {

	DriverTrip dt = null;
	List<Trip> resList = null;

	String url = "src/test/input_pos.txt";

	@Before
	public void setUp() throws Exception {
		dt = new DriverTrip();
		List<String> inputList = dt.readFile(url);
		dt.splitLines(inputList);
		resList = dt.sortDriverTrip();
	}

	// test Alex
	@Test
	public void testAlex() {
		Trip trip = resList.get(0);
		String expStr = "Alex: 42 miles @ 34 mph";
		assertEquals(expStr, trip.toString());
	}

	// test Dan with multiTrips
	@Test
	public void testDanWithMultiTrips() {
		Trip trip = resList.get(1);
		String expStr = "Dan: 39 miles @ 47 mph";
		assertEquals(expStr, trip.toString());
	}

	// test Bob with Mile 0
	@Test
	public void testBobWithMile0() {
		Trip trip = resList.get(2);
		String expStr = "Bob: 0 miles";
		assertEquals(expStr, trip.toString());
	}

	// Jim is not driver who has trip
	@Test
	public void testJimIsNotDriverHasTrip() {
		Trip trip = resList.get(1);
		String expStr = "Jim: 0 miles";
		assertNotEquals(expStr, trip.toString());
	}

	// Dan have two trip, get avg mph
	@Test
	public void testDanAvgMPH() {
		Trip trip = resList.get(1);
		int mph = trip.getDriverMPH();
		int expStr = 47;
		assertEquals(expStr, mph);
	}

	// test sort by miles
	@Test
	public void testSortByMiles() {
		List<Trip> list = new ArrayList<>();
		Trip t1 = new Trip("Alex", 42, 34);
		Trip t2 = new Trip("Dan", 39, 47);
		Trip t3 = new Trip("Bob", 0, 0);
		list.add(t1);
		list.add(t2);
		list.add(t3);
		assertEquals(list.toString(), resList.toString());
	}

}
