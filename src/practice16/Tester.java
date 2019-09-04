package practice16;
import java.util.Scanner;

/*-自作例外１
 * 継承
 * class クラス名 extends 元となるクラス名{親クラスとの「差分」メンバ}
 */
class Exception1 extends Exception {
	Exception1(String s, Throwable e){
		//親クラスのコンストラクタ呼び出し super(引数);
		super(s,e);
	}
}

//自作例外２
class Exception2 extends RuntimeException{
	Exception2(String s, Throwable e){
		super(s,e);
	}
}

public class Tester{
	
	/*swの値に応じて異なる例外を出力
	 * swの入力は１か２
	 */
	
	static void work(int sw) throws Exception{
		switch(sw) {
		//RuntimeExceptionは回復が必須ではない状況
		case 1:throw new RuntimeException("例外１発生");
		//Exceptionは回復見込みがある状況
		case 2:throw new Exception("例外２発生");
		}
	}
	
	//workを呼び出す
	static void test(int sw)throws Exception{
		try {
			work(sw);
		}
		//エラー文が変数eに代入されている 
		catch(RuntimeException e){
			throw new Exception1("例外１",e);
		}catch(Exception e) {
			throw new Exception2("例外２",e);
		}
	}
	
	public static void main(String[] args) {
		
		//入力を受け取る
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("sw:");
		int sw = stdIn.nextInt();
		
		try {
			test(sw);
		}catch(Exception e) {
			
			//ここでException1と2の両方を補足
			System.out.println("例外：" + e);
			System.out.println("例外の原因" + e.getCause());
			
			//例外の伝播の様子を表示
			e.printStackTrace();
			
		}finally {
			System.out.println("プログラム終了");
		}
	}
}