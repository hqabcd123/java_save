import java.io.*;

public class Test1 {
	
	public static void main(String args[]) throws IOException{
		
		Square square1 = new Square(3,4,5);
		Circle circle1 = new Circle(4,5,6);
		Rectangle rectangle1 = new Rectangle(5,6,8,9);
		Triangle triangle1 = new Triangle(1,2,4); 
		
		System.out.println( square1 );
		System.out.println( circle1 );
		System.out.println( rectangle1 );
		System.out.println( triangle1 );
		
		System.out.println(triangle1.getPreimeter() + " " + triangle1.getArea() );
		
		Shape shapes[] = new Shape[10]; 
		int size = 0;
		shapes[0] = square1;
		size++;
		
		shapes[1] = circle1;
		size++;

		shapes[2] = rectangle1;
		size++;

		shapes[3] = triangle1;
		size++;

		double totalArea = 0;
		
		for(int i=0; i<size; i++){
			totalArea = totalArea + shapes[i].getArea();
		}
		
		System.out.println( totalArea );
		
		//Save
			
		String filename = "test.txt";
		
		FileWriter fw = new FileWriter( filename );
		BufferedWriter bw = new BufferedWriter( fw );
		
		
		System.out.println();
		for(int i=0; i<size; i++){
			Shape s = shapes[i];
			bw.write( s.export() );
			bw.write("\n");
		}
		
		bw.close();
		
		//Load
		
		System.out.println();
		
		FileReader fr = new FileReader ( filename );
		BufferedReader br = new BufferedReader( fr );
		
		String line = br.readLine();
		while( line != null){
			//System.out.println(line);
			String data[] = line.split(",");
			if(data[0].equals("Circle")) {
				int x = Integer.parseInt(data[1].trim());
				int y = Integer.parseInt(data[2].trim());
				int r = Integer.parseInt(data[3].trim());
				System.out.println(x + " " + y + " " + r);
				
				//new Circle(x,y,r) and put to the array
			}
			
			line = br.readLine();
		}
		
		br.close() ;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}