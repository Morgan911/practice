import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AnagramWorker {

	private String anagramFilePath;

	public AnagramWorker(String anagramFilePath) {
		setAnagramFilePath(anagramFilePath);
	}

	public Set<String> getAnagrams() {
		String delimiter = "[ {\r\n}]+";
		Set<String> result = new HashSet<String>();
		String[] data = getTextFromFile().split(delimiter);
		for (String str : data) {
			if(!isKnownAnagram(result, str)){
				result.add(str);
			}
		}
		return result;
	}

	public String getAnagramFilePath() {
		return anagramFilePath;
	}

	public void setAnagramFilePath(String anagramFilePath) {
		this.anagramFilePath = anagramFilePath;
	}

	@SuppressWarnings("resource")
	private String getTextFromFile() {
		StringBuffer buffer = new StringBuffer();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(getAnagramFilePath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line;
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	private boolean isKnownAnagram(Set<String> knownWords, String word){
		for (String knownWord : knownWords) {
			if(isAnagrams(knownWord, word))
				return true;
		}
		return false;
	}
	
	private boolean isAnagrams(String knownWord, String word){
		if(knownWord.length() != word.length())
			return false;
		
		for (Character ch : knownWord.toCharArray()) {
			if(!word.contains(ch.toString()))
				return false;
		}
		return true;
	}
	
	
}
