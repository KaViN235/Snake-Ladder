package SnakeLadder;
import java.util.Scanner;
public class Game {
		public static void laddergame(int NoOfplayers,String[] Playersname,String Startingplayer,int countofdice,int[] dicevalue){
			int[] playerposition  = new int[NoOfplayers];
			int[] Slidecount = new int[NoOfplayers];
			int[] Laddercount = new int[NoOfplayers];
			int[] reachend = new int[NoOfplayers];
			int currentplayer = 0;
			for(int i =0;i<NoOfplayers;i++)
			{
				if(Playersname[i].equals(Startingplayer))
				{
					currentplayer = i;
				}
			}
			int i=0;
				while(i<countofdice)
				{
					if(dicevalue[i] != 1 && playerposition[currentplayer]==0)
					{
						if(currentplayer == NoOfplayers - 1)
						{
							currentplayer = 0;
						}
						else
						{
							currentplayer++;
						}
						i++;
						continue;
					}
					playerposition[currentplayer]+= dicevalue[i];
					playerposition[currentplayer] = laddercheck(playerposition[currentplayer],currentplayer,Laddercount);
					playerposition[currentplayer] = slidecheck(playerposition[currentplayer],currentplayer,Slidecount);
						if(playerposition[currentplayer]>25)
					   {
						playerposition[currentplayer] -= dicevalue[i];
					   }
						if(playerposition[currentplayer] == 25)
						{
							reachneed(reachend,playerposition);
							print(NoOfplayers,Playersname,playerposition,reachend,Laddercount,Slidecount);
							System.out.println(Playersname[currentplayer]+" is the winner");
							break;
						}
						if(i==countofdice-1)
						{
							reachneed(reachend,playerposition);
							print(NoOfplayers,Playersname,playerposition,reachend,Laddercount,Slidecount);
					     	System.out.println("Game tie");
							break;
						}
						if(dicevalue[i]!=1)
						{
						currentplayer++;
						}
						if(currentplayer == NoOfplayers )
						{
							currentplayer = 0;
						}
						i++;
				}
				
		}
		public static void reachneed(int[] reachend,int[] playerposition)
		{
			for(int i= 0 ;i<reachend.length;i++)
			reachend[i] = 25-playerposition[i]; 
		}
		public static void print(int NoOfplayers,String[] Playersname,int[] playerposition ,int[] reachend,int[] Laddercount,int[] Slidecount) 
		{
			for(int i=0;i<NoOfplayers;i++)
			{
				System.out.println(Playersname[i]+"  playerposition: "+playerposition[i]+" need for reachend "+reachend[i]+" Slidecount "+ Slidecount[i]+" Laddercount "+Laddercount[i]);
			}
		}
		
		public static int slidecheck(int n, int i,int[] Slidecount)
		{
			switch (n) {
			case 21 :
				Slidecount[i]++;
				return 2;
				
			case 14 :
				Slidecount[i]++;
				return 5;
			case 24 :
				Slidecount[i]++;
				return 16;
			default:
				return n;
			}
		}
		public static int laddercheck(int n,int i,int[] Laddercount)
		{
			switch (n) {
			case 4 :
				Laddercount[i]++;
				return 12;
			case 6 :
				Laddercount[i]++;
				return 15;
			case 18 :
				Laddercount[i]++;
				return 23;
			default:
				return n;
			}
		}
		

		public static void main(String[] args)
		{
			Scanner s = new Scanner(System.in);
			System.out.println("...Snack&Ladder Game...");
			System.out.println("How many of you ready to play??\tPlayers:");
			int NoOfplayers = s.nextInt();
			System.out.println("Say your names...\nPlayers' names:");
			String[] Playersname = new String[NoOfplayers];
			for(int i =0;i<NoOfplayers;i++){
				Playersname[i] = s.next();
			}
			System.out.println("Who is ready to start..??\tPlayer's name:");
			String Startingplayer = s.next();
			System.out.println("Game is depend on your Luck..So that");
			System.out.println("Specify the number of dices wanna to roll: ");
			int countofdice = s.nextInt();
			System.out.println("Dices values:");
			int[] dicevalue = new int[countofdice];
			for(int i =0;i<countofdice;i++) {
				dicevalue[i] = s.nextInt();
			}
			laddergame(NoOfplayers,Playersname,Startingplayer,countofdice,dicevalue);

		}

}



