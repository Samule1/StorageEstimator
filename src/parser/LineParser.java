package parser;
import main.InputHandler;

public interface LineParser {
	public void parseAndExecute(String[] args, InputHandler handler);
	public boolean validate(String[] args, InputHandler handler); 
}
