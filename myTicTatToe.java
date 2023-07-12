package classEx4;
import java.util.*;

public class myTicTatToe {
	static char[][] board;
	public static char whoWin(char[][] tttBoard)
	{
		for(int i=0;i<3;i++)
		{
			if(tttBoard[i][0]==tttBoard[i][1] && tttBoard[i][1]==tttBoard[i][2] && tttBoard[i][0]==tttBoard[i][2] && tttBoard[i][0]!='_')
			{
				return tttBoard[i][0];
			}
		}
		for(int i=0;i<3;i++)
		{
			if(tttBoard[0][i]==tttBoard[1][i] && tttBoard[1][i]==tttBoard[2][i] && tttBoard[0][i]==tttBoard[2][i] && tttBoard[0][i]!='_')
			{
				return tttBoard[0][i];
			}
		}
		if(tttBoard[0][0]==tttBoard[1][1] && tttBoard[1][1]==tttBoard[2][2] && tttBoard[0][0]==tttBoard[2][2] && tttBoard[0][0]!='_')
		{
			return tttBoard[0][0];
		}
		if(tttBoard[0][2]==tttBoard[1][1] && tttBoard[1][1]==tttBoard[2][0] && tttBoard[2][0]==tttBoard[0][2] && tttBoard[0][2]!='_')
		{
			return tttBoard[0][2];
		}
		return ' ';
	}
	public static void display()
	{
		System.out.print("      c0 |c1 |c2\n");
		System.out.println("row 0: "+board[0][0] +" | "+board[0][1] +" | "+board[0][2] +" |");
		System.out.println("row 1: "+board[1][0] +" | "+board[1][1] +" | "+board[1][2] +" |");
		System.out.println("row 2: "+board[2][0] +" | "+board[2][1] +" | "+board[2][2] +" |");
	}
	public static boolean isFull(char[][] tttBoard)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(tttBoard[i][j]=='_') return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Welcome to Tic-Tat-Toe game");
		System.out.println("---------------------------");
		char turn ='X';
		String winner=null;
		board = new char[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='_';
			}
		}
		
		while(winner==null)
		{   
			display();
			int row;
			int col;
			//check if available
			while(true)
			{
				System.out.println(" ");
				System.out.println(turn+"'s turn to place");
				System.out.print("Enter row(0,1,2) to place " );
				row = sc.nextInt();
				System.out.print("Enter col(0,1,2) to place ");
				col = sc.nextInt();
				if(!((row>=0&&row<=2) && (col>=0&&col<=2)))
				{
					System.out.println("Position is out of bound. Try again.");
				}
				else if(board[row][col]!='_')
				{
					System.out.println("Someone has already taken the move. Try again,");
				}
				else
				{
					break;
				}
			}
			board[row][col]=turn;
			//turn 
			if(turn=='X') { turn = 'O';}
			else { turn = 'X'; }
			if(whoWin(board)=='X') {winner = "X";}
			else if (whoWin(board)=='O') {winner = "O";}
			else 
			{
				if(isFull(board)) winner="T";
			}
			
		}
		if(winner.equals("X")) {display();System.out.println("Congrations! X is a winner.");}
		else if(winner.equals("O")) {display();System.out.println("Congratulations! O is a winner.");}
		else{display();System.out.println("It is a draw.");}
		sc.close();
	}

}
