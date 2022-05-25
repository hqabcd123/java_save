import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class PartB{
	
	//Menu
	public static void printMenu(){
		System.out.println("1: Create a new shape");
		System.out.println("2: List all shapes");
		System.out.println("3: Save to file");
		System.out.println("4: Load from file");
		System.out.println("5: Remove shape from data");
		System.out.println("6: Change the element from shape");
		System.out.println("7: Quit");
	}
	
	public static void main(String args[]) throws IOException{
		
		int size = 0;
		String a =null;
		boolean saved = false;
		int choice = 0;
		int select = 0;
		int quit = 0;
		ArrayList<Shape> shape = new ArrayList<Shape>();
		
		do {
			Scanner sc = new Scanner(System.in);
			
			printMenu();
			System.out.print("What is your choice: ");
			choice = sc.nextInt();
			
			if(choice==1){				//create
				//check if shapes is full
				if(size==10){
					System.out.println("Cannot creat new shape, size is full");
				}
				else{
					//ask user the type of shape
					System.out.println("1: Circle");
					System.out.println("2: Rectangle");
					System.out.println("3: Square");
					System.out.println("4: Triangle");
					System.out.println("5: Quit");
					//ask user the attribute of the shape
					select = sc.nextInt();
					//create a new Shape and insert to shapes array
					switch(select){
						case(1):{
							//introduction
							System.out.println("Selected Circle"+"\nPlease input x, y, radius");
							//get radius
							int x = sc.nextInt();
							int y = sc.nextInt();
							int radius = sc.nextInt();
							
							shape.add(new Circle(x,y,radius));
							size++;
							saved = false;
							break;
						}
						
						case(2):{
							//introduction
							System.out.println("Selected Rectangle"+"\nPlease input x, y, width, height");
							//get width, height
							int x = sc.nextInt();
							int y = sc.nextInt();
							int width = sc.nextInt();
							int height = sc.nextInt();
							
							shape.add(new Rectangle(x,y,width,height));
							size++;
							saved = false;
							break;
						}
						
						case(3):{
							//introduction
							System.out.println("Selected Square"+"\nPlease input x, y, length");
							//get length
							int x = sc.nextInt();
							int y = sc.nextInt();
							int length = sc.nextInt();
							
							shape.add(new Square(x,y,length));
							size++;
							saved = false;
							break;
						}
						
						case(4):{
							//introduction
							System.out.println("Selected Triangle"+"\nPlease input x, y, length");
							//get length
							int x = sc.nextInt();
							int y = sc.nextInt();
							int length = sc.nextInt();
							
							shape.add(new Triangle(x,y,length));
							size++;
							saved = false;
							break;
								
						}
					
					}
				}
			}
			
			else if(choice==2){            //list
                int x = 1;
				double TotalArea = 0;
				double TotalPerimeter = 0;
				
                System.out.println("There are " + size + " shapes:");
                for(int i=0; i<size; i++){
                    System.out.println(i+1 + ". " + shape.get(i).toString());
                    TotalArea += shape.get(i).getArea();
                    TotalPerimeter += shape.get(i).getPreimeter();
                }
                System.out.printf("The total area is " + "%.2f",TotalArea );
                System.out.println(", and");
                System.out.printf("the total perimeter is " + "%.2f \n",TotalPerimeter);
            }
			
			else if(choice==3){			//save
				System.out.println("please input a txt file name");
				 String input = sc.nextLine();
				String filename = input;
		
				FileWriter fw = new FileWriter( filename );
				BufferedWriter bw = new BufferedWriter( fw );
				
				
				System.out.println();
				for(int i=0; i<size; i++){
					Shape s = shape.get(i);
					bw.write( s.export() );
					bw.write("\n");
				}
				a = input;
				bw.close();
				
				
			}
			
			else if(choice==4) {            //load
				FileReader fr = new FileReader(a);
				System.out.println("Selected " + "a.txt");
				int ch;
				while ((ch = fr.read()) != -1) {
					System.out.print((char) ch);
				}
				fr.close();
				saved = true;
			}
			
			else if(choice==5) {            //Remove
				System.out.println("Which shape you want to remove: ");
				for (int i = 0; i < shape.size(); i++) {
					System.out.println("    " + (i + 1) + ". " + shape.get(i).export());
				}
				shape.remove(sc.nextInt() - 1);
				for (int i = 0; i < shape.size(); i++) {
					System.out.println("    " + (i + 1) + ". " + shape.get(i).export());
				}
			}
			else if(choice==6){			//Change
				
			}
			
			else if(choice==7){			//Quit
				if(!saved){
					//ask user wanna save?
					System.out.println("Do you wanna save?");
					System.out.println();
					System.out.println("1. Yes /2. No");
					quit = sc.nextInt();
					switch(quit){
						case(1):{
							System.out.println("please input a txt file name");
							 String input = sc.nextLine();
							String filename = input;
					
							FileWriter fw = new FileWriter( filename+".txt" );
							BufferedWriter bw = new BufferedWriter( fw );
							
							
							System.out.println();
							for(int i=0; i<size; i++){
								Shape s = shape.get(i);
								bw.write( s.export() );
								bw.write("\n");
							}
							
							bw.close();
									}
						
						case(2):{
							break;
						}
						
						
					}
				}break;
			}
			
			else{						//error
				System.out.println("please input a correct value");
				return;
			}
			
		}while(choice != 7);
		
	}
	
}