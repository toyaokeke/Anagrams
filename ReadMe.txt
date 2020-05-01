By Toya Okeke and Charles Chukwukaeme

Read Me
•	Open the command prompt and navigate to the appropriate directory
•	Compile the java source code Demo. This is the file that runs the application 
•	In the command prompt enter java Demo inputFileName.txt outputFileName.txt 
o	inputFileName.txt should contain your list of words 
o	outputFileName.txt is the name of the file that the program will read to
•	When the program runs, it does the following:
o	Creates an AnagramArray object to store the linked list. The member variable is an array of AnagramLinkedList objects. 
o	It calls the method createArray() in the AnagramArray class which reads through the input file one word at a time. 
o	Each word is used to create a node and a corresponding sorted word called anagram in the Node class.
o	The first node created is inserted into an AnagramLinkedList object which is inserted into the first position of the array of references (the AnagramArray object created in the first step).
o	Each subsequent word is used to create a node, and the anagram member variable of this node is compared against the anagram member variable of the head nodes of the AnagramLinkedList objects already in the AnagramArray object.
o	If a match is found, it is inserted into this AnagramLinkedList, in order. If no match is found, a new AnagramLinkedList object is created and the node is inserted into this object. Finally, the AnagramLinkedList object, along with the inserted node, is entered into the next element of the AnagramArray object.
o	This goes on till the entire word in the input file is read.
o	The next step in the Demo class is to call the sortArray() function which sorts the AnagramLinkedList in the array of reference in ascending order
o	Finally, this array of references is read into the output file name provided in the command line
