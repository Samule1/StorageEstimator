package parser;
import main.InputBlock;

public interface LineParser<U> {
	public void parseAndExecute(String[] args, InputBlock block);
	public U validate(String[] args, InputBlock block); 
}
