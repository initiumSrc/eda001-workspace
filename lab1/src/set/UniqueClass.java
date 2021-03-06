package set;

import java.util.Iterator;

public class UniqueClass {
	
	public static void main(String[] args) {
		int[] test = { 0, 3, 2, 4, 7, 5, 8, 8, 8, 9 };
		
		int[] asd = uniqueElements(test);
		
		System.out.println(asd.length);
		
		for (int i = 0; i < asd.length; i++) {
			System.out.print(asd[i]);
		}
	}
	
	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> ms = new MaxSet<Integer>();
		
		for (int i : ints) {
			ms.add(i);
		}
		
		int[] ret = new int[ms.size()];
		
		System.out.println(ints.length);
		System.out.println(ms.getMax());
		
		/*
		Iterator<Integer> iter = ms.iterator();
		
		int q = 0;
		while (iter.hasNext()) {
			int temp = iter.next();
			System.out.println("temp: " + temp);
			
			ret[q] = temp;
			
			//ms.remove(temp);
			
			iter.remove();
			
			System.out.println("temp remove: " + iter.next());
			
			q++;
		}
		*/
		int tempSize = ms.size();
		for (int i = 0; i < tempSize; i++) {
			System.out.println("i : " + i);
			ret[i] = ms.getMax();
			System.out.println(ms.remove(ms.getMax()));
		}
		
		
		/*for (int i : ms) {
			ret[i] = ms.getMax();
			ms.remove(ms.getMax());
		}*/
		
		return ret;
	}
}
