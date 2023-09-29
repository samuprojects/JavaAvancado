package br.com.softblue.java.generics.exercicio;

import java.util.ArrayList;
import java.util.List;

public class Map<K, V> {
	
	private List<K> keys = new ArrayList<K>();
	
	private List<V> values = new ArrayList<>();
	
	public boolean put (K key, V value) {
		if (keys.contains(key)) {
			int index = getKeyIndex(key);
			values.set(index, value);
			return false;
		} else {
			keys.add(key);
			values.add(value);
			return true;
		}
	}
	
	public V get(K key) {
		int index = getKeyIndex(key);
		if (index < 0) {
			return null;
		}
		return values.get(index);
	}
	
	private int getKeyIndex (K key) {
		for (int i = 0; i < keys.size(); i++) {
			K k = keys.get(i);
			
			if (k.equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	public void clear() {
		keys.clear();
		values.clear();
	}
}