import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task_281 {
	public static void main(String[] args) {
		final String outputPath = "OUTPUT.TXT";
		final Coin test = new Coin();
		try(final BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//-----------------------------------------------------------------------------
/*public*/ class Coin{
	//-----------------------------------------------------------------------------fields
	private int countOfTosses;
	private int countOfTails;
	private int result;
	//-----------------------------------------------------------------------------constructors
	/*public*/private Coin(final String path)
	{
		try(final Scanner input = new Scanner(Paths.get(path))) {
			//-----------------------------------------------------------------------------
			if(input.hasNext()) {
				//-----------------------------------------------------------------------------
				this.countOfTosses = input.nextInt(); //read data from file
				this.countOfTails = input.nextInt(); //read data from file
				//-----------------------------------------------------------------------------
				tossRecursive(1, 0, true);
				tossRecursive(1, 0, false);
			}
			//-----------------------------------------------------------------------------
			else {
				throw new IOException("File is empty!");
			}
			//-----------------------------------------------------------------------------
		}catch (IOException | NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/*public*/ Coin()
	{
		this("INPUT.TXT");
	}
	//-----------------------------------------------------------------------------methods for constructors
	private void tossRecursive(int counter, int counterOfTails, boolean side)
	{
		if(side) {
			counterOfTails++;
		}
		if(counter < this.countOfTosses) {
			tossRecursive(counter + 1, counterOfTails, false);
			tossRecursive(counter + 1, counterOfTails, true);
		}
		else {
			if(counterOfTails >= this.countOfTails) {
				result++;
			}
		}
	}
	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------methods
	@Override
	public String toString()
	{
		return String.valueOf(this.result);
	}
}