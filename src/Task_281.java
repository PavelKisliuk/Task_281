import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task_281 {
	public static void main(String[] args) {
		Coin test = new Coin();
		try(final Formatter output = new Formatter("OUTPUT.TXT")) {
			output.format(test.toString());
		}catch (FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
		}
	}
}


class Coin{
	private int countOfTosses;
	private int countOfTails;
	private int result;

	public Coin(String path)
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

	public Coin()
	{
		this("INPUT.TXT");
	}

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

	@Override
	public String toString()
	{
		return String.valueOf(this.result);
	}
}