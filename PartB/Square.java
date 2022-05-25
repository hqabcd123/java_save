public class Square extends Shape{
	
	private int length;
	
	public  Square(int x, int y, int length){
		super(x, y);
		this.length = length;
	}
	
	public int getLength(){
		return length;
	}
	
	public double getArea(){
		return length * length;
	}
	
	public double getPreimeter(){
		return length + length + length + length;
	}
	
	public String toString(){
		return "Square, " + getX() + ", " + getY() + ", " + length;
	}
	
	public String export(){
		return "Square, " + getX() + ", " + getY() + ", " + length;
	}
		
}