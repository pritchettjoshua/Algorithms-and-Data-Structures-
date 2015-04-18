public class Stopwatch {

	private final long start;

	public Stopwatch() {
		start = System.nanoTime();
	}

	// return time (in seconds) since this object was created
	public double elapsedTime() {
		long now = System.nanoTime();
		return (now - start);
	}

}