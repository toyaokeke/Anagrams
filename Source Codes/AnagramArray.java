import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AnagramArray {
	
	private AnagramLinkedList [] anagramList;
	String fileName;
	int counter;
	int count;
	
	public AnagramArray(String fileName) {
		this.fileName = fileName;
		counter = getSize(); 
		anagramList = new AnagramLinkedList[counter];
		count = 0;
	}
	
	public void createList() {
		String word;
		int trackWords = 0;
		File file = new File (fileName);
		try {
			Scanner scan = new Scanner (file);
			while(scan.hasNextLine()){
				
				word = scan.nextLine();
				trackWords++;
				
				if(anagramList[0] == null) {
					Node firstNode = new Node(word);
					AnagramLinkedList firstElement = new AnagramLinkedList();
					firstElement.insertInOrder(firstNode);
					anagramList[0] = firstElement;
					count = count + 1;
				}
				else if(trackWords <= counter) {
					Node check = new Node(word);
					addWord(check);
				}
			}
			scan.close();
			trimArray(); 
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addWord(Node check) {
		int i = 0;
		
		while(anagramList[i] != null) {
			if(anagramList[i].getHead().getAnagram().equalsIgnoreCase(check.getAnagram())) {
				anagramList[i].insertInOrder(check);
				return;
			}
			i = i + 1;
		}
		AnagramLinkedList newLink = new AnagramLinkedList();
		newLink.insertInOrder(check);
		anagramList[i] = newLink;
		count  = count + 1;
	}
	
	public void trimArray() {
		AnagramLinkedList [] temp = new AnagramLinkedList[count];
		
		for (int i = 0; i < count; i++) {
			temp[i]  = anagramList[i];
		}
		anagramList = temp;
	}
	
	public int getSize() {
		int counter = 0;
		File file = new File (fileName);
		try {
			Scanner scan = new Scanner (file);
			while(scan.hasNextLine()){
				scan.nextLine();
				counter++;
			}
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return counter;
	}
	
	public int getCount() {
		return count;
	}
	
	/**
	 * This method swaps the position of two elements in an array
	 *
	 * @param data   the array
	 * @param first  first element index
	 * @param second second element index
	 */
	private static void swap(AnagramLinkedList[] data, int first, int second) {
	  AnagramLinkedList temp = data[first];
	  data[first] = data[second];
	  data[second] = temp;
	}

	/**
	 * This method was taken from HackerRank
	 * (https://www.youtube.com/watch?v=SLauY6PpjW4)
	 *
	 * @param data the array
	 */
	public void sortArray() {
	  quickSort(anagramList, 0, anagramList.length - 1);
	}

	/**
	 * This method was taken from HackerRank
	 * (https://www.youtube.com/watch?v=SLauY6PpjW4). It is the recursive method
	 * that sorts the left and right partition of the array
	 *
	 * @param data the array
	 * @param left left partition
	 * @param right right partition
	 */
	private void quickSort(AnagramLinkedList[] data, int left, int right) {
	  if (left >= right) {
	    return;
	  }
	  Node pivot = data[(left + right) / 2].getHead();
	  int index = partition(data, left, right, pivot); 
	  quickSort(data, left, index - 1);
	  quickSort(data, index, right);
	}

	/**
	 * This method was taken from HackerRank
	 * (https://www.youtube.com/watch?v=SLauY6PpjW4). It partitions an array around
	 * a selected pivot element
	 *
	 * @param data  the array
	 * @param left  element to the left of the pivot
	 * @param right element to the right of the pivot
	 * @param pivot the pivot element
	 * @return returns the element on the left of the pivot
	 */
	private int partition(AnagramLinkedList[] data, int left, int right, Node pivot) {

	  while (left <= right) {
	    while (compareNodes(data[left].getHead(), pivot)) {
	      left++;
	    }

	    while (compareNodes(pivot, data[right].getHead())){
	      right--;
	    }

	    if (left <= right) {
	      swap(data, left, right);
	      left++;
	      right--;
	    }
	  }
	  return left;
	}
	
	public boolean compareNodes(Node a, Node b) {
		int i = 0; 
		int loopLenght = a.getWord().length();
		boolean compare = false;
		while (i < loopLenght) {
			if (a.getWord().charAt(i) < b.getWord().charAt(i)) {
				return compare = true;
			}
			else if(a.getWord().charAt(i) > b.getWord().charAt(i)) {
				return compare = false;
			}
			i++;
		}
		return false;
	}

	public void printToScreen() {
		for (int i = 0; i < anagramList.length; i++) {
			System.out.println("---------Anagram Number " + i + "---------");
			anagramList[i].printLinkedList();
		}
	}
	
	public void printToFile(String fileName) {		
		File file = new File(fileName);
		FileWriter writer = null;
		try {
			writer  = new FileWriter(fileName);
			for (int i = 0; i < anagramList.length; i++) {
				writer.write("Anagram Number " + i + " :");
				writer.write(anagramList[i].printListToFile());
				writer.write("\r\n\r\n");
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
            try {
                writer.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
