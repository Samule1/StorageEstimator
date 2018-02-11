

public interface LineParser<T,U> {
	public T parseAndExecute(String[] args, InputBlock block);
	public U validate(String[] args, InputBlock block); 
}
