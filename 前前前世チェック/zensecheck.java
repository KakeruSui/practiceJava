/*参考URL
 * https://creatase.info/lets_make_a_program_zundoko-vol-3/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class zensecheck {
	public static void main(String[] args) {

		System.out.println("君の");

		//比較用のリスト
		String correctStr = "前前前世";
		//ランダムで文字を出力するリスト
		String[] words = {"前","世"};

		//listの初期化
		List<String> list = new LinkedList<>();

		Random r = new Random();

		//格納用の空の配列
		String str = "";
		String word = "";

		while(true) {

			//word前・世をランダムで格納
			word = words[r.nextInt(2)];
			System.out.println(word);
			list.add(word);

			//listの長さが4を超えたらremoveで０番目の要素を削除する
			if(list.size() > 4) {
				list.remove(0);
			}

			//strに直近4回分の前・世を格納
			str = list.stream().collect(Collectors.joining());

			//strとcorrectStrの中身が一緒なら歌詞を表示してループを抜ける
			if(str.equals(correctStr)) {
				System.out.println("から僕は君を探しはじめたよ");
				break;
			}
		}
	}
}
