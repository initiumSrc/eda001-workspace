package map;

import java.util.Arrays;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private int size;
	private int capacity;
	private float loadFactor;
	Entry<K,V>[] table;
	
	@SuppressWarnings("unchecked")
	public SimpleHashMap() {
		size = 0;
		capacity = 16;
		loadFactor = 0.75f;
		table = (Entry<K,V>[]) new Entry[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		size = 0;
		this.capacity = capacity;
		loadFactor = 0.75f;
		table = (Entry<K,V>[]) new Entry[this.capacity];
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> shm = new SimpleHashMap<Integer, Integer>();
//		
//		shm.put("Siffra", 1);
//		shm.put("Siffra", 10);
//		shm.put(213, 1232);
//		shm.put("Hej", 12312);
//		shm.put(1, 213);
//		shm.put(1, 123);
//		
//		System.out.println(shm.show());
//		
//		System.out.println(shm.find(shm.index(1), 1));
//		System.out.println(shm.find(shm.index("Siffra"), "Siffra"));
//		System.out.println(shm.find(shm.index("Hej"), 1));
//		System.out.println(shm.find(shm.index("Hej"), "Hej"));
//		System.out.println(shm.find(shm.index(213), 213));
		shm.put(3,4);
		shm.put(19,5);
		shm.put(35,6);
		shm.put(787,7);
		shm.put(8,4);
		shm.put(6,5);
		shm.put(7,6);
		shm.put(9,7);
		System.out.println(shm.show());
		shm.put(7,14);
		shm.put(5,15);
		shm.put(4,16);
		shm.put(19,17);
		shm.put(122,17);
		shm.put(27,14);
		shm.put(35,15);
		shm.put(44,16);
		shm.put(519,17);
		shm.put(6222,17);
		shm.put(335,15);
		shm.put(424,16);
//		shm.put(5119,17);
//		shm.put(6242,17);
		System.out.println(shm.show());
		System.out.println(shm.getLength());
		
		
		
		
	}
	
	public int getLength(){
		return table.length;
	}
	
	public V get(Object key) {
		@SuppressWarnings("unchecked")
		Entry<K,V> item = find(index((K) key), (K) key);
		
		if (item != null)
			return item.value;
		// Om item �r null borde inte item.value ocks� vara null?
		// return item.value;
		return null;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	/*
	 * 1. Platsen i vektorn tom och d� l�gger du bara till den. 
	 * 2. Platsen i vektorn �r inte tom och du f�r l�gga till den f�rst/sist p� kedjan. 
	 * 3. Key finns redan i Hash-tabellen och d� ska du skriva �ver den och returnera det gamla v�rdet. i
	 * 
	 * Medans detta sker skall loadFactor ej �verstiga 0.75, d� m�ste vektorn expanderas.:W
	 * 
	 */
	public V put(K key, V value) {
		int index = index(key);
		
		Entry<K,V> item = find(index(key), key);
		
		if(item != null)
			return item.setValue(value);
		
		item = new Entry<K,V>(key, value);
		
		if (table[index] != null)
			item.next = table[index];
			//table[index].next = item;
		//else
			//table[index] = item;
		
		table[index] = item;
		size++;
		
		if ((float) size / capacity > loadFactor)
			rehash();
		
		return null;
	}

	public V remove(Object key) {
		@SuppressWarnings("unchecked")
		Entry<K,V> item = table[index((K) key)];
		
		if (item != null) {
			if (item.getKey().equals(key)) {
				table[index((K) key)] = item.next;
				size--;
				return item.getValue();
			} else {
				while (item.next != null) {
					if (item.next.getKey().equals(key)) {
						Entry<K,V> oldItem = item.next;
						item.next = item.next.next;
						return oldItem.getValue();
					}
					item = item.next;
				}
			}
		}
		
		return null;
	}

	public int size() {
		return size;
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		
		for (int index = 0; index < table.length; index++) {
			Entry<K,V> item = table[index];
			while (item != null) {
				sb.append(index + "\t" + item.toString() + " ,");
				item = item.next;
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	private void rehash() {
		System.out.println("Rehashing now");
		capacity = capacity * 2;
		
		Entry<K,V>[] oldTable = table;
		
		table = (Entry<K,V>[]) new Entry[capacity];
		
		size = 0;
		
		for (Entry<K,V> e : oldTable) {
			while (e != null) {
				put(e.getKey(), e.getValue());
				e = e.next;
			}
		}
	}
	
	private int index(K key) {
		int index = key.hashCode() % table.length;
		
		if (index < 0)
			index = index + table.length;
		
		return index;
	}
	
	/* Deprecated Method
	private int index(K key) {
		int index = 0;
		
		for (Entry<K,V> e : table) {
			if (e.key.equals(key)) return index;
			index++;
		}
		
		return -1;
	}
	*/

	private Entry<K,V> find(int index, K key) {
		Entry<K,V> e = table[index];
		
		while (e != null) {
			if (e.getKey().equals(key))
				return e;
			
			e = e.next;
		}
		
		return null;
	}

	/* Deprecated Method
	private Entry<K,V> find(int index, K key) {
		for (Entry<K,V> e : table) {
			if (e.key.equals(key) && index(e.key) == index)
				return e;
			if (e.equals(null))
				return null;
		}
		
		return null;
	}
	*/
	
	private static class Entry<K,V> implements Map.Entry<K,V> {
		private K key;
		private V value;
		private Entry<K,V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public V setValue(V newValue) {
			V oldValue = this.value;
			value = newValue;
			return oldValue;
		}
		
		public String toString() {
			return key.toString() + " = " + value.toString();
		}
		
	}
}
