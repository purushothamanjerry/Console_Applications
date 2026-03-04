package SnakeGame;

import java.util.Objects;

public class body {
	int r;
	int c;
	
	public body(int r, int c) {
		this.r = r;
		this.c = c;

	}
	@Override
	public boolean equals(Object o) {
		if(this==o)return true;
		if(!(o instanceof body))return false;
		body b=(body)o;
		return  r==b.r && c==b.c;
	}
	  @Override
	    public int hashCode() {
	        return Objects.hash(r, c);
	    }
}
