import java.util.Set;


public class Main {

	public static void main(String[] args) {
		
		String path = "../Task2_Anagrams/data/data.txt";
		AnagramWorker anWorker = new AnagramWorker(path);
		long before = System.currentTimeMillis();
		System.out.println(before);
		Set res = anWorker.getAnagrams();
		long after = System.currentTimeMillis();
		System.out.println(after);
		System.out.println(after - before);
		System.out.println(res);
	}

}
