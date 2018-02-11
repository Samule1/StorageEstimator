package eval;
import main.InputBlock;

public interface BlockEvaluator<T> {
	
	public T evaluate(InputBlock block);

}
