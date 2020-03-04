import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		AnagramArray myList = new AnagramArray(args[0]);
		
		Long startTime = System.nanoTime();
		myList.createList();

		myList.sortArray();
			
		myList.printToFile(args[1]);
		
		Long endTime = System.nanoTime();
		Long time = (endTime - startTime);
		double time1 = (double)time/1000000000;
		System.out.printf("The run time of the program is %f seconds", time1);
	}
}
