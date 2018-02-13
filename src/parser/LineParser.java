package parser;
import main.InputHandler;

/**
 * 
 * Interface used for defining parser for file types and commands.
 * 
 * @author Hampus Carlsson
 *
 */

public interface LineParser {
	public void parseAndExecute(String[] args, InputHandler handler);
	public boolean validate(String[] args, InputHandler handler); 
}
