	package SnakeGame2;
	
	public class View {
		
		public void showGrid(char arr[][]){
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
			System.out.print(arr[i][j]+" ");		
			}
			System.out.println();
		}	}
		public void displayOption() {
			System.out.println("1.Up");
			System.out.println("2.Down");
			System.out.println("3.Left");
			System.out.println("4.Right");
			System.out.println("Enter the option");
		}
		public void gameOver() {
			System.out.println("Game Over");
			System.exit(0);
		}public void gameWin() {
			System.out.println("You Win...!");
			System.exit(0);
		}
	
	}
