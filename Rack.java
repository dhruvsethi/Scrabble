package Tasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rack {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] arg)  {

		String rack;
		int i, c, length;
		ArrayList<String> sub = new ArrayList<String>();

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string to print it's all substrings");
		rack = in.nextLine();

		length = rack.length();

		sub = subString(rack, length);
		
		
		
		
		
		sub = sort(sub);//anagrams of all subsets
		System.out.println(sub);//anagrams of all subsets
		
		Map<String,String> anagram=readFile("C:\\Users\\magulati\\Downloads\\sowpods.txt");
		String check=checkformatch(anagram,sub);
		System.out.println(check);
	}

	private static String checkformatch(Map<String, String> anagram, ArrayList<String> sub) {
		// TODO Auto-generated method stub
		for(String s : sub){
		if (anagram.containsKey(s)){
			System.out.println( anagram.get(s));
		}

		}
		return "none";
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

	public static ArrayList<String> sort(ArrayList<String> sub)
	{	ArrayList<String>sortedlist=new ArrayList<String>();
		for(String s : sub) {
			char[] c = s.toLowerCase().toCharArray();
			Arrays.sort(c);
		 sortedlist.add(String.valueOf(c));
	}
	return sortedlist;	
	}
		
	
	
	
	public static Map<String,String> readFile(String path){
		 Map<String,String> words_count = new HashMap<String,String>();
			
			try {
				FileInputStream fstream = new FileInputStream(path);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				String strLine;
				while ((strLine = br.readLine()) != null)   {
				  
					String sorted=sortLetters(strLine);
				     
					     if(words_count.keySet().contains(sorted))
					     {
					    	 
					         words_count.put(sorted, words_count.get(sorted)+"  "+strLine);
					     }
					     else
					         words_count.put(sorted,strLine);

					}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return words_count;
		
	}

	private static String sortLetters(String strLine) {
		// TODO Auto-generated method stub
		char[] chars = strLine.toCharArray();
       Arrays.sort(chars);
       String sorted = new String(chars).toLowerCase();
		return sorted;
	}

//use the list of anagram lists to compare the substrings
}
