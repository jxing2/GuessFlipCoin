import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class GuessCoinFlip extends Observable{
	Random ran = new Random();
	private CoinSide flip()
	{
		return ran.nextInt(2)==1 ? CoinSide.Positive : CoinSide.Negative;
	}
	public void doExperiment()
	{
		CoinSide flip = flip();
		this.notifyObservers(flip);
		this.setChanged();
	}
	public static void main(String[] args)
	{
		GuessCoinFlip gcf = new GuessCoinFlip();
		//Guess_Rational rational = new Guess_Rational();
		Guess rational = new Guess_Rational();
		Guess stupid = new Guess_Stupid();
		
		gcf.addObserver((Observer)rational);
		gcf.addObserver((Observer)stupid);
		
		for(int i = 0 ; i <= 1000000; ++i)
		{
			gcf.doExperiment();
		}
		rational.showInfo();
		stupid.showInfo();
	}
}
