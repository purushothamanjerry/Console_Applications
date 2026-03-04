package SnakeGame;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Service s=new Service();
		View v=new View();
		LinkedList<body>list=new LinkedList<>();
		char grid[][]=new char[4][4];
		list.add(new body(0,0));
		int arr[]=new int[2];
		arr=s.generateFood(arr, list);
		char h='>';
		v.displayGrid(s.designGrid(grid, arr, h, list));
		while(true) {
			v.displayOperation();
			String str=s.getMove().toLowerCase();
			body move = null;



		switch (str) {
		case "up"    -> { move = new body(-1, 0); h='^'; }
		case "down"  -> { move = new body(1, 0);  h='v'; }
		case "left"  -> { move = new body(0, -1); h='<'; }
		case "right" -> { move = new body(0, 1);  h='>'; }
		
    default -> {
        System.out.println("Invalid move");
        continue;
    }

}
	    if (move == null) continue;

	if (s.checkGameend(list, grid, move)) {

    body head = list.getFirst();
    body newHead = new body( head.r + move.r,head.c + move.c);
    list.addFirst(newHead);

    if (arr[0] == newHead.r && arr[1] == newHead.c) {
        arr = s.generateFood(arr, list);
    } else {
        list.removeLast();
    }
}
	v.displayGrid(s.designGrid(grid, arr, h, list));
	

			
			}
		}
	}

