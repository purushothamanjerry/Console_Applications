package SnakeGame2;

public class Body {
	
	int row;
	int col;
	public Body(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public Body() {
	}
	public boolean equals(Object o){
		if(this==o)return true;
			if(!(o instanceof Body))return false;
			Body other=(Body)o;
			return this.row==other.row  && this.col==other.col;
	}
}
