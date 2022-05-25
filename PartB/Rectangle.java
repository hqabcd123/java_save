public class Rectangle extends Shape{
	
	private int width;
	private int height;
	
	public  Rectangle(int x, int y, int width, int height){
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeigth(){
		return height;
	}
	
	public double getArea(){
		return width * height;
	}
	
	public double getPreimeter(){
		return width*2 + height*2;
	}
	
	public String toString(){
		return "Rectangle, " + getX() + ", " + getY() + ", " + width + ", " + height;
	}
	
	public String export(){
		return "Rectangle, " + getX() + ", " + getY() + ", " + width + ", " + height;
	}
	
}