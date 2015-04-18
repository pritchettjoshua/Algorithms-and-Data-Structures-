public class Stopwatch {

	private final long start;

	public Stopwatch() {
		start = System.currentTimeMillis();
	}

	// return time (in seconds) since this object was created
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start);
	}

}