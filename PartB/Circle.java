public class Circle extends Shape{
	
	private int radius;
	
	public  Circle(int x, int y, int radius){
		super(x, y);
		this.radius = radius;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public double getArea(){
		return Math.PI * radius * radius;
	}
	
	public double getPreimeter(){
		return 2 * Math.PI * radius;
	}
	
	public String toString(){
		return "Circle, " + getX() + ", " + getY() + ", " + radius;
	}
	
	public String export(){
		return "Circle, " + getX() + ", " + getY() + ", " + radius;
	}
	
}