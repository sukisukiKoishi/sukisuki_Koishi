import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		String fileName  = scan.next();
		String IpAdd;
		HashMap<String,Integer> IpAndCount = new HashMap<String,Integer>();
		
		try {
			File f = new File(fileName);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String s = br.readLine();
			
			//配列分割
			IpAdd = s.split(" ")[0];
			if(IpAndCount.containsKey(IpAdd)) {
				int preCount = IpAndCount.get(IpAdd) + 1;
				IpAndCount.put(IpAdd, preCount);
			}else {
				IpAndCount.put(IpAdd,1);
			}
			
			String IpAddr;
			
			
			while((s = br.readLine()) != null) {				
				IpAddr = s.split(" ")[0];
				
				if(IpAndCount.containsKey(IpAddr)) {
					int preCount = IpAndCount.get(IpAddr) + 1;
					IpAndCount.put(IpAddr, preCount);
				}else {
					IpAndCount.put(IpAddr,1);
				}
				
			}

			//System.out.println(IpAndCount);
			
			//ここからソートにかける
			
			TreeSet<String> IpSort = new TreeSet<String>();
			Collection<String> names = IpAndCount.keySet(); //データ一覧(Collection型)
			for(String temp: names) {
				IpSort.add(temp);
			}
			
			for(String temp : IpSort) {
				System.out.println(temp+": "+IpAndCount.get(temp)+" time(s)");
			}
			br.close();
			scan.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("File: "+fileName + " not found.");

		}catch(IOException e) {

		}
	}
}