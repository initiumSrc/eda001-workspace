package phonebook;

import java.util.Set;

public class Main {
	public static void main(String[] args) {	
		PhoneBook pb = new PhoneBook();
		
		pb.put("Emil Hammarström", "123");
		pb.put("Gloopy Gloop-eye", "123");
		pb.put("Emil Hammarström", "87213487124");
		pb.put("Emil Hammarström", "123");
		pb.put("ASDASDASD ASDASD", "1231");
		
		System.out.println(pb.findNames("123"));
		pb.remove("ASDASDASD ASDASD");
		System.out.println(pb.findNumber("Emil Hammarström"));
		System.out.println(pb.findNumber("ASDASDASD ASDASD"));
		
		Set<String> numberSet = pb.numbers();
		Set<String> nameSet = pb.names();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for (String str : numberSet)
			sb.append(str + ", ");
		
		for (String str : nameSet)
			sb2.append(str + ", ");
		
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
		
		new PhoneBookGUI(pb);
	}

}
