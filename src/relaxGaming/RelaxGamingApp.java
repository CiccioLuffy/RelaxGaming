package relaxGaming;

public class RelaxGamingApp {

	public static void main(String[] args) {
		
		DiceGames diceGames = new DiceGames();
		
		diceGames.simulate("firstGame");
		diceGames.simulateHighPrecision("firstGame");
		
		diceGames.simulate("secondGame");
		diceGames.simulateHighPrecision("secondGame");
		
	    }
	}