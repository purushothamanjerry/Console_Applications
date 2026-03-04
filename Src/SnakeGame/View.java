package SnakeGame;

public class View {
	
	public void displayGrid(char arr[][]){
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void gameOver(){
		System.out.println("Game Over ...!");
		System.exit(0);
	}
	public void displayOperation() {
		System.out.print("please enter the move:");
		System.out.println("up / down / right /left");
	}
}
