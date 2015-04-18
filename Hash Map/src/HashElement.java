public class HashElement {
	private long key;
	private String value;

	public HashElement(long thisKey, String thisValue) {
		key = thisKey;
		value = thisValue;
	}

	public HashElement() {
		this(0, null);
	}

	public long getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void setKey(long newKey) {
		key = newKey;
	}

	public void setValue(String newValue) {
		value = newValue;
	}
}
