package root;

public class Trip {

	private String driverName;
	private int driverMin;
	private double driverMiles;
	private int driverMPH;

	public Trip() {

	}

	public Trip(String driverName, double driverMiles, int driverMPH) {
		this.driverName = driverName;
		this.driverMiles = driverMiles;
		this.driverMPH = driverMPH;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public double getDriverMiles() {
		return driverMiles;
	}

	public void setDriverMiles(double driverMiles) {
		this.driverMiles = driverMiles;
		setDriverMPH(calculateMPH());
	}

	public int getDriverMPH() {
		return driverMPH;
	}

	public void setDriverMPH(int driverMPH) {
		this.driverMPH = driverMPH;
	}

	public int getDriverMin() {
		return driverMin;
	}

	public void setDriverMin(int driverMin) {
		this.driverMin = driverMin;
	}

	public int calculateMPH() {
		return (int) Math.round(this.driverMiles * 60 / this.driverMin);
	}

	@Override
	public String toString() {
		String str = "";
		if (driverMPH != 0) {
			str = " @ " + driverMPH + " mph";
		}
		return "" + driverName + ": " + (int) Math.round(driverMiles) + " miles" + str;
	}

}