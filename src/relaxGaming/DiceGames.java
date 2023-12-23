package relaxGaming;

import java.util.Random;

// This class abstracts dice games. Win by getting at least a 6 on 4 rolls ("firstGame") or  double 6 on 24 rolls ("secondGame")
public class DiceGames {
	
	private Random rand = new Random();	
	
	/**Simulate a million games and print the results. Receives a String parameter representing the name of the game to test.*/
	public void simulate(String gameName) {
		simulate(gameName, 1_000_000);
	}
	
	//It's enough to switch this method to public to allow the insertion of a second integer parameter representing the number of simulations
	private void simulate(String gameName, int numSimulations) {

		int winCounter=0;
		
		if(gameName.equals("firstGame")) {
			
			for(int i=0; i<numSimulations; i++) {
				if(gameCase1()) //gamecase1() check out the logic of the first game and return true if you won
					winCounter++;
			}
		}
		
		if(gameName.equals("secondGame")) {
				
			for(int i=0; i<numSimulations; i++) {
				if(gameCase2()) //gamecase2() check out the logic of the second game and return true if you won
					winCounter++;
				}
			}
		
		printResult(numSimulations, winCounter, gameName);
	}
	
	//simulates rolling a die 4 times. If a six is ​​rolled it returns true, otherwise it returns false.
	private boolean gameCase1() {
		
		for (int i=0; i<4; i++) {
			int die = rand.nextInt(6)+1;
			if(die==6)
				return true;
		}
		return false;
	}
	
	//simulates rolling 2 dice 24 times. If a double six is ​​rolled it returns true, otherwise it returns false.
	private boolean gameCase2() {
		
		for (int i=0; i<24; i++) {
			int die1 = rand.nextInt(6)+1;
			int die2 = rand.nextInt(6)+1;
			if(die1==6 && die2==6)
				return true;
		}
		return false;
	}
	
	//Calculate and print the result of a simulation.
	private void printResult(int numSimulations, int winCounter, String gameName) {
		
		int profit = winCounter*2-numSimulations;
		double mean = (double) winCounter / numSimulations;
		double variance = mean * (1-mean);
		double standardDeviation = Math.sqrt(variance);
		
		System.out.printf("%d games simulated at the %s:\n", numSimulations, gameName);
		System.out.printf("You won %d times, and you lost %d times.\n", winCounter, (numSimulations - winCounter));
		System.out.printf("Total profit: $%d\n", profit);
		System.out.printf("Mean = %f\n", mean);
		System.out.printf("Variance = %f\n", variance);
		System.out.printf("Standard deviation = %f\n", standardDeviation);
		System.out.println();
	}
}