package Tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Rack {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] arg) throws IOException {

		String rack;
		int i, c, length;
		ArrayList<String> sub = new ArrayList<String>();

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string to print it's all substrings");
		rack = in.nextLine();

		length = rack.length();

		sub = subString(rack, length);
		String file = new String("/Users/ragrewal/Documents/sowpods.txt");
		List<List<String>> anagramsLists = anagramFinder(file,sub);
	}

	private static ArrayList<String> subString(String rack, int length) {
		ArrayList<String> sub = new ArrayList<String>();
		// TODO Auto-generated method stub
		for (int c = 0; c < length; c++) {
			for (int i = 1; i <= length - c; i++) {
				sub.add(rack.substring(c, c + i));
			}
		}
		return sub;

	}
	//Use this to find anagrams
	/*public static List<List<String>> anagramFinder(String fileName) throws IOException {
		Map<String, List<String>> listOfAnagrams = new HashMap<String, List<String>>();
		List<String> listOfWords = textFileReader(fileName);
		for(String s : listOfWords) {
			char[] c = s.toUpperCase().toCharArray();
			Arrays.sort(c);
			List<String> l = listOfAnagrams.get(String.valueOf(c));
			if(l == null) {
				l = new ArrayList<String>();
			} 
			l.add(s);
			listOfAnagrams.put(String.valueOf(c), l);
		}
		
		List<List<String>> anagrams = new ArrayList<List<String>>();
		for(Map.Entry<String, List<String>> e : listOfAnagrams.entrySet()) {
			if(e.getValue().size() > 1) {
				anagrams.add(e.getValue());
			}
		}
		return anagrams;
	}
	public static List<String> textFileReader(String file) throws IOException{
		  Path path = Paths.get(file);
		  return Files.readAllLines(path, ENCODING);
	}*/
//use the list of anagram lists to compare the substrings
}
