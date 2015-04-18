public class Type {

	private long number;
	private String size;
	private String name;

	public Type(long thisNumber, String thisSize, String thisName) {
		number = thisNumber;
		size = thisSize;
		name = thisName;
	}

	public Type() {
		this(0, null, null);
	}

	public long getNumber() {
		return number;
	}

	public String getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public void setNumber(long newNumber) {
		number = newNumber;
	}

	public void setSize(String newSize) {
		size = newSize;
	}

	public void setName(String newName) {
		name = newName;
	}
}