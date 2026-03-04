package SnakeGame;
import java.util.*;
public class Service {
	private View v=new View();
	private Scanner sc=new Scanner(System.in);
	public char[][] designGrid(char arr[][],int food[],char head,LinkedList<body>list){
		body h=list.getFirst();
	for(int i=0;i<arr.length;i++) {
		for(int j=0;j<arr[0].length;j++) {
			body b=new body(i,j);
			body f=new body(food[0],food[1]);
			if(h.equals(b)) {
				arr[i][j]=head;
			}else if(list.contains(b)) {
				arr[i][j]='o';
			}else if(b.equals(f)){
				arr[i][j]='x';
			}else {
				arr[i][j]='.';
			}
		}
	}
	return arr;
	}
	public int[] generateFood(int food[],List<body>list){
		Random r=new Random();
		while(true) {
			int row=r.nextInt(4);
			int col=r.nextInt(4);
			body b=new body(row,col);
			if(!list.contains(b)) {
				return new int[] {row,col};
			}
		}
	}
	public String getMove(){
		return sc.next();
	}
	public boolean checkGameend(LinkedList<body> list, char[][] grid, body move) {

	    body head = list.getFirst();
	    int newRow = head.r + move.r;
	    int newCol = head.c + move.c;

	    body next = new body(newRow, newCol);
	    if (newRow < 0 || newRow >= grid.length ||
	        newCol < 0 || newCol >= grid[0].length) {
	        v.gameOver();
	    }

	    body tail = list.getLast();
	    if (list.contains(next) && !next.equals(tail)) {
	        v.gameOver();
	    }

	    return true;
	}

	public int [] newFood(int r,int c,int food[],List<body>list){
		if(food[0]==list.getFirst().r+r && food[1]==list.getFirst().c+c) {
			return generateFood(food,list);
		}
		return food;
	}
}
