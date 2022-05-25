public abstract class Shape{
	
	private int x;
	private int y;
	
	public Shape(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
	public abstract double getArea();
	public abstract double getPreimeter();
	public abstract String export();
	
}