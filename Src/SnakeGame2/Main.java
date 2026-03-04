package SnakeGame2;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Service service=new Service();
		View view=new View();
		Scanner sc=new Scanner(System.in);
		char grid[][]=new char[4][4];
		int food[]=new int[2];
		LinkedList<Body>body=new LinkedList<>();
		body.add(new Body(0,0));
		service.generateFood(food, body);
		char head='>';
		while(true) {
			if(body.size()==grid[0].length*grid.length) {
				view.gameWin();
			}
			service.drawGrid(body, food, grid, head);
			view.showGrid(grid);
			view.displayOption();
			int opt=sc.nextInt();
			switch(opt) {
			case 1->{
				service.nextMove(grid, body, food, -1, 0);
				head='^';
			}case 2->{
				service.nextMove(grid, body, food, 1, 0);
				head='v';
			}case 3->{
				service.nextMove(grid, body, food, 0, -1);
				head='<';
			}case 4->{
				service.nextMove(grid, body, food, 0, 1);
				head='>';
			}
			case 5->{
				view.gameOver();
			}default->{
				continue;
			}
			}
		
		}
	}
}
