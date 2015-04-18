

public class HashEntry {
	private long key;
	private String value;

	HashEntry(long key, String value) {
		this.key = key;
		this.value = value;
	}

	HashEntry() {
		this(0, "");
	}

	public void setKey(long newKey) {
		key = newKey;
	}

	public long getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String val) {
		this.value = val;
	}

	public boolean isEmpty() {
		if (value == "")
			return true;
		else
			return false;
	}
}