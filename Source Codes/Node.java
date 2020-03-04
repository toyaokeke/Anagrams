public class Node {
	
	private String word;
	private String anagram;
	private Node next; 
	
	public Node (String word){
		this.word = word;
		anagram = this.anagramWord();
		setNext(null);
	}
	
	public String toString(){
		return word + "||";
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node  next) {
		this.next = next;
	}
	
	public String getAnagram() {
		return anagram;
	}
	
	public String getWord() {
		return word;
	}
	
	public String anagramWord() {
		char [] words = word.toCharArray();
		char[] sorted = new char[words.length];
		String sortedWord;
		sorted = mergeSort(words);
		sortedWord = String.copyValueOf(sorted);
		return sortedWord;
	}
	
	/**
	 * This method was taken from: https://www.youtube.com/watch?v=TzeBrDU-JaY)
	 */
	public static char[] mergeSort(char[] words) {
		int n = words.length;
		
		if(n < 2) {
			return words;
		}
		int mid = n / 2;
		char [] leftArray = new char[mid];
		char [] rightArray = new char[n - mid];
		for (int i = 0; i < mid; i++) {
			leftArray[i] = words[i];
		}
		for (int i = mid; i < n; i++) {
			rightArray[i - mid] = words[i];
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, words);
		return words;
	}
	
	/**
	 * This method was taken from: https://www.youtube.com/watch?v=TzeBrDU-JaY)
	 */
	public static char[] merge(char[] arr1, char[] arr2, char[] myArray) {
		int length1 = arr1.length, length2 = arr2.length, i = 0, j = 0, k = 0;
		
		while((i < length1) &&( j < length2)) {
			if(arr1[i] <= arr2[j]) {
				myArray[k] = arr1[i];
				i++;
			}
			else {
				myArray[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < length1) {
			myArray[k] = arr1[i];
			i++;
			k++;
		}
		while (j < length2) {
			myArray[k] = arr2[j];
			j++;
			k++;
		}
		return myArray;
	}
}