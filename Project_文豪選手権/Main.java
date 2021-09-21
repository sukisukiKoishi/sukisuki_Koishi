import java.util.Random;
import java.util.Scanner;

class Main{
	public static void main(String[]args){
		

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		// String maga = scan.next();
		// String []maga2 = maga.split("");

		// int a = serchWordMAGATORO(maga2);
		// System.out.print(a);
		
		String []magaNovel = new String[rand.nextInt(2000)+2800];
		final String []MAGATORO = {"ま","が","と","ろ","。\r\n"};//4
		int MagaSpace = rand.nextInt(40)+20;

		for(int i = 0;i < rand.nextInt(5)+5;i++){
			System.out.print(MAGATORO[rand.nextInt(4)]);
		}
		System.out.print("〜");
		for(int i = 0;i < rand.nextInt(5)+5;i++){
			System.out.print(MAGATORO[rand.nextInt(4)]);
		}
		System.out.println("〜\r\n");

		magaNovel[0] = "　";

		long MAGAStart = System.currentTimeMillis();
		for(int i = 1;i < magaNovel.length;i++){
			
			
			if(i == MagaSpace){
				MagaSpace += rand.nextInt(40)+20;
				magaNovel[i] = MAGATORO[4];
			}else{
				magaNovel[i] = MAGATORO[rand.nextInt(MAGATORO.length-1)];
			}
		}
		long MAGAEnd = System.currentTimeMillis();

		dispArray(magaNovel);
		System.out.println("\r\n\r\n　　"+magaNovel.length+"文字");
		long MAGAStart1 = System.currentTimeMillis();
		System.out.println("\r\n\r\nまがとろ指数:"+serchWordMAGATORO(magaNovel)+"　　＊１");
		//long MAGAEnd1 = System.currentTimeMillis();
		//System.out.println("実行時間　　＊２");
		//System.out.println(">>まがとろ作成:"+(MAGAEnd - MAGAStart)+"　　＊３\r\n>>まがとろ検索:"+(MAGAEnd1 - MAGAStart1)+"　　＊４");

		atogaki();


	}


	public static void dispArray(String []array){
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i]);
		}
	}

	public static int serchWordMAGATORO(String []a){
		
		int timeOfMagatoro = 0;
		for(int i = 3;i <= a.length;i++){
			
			boolean temp = a[i-3].equals("ま") && a[i-2].equals("が") && a[i-1].equals("と") && a[i].equals("ろ");
			
			if(temp){
				//System.out.println(i);
				timeOfMagatoro ++;
			}
		}

		return timeOfMagatoro;
	}

	public static void atogaki(){
		System.out.println("\r\n＊注");
		System.out.println("　＊１　まがとろ指数：本文中の”まがとろ”の数である。");
		//System.out.println("　＊２　実行時間:この小説はプログラムのランダム生成で作成している。一応プログラムの実行時間を記す。");
		//System.out.println("　＊３　まがとろ作成:まがとろ文を作成したときにかかった時間");
		//System.out.println("　＊４　まがとろ検索:まがとろ文の中の”まがとろ”の数を探すのにかかった時間\r\n");

	}

}