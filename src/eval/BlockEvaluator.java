package eval;
import main.InputHandler;

/**
 * This is an interface for classes which evaluate parsed user input
 * e.g estimate the total storage in bytes.
 * 
 * @author Hampus Carlsson
 *
 * @param <T>
 */
public interface BlockEvaluator<T> {
	
	public T evaluate(InputHandler handler);

}
