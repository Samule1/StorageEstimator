package parser;
import main.InputBlock;

public interface LineParser {
	public void parseAndExecute(String[] args, InputBlock block);
	public boolean validate(String[] args, InputBlock block); 
}
