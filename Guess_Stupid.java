import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class Guess_Stupid implements Observer, Guess {
	int total = 0;
	int yes = 0;
	int no = 0;
	
	CoinSide myGuess;
	int myGuessCount = 0;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		++total;
		myGuess = guess();
		CoinSide cf = (CoinSide)arg;
		if(cf.equals(CoinSide.Positive))
			++yes;
		else
			++no;
		if(cf.equals(myGuess))
		{
			++myGuessCount;
		}
	}
	Random ran = new Random();
	@Override
	public CoinSide guess() {
		// TODO Auto-generated method stub
		//return CoinSide.Positive;
		return ran.nextInt(2)==1 ? CoinSide.Positive : CoinSide.Negative;
	}



	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Stupid : Total: " + total + ", yes: " + yes + ", no: " + no + ", Guess_Right: " 
				+ myGuessCount + ", rate: " + ((double)myGuessCount/ total));
	}
	
}
