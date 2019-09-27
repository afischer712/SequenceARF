/**
 * 
 * This program takes in two strings from either a user for a .txt file and determines whether the first
 * string is a subsequence of the second
 * 
 * @author Adam Fischer
 * @version 9/27/19
 * 
 * 
 * CS 215 Programming Project 2
 * Fall 2019
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application  {

	public static void main(String[] args) throws FileNotFoundException {
		
		char sentinel = 0;//						variable to end the program based on user input
		Scanner input = new Scanner(System.in);//	scanner to take in input
		String subsequence;//						this is a string of the letters that the program checks for in the sequence
		String sequence;//							this is the word that could contain the subsequence
		String fileName;
		
		do {
		System.out.print("Would you like enter sequences manually or from a file? (M/F):" );
		
		if(input.next().toLowerCase().charAt(0)== 'm') {
			
			System.out.print("Enter the first sequence: ");
			subsequence = input.next().toLowerCase();
			System.out.print("Enter the second sequence: ");
			sequence = input.next().toLowerCase();
			
			ArrayStack seq = new ArrayStack(subsequence.length());
			
			
			for(int i = 0; i<subsequence.length(); i++) {
				seq.push(subsequence.charAt(i));
			}// end for loop to fill smallSeq
			
		
			for(int i= sequence.length()-1; i>-1; i--) {
				
				char thing;
				if(!seq.isEmpty()) {
						thing = (char) seq.peek();
				}// end if to make sure there are still letters in the stack
				else
					thing = 0;
				if(sequence.charAt(i)==thing) {
					seq.pop();
				}// end if to remove letters that are in the sequence
				
			}// end for to iterate through the sequence
			
			
			
			if(seq.isEmpty()) {
				System.out.println( subsequence + " IS A SUBSEQUENCE OF " + sequence);
			}
			else
				System.out.println(subsequence + " IS NOT A SUBSEQUENCE OF " + sequence);
			
			
			
		}// end if for manual sequences
		else{
			
			System.out.print("Enter the name of the file to process: ");
			fileName = input.next();
			
			Scanner file = new Scanner(new File(fileName));
			
			
			
			while(file.hasNext()) {
				
				subsequence = file.next();
				sequence = file.next();
				
				ArrayStack seq = new ArrayStack(subsequence.length());
				char[] sub = new char[subsequence.length()-1];
				
				for(int i=0; i<subsequence.length()-1; i++){
					sub[i] = subsequence.charAt(i);
				}
				
				
				for(int i = 0; i<sub.length; i++) {
					seq.push(sub[i]);
				}// end for loop to fill smallSeq
				
			
				for(int i= sequence.length()-1; i>-1; i--) {
					
					char thing;
					if(!seq.isEmpty()) {
							thing = (char) seq.peek();
					}// end if to make sure that there are chars left to compare in the stack
					else
						thing = 0;
					if(sequence.charAt(i)==thing) {
						seq.pop();
					}// end if to take chars out of the stack if they are in the sequence
					
				}// end for to iterate through the sequence
				
				subsequence = "";
				for(int i=0; i<sub.length; i++) {
					subsequence += sub[i];
				}
				
				if(seq.isEmpty()) {
					System.out.println( subsequence + " IS A SUBSEQUENCE OF " + sequence);
				}// end if to check which statement is needed
				else
					System.out.println(subsequence + " IS NOT A SUBSEQUENCE OF " + sequence);
				
				
			}// end while loop to go through the given file
			
			
			
		}// end  if else for file things
		
		System.out.print("Would you like to enter more sequences? (Y/N): ");
		sentinel = input.next().charAt(0);
		
		}// end do while to make the program run until the user tells it to end
		while(sentinel!= 'n');
		
		System.out.print("<END RUN>");
		
		
	}// end main

}// end application
