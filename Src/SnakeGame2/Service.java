package SnakeGame2;
import java.util.*;
public class Service {
	View view=new View();
	public void drawGrid(LinkedList<Body> body, int food[], char grid[][], char h) {
		
		Body head=body.getFirst();

	    Body fd = new Body(food[0], food[1]);

	    for (int i = 0; i < grid.length; i++) {
	  for (int j = 0; j < grid[0].length; j++) {

	            Body b = new Body(i, j);

	            if (b.equals(head)) {
	                grid[i][j] = h;      
	            } 
	            else if (body.contains(b)) {
	                grid[i][j] = 'o';    
	            } 
	            else if (b.equals(fd)) {
	                grid[i][j] = 'x';    
	            } 
	            else {
	                grid[i][j] = '.';    
	            }
	        }
	    }
	}

 	public void generateFood(int food[],LinkedList<Body>body) {
	 Random r=new Random();
	 while(true) {
		 int row=r.nextInt(4);
		 int col=r.nextInt(4);
         Body b = new Body(row,col);
		 if(!body.contains(b)) {
			 food[0]=row;
			 food[1]=col;
			 break;
		 }
	 }
 }public boolean checkEdge(int dRow, int dCol, char grid[][], LinkedList<Body> body) {
	    Body head = body.getFirst();
	    int newRow = head.row + dRow;
	    int newCol = head.col + dCol;
	    if (newRow >= grid.length || newCol >= grid[0].length) {
	        return false;
	    }
	    if (newRow < 0 || newCol < 0) {
	        return false;
	    }
	    return true;
	}
 public void nextMove(char grid[][],LinkedList<Body>body,int food[],int r,int c){
		if(!checkEdge(r, c,grid, body)) {
			view.gameOver();
		}Body head=body.getFirst();
		Body current = new Body(head.row + r, head.col + c);
		if(body.contains(current)) {
			view.gameOver();
		}
		if(current.row==food[0] && current.col==food[1]) {
			generateFood(food, body);
		}else {
			body.removeLast();
		}
		body.addFirst(current);
	}

}
