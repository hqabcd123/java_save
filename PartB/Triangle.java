public class Triangle extends Shape{
	
	private int length;
	
	public  Triangle(int x, int y, int length){
		super(x, y);
		this.length = length;
	}
	
	public int getLength(){
		return length;
	}
	
	public double getArea(){
		return (Math.sqrt(3)/4)*Math.pow(length,2);
	}
	
	public double getPreimeter(){
		return length + length + length ;
	}
	
	public String toString(){
		return "Equivalent Triangle, " + getX() + ", " + getY() + ", " + length;
	}
	
	public String export(){
		return "Equivalent Triangle, " + getX() + ", " + getY() + ", " + length;
	}
	
}