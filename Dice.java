package classEx5;

public class Dice { 
	final public static int maximumRoll = 10;
	final public static int Max = 6;
	public static int P_win =0;
	public static int C_win =0;
	public static int tie=0;
	public static int player;
	public static int com;
	
	public void whoWon(String p)
	{
		if(P_win>C_win) System.out.print("Congratulations!! "+p+" wins");
		else if(C_win>P_win) System.out.print("Sorry,computer beats you");
		else System.out.print("It is a tie");
	}
	
	public void roll()
	{
		System.out.println("\nPlayer  |  Computer");
		System.out.println("___________________");
		for(int i =1;i<=maximumRoll;i++)
		{
			player = (int) ((Math.random()*100) %Max +1);
			com = (int) ((Math.random()*100) %Max +1);
			System.out.println("   "+player+"    |     "+com);
			if(player>com) P_win +=1;
			else if(com>player) C_win +=1;
			else tie +=1;
		}
	}
}
