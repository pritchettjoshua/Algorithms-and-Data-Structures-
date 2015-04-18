public class Hashmap {
	private final static int TABLE_SIZE = 20000;
	static HashElement HashElement = new HashElement();
	HashEntry[] table = new HashEntry[TABLE_SIZE];
	HashEntry none = new HashEntry(0, "");

	Hashmap() {
		this(TABLE_SIZE, null);
	}

	public int getSize() {
		return TABLE_SIZE;
	}

	public HashElement getElement() {
		return HashElement;
	}

	public void setElement(HashElement newElement) {
		HashElement = newElement;
	}

	public Hashmap(int newSize) {
		this(newSize, null);
	}

	public Hashmap(int newSize, HashElement NewElement) {
		if (newSize < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + newSize);
		if (newSize == 0)
			newSize = 1;
		table = new HashEntry[newSize];
		HashElement = NewElement;
	}

	public String get(int key) {
		int Hkey;
		Hkey = key % this.getSize();
		while (table[Hkey].isEmpty() || table[Hkey].getKey() != key) {
			Hkey = 3 * Hkey + 1;
		}
		return table[Hkey].getValue();
	}

	public void put(int key, String value) {
		int Hkey;
		Hkey = key % this.getSize();
		while (table[Hkey] != null) {
			Hkey = 3 * Hkey + 1 % this.getSize();
		}
		table[Hkey] = new HashEntry(key, value);
	}
	public void quadraticPut(long key, String value) {
		if (!this.isFull()) {
			int Hkey;
			int i = 0;
			Hkey = (int) (key % TABLE_SIZE);
			int newHkey = Hkey;
			while (table[newHkey] != null) {
				newHkey = ((Hkey + i * i) % TABLE_SIZE);
				i++;
				if (i > TABLE_SIZE)
					break;
			}
			table[newHkey] = new HashEntry(key, value);
		} else
			System.out.println("ERROR: hash table is full.");
	}

	public String quadraticGet(long key) {
		int Hkey;
		Hkey = (int) (key % TABLE_SIZE);
		int newHkey;
		newHkey = Hkey;
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[newHkey].isEmpty() || table[newHkey].getKey() != key) {
				newHkey = (Hkey + i * i) % TABLE_SIZE;
			}
		}
		if (table[newHkey].getKey() == key)
			return table[newHkey].getValue();
		else
			return "ERROR: key and value is not found. ";
	}
	public void linearPut(long key, String value) {
		if (!this.isFull()) {
			int Hkey;
			int i = 0;
			Hkey = (int) (key % this.getSize());
			int newHkey = Hkey;
			while (table[newHkey] != null) {
				newHkey = (Hkey + i) % TABLE_SIZE;
				i++;
			}
			table[newHkey] = new HashEntry(key, value);
		} else
			System.out.println("ERROR: hash table is full.");
	}

	public String linearGet(long key) {
		int Hkey;
		Hkey = (int) (key % this.getSize());
		int newHkey = Hkey;
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[newHkey].isEmpty() || table[newHkey].getKey() != key) {
				newHkey = (Hkey + i) % TABLE_SIZE;
			}
		}
		if (table[newHkey].getKey() == key)
			return table[newHkey].getValue();
		else
			return "ERROR: key and value is not found. ";
	}

	

	public void print() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[i] == null) {
				System.out.println((i + 1) + ": ");
			} else
				System.out.println((i + 1) + ": " + table[i].getKey() + " , "
						+ table[i].getValue());
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[i] == null) {
				result += (i + 1) + ": " + " \n";
			} else
				result += (i + 1) + ": " + table[i].getKey() + " , "
						+ table[i].getValue() + " \n";
		}
		return result;
	}

	public boolean isFull() {
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
				return false;
			}
		}
		return true;
	}
}