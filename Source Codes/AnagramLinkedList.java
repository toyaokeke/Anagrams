public class AnagramLinkedList {
	
	private Node head;
	
	public AnagramLinkedList (){
		head = null;
	}
	
	public void insert (Node s){
		Node cursor = head;
		
		if (head == null){
			head = s;
			return;
		}
		while (cursor.getNext() != null)
			cursor = cursor.getNext();
		
		cursor.setNext(s);
	}
	
	public void insertInOrder (Node s){
		Node cursor = head;
		Node placeHolder;

		if (head == null){
			head = s;
			return;
		}
		
		if ((this.length() == 1 )) {
			if(compareNodes(cursor, s)) {
				cursor.setNext(s);
				return;
			}
			else {
				head = s;
				head.setNext(cursor);
				return;
			}
		}
		else {
			while (cursor != null){
				if(compareNodes(s, cursor)) {
					head = s;
					head.setNext(cursor);
					return;
				}
				else if(compareNodes(cursor, s)) {
					if(cursor.getNext() == null) {
						cursor.setNext(s);
						return;
					}
					else if(compareNodes(s, cursor.getNext())) {
						placeHolder = cursor.getNext();
						cursor.setNext(s);
						s.setNext(placeHolder);
						return;
				}
			}
				cursor = cursor.getNext();
			}
		}
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

	/**
	 * PROMISES: Deletes the last element in the linked list
	 */
	public void removeEndElement() {
		Node cursor = head;
		int count = 1;

		if (head == null){
			System.out.println("The list has no elements to delete");
			return;
		}
		if (this.length() == 1) {
			head = null;
		}
		else {
			while (cursor != null){
				if(count == (this.length() - 1)) {
					cursor.setNext(null);
					return;
				}
				count++;
				cursor = cursor.getNext();
			}
		}
	}

	/**
	 * PROMISES: Deletes the first element in the list 
	 */
	public void removeFirstElement() {
		Node newList = head.getNext();
		
		if (head == null) {
			System.out.println("The list has no elements to delete");
			return;
		}
		else{
			head = newList;
		}
	}
	
	public Node getHead() {
		return head;
	}
	
	/**
	 * PROMISES: Returns the length of the elements in the linked list
	 */
	public int length() {
		int lenght = 0;
		Node cursor = head;
		
		while (cursor != null){
			lenght++;
			cursor = cursor.getNext();
		}
		return lenght;
	}
	
	public void printLinkedList (){
		Node cursor = head;
		
		while (cursor != null){
			System.out.println (cursor.toString());
			cursor = cursor.getNext();
		}
	}
	
	public String printListToFile (){
		Node cursor = head;
		String print = "";
		
		while (cursor != null){
			print  = print + cursor.toString();
			cursor = cursor.getNext();
		}
		return print;
	}
}
