package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.InputBlock;
import eval.StorageEvaluator;
import exception.InvalidGroupException;
import exception.InvalidImageParameterException;
import exception.UnsupportedCommandException;

public class UserInput {
	
	List<String> usrInput1;
	List<String> usrInput2;
	InputBlock block;

	@Before
	public void setUp() throws Exception {
		
		usrInput1 = new ArrayList<>();
		usrInput1.add("JPG 2048 1024");
		usrInput1.add("J 5000 3000");
		usrInput1.add("G 1 2");
		usrInput1.add("JP2 1000 2000");
		usrInput1.add("BMP 2000 1000");
		
		block = new InputBlock();
		
	}

	@Test
	public void allTypesWithSimpleGroup() {
		
		block.parse(usrInput1);
		StorageEvaluator evaluator= new StorageEvaluator();
		int res = evaluator.evaluate(block);
		
		assertEquals(res, 5753091);
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void invalidJPG() {
		
		List<String> badJPG = new ArrayList<>();
		badJPG.add("JPG -1 1");
		
		block.parse(badJPG);
			
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void invalidBNP() {
		
		List<String> badBMP = new ArrayList<>();
		badBMP.add("BMP -1 1");
		
		block.parse(badBMP);
			
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void invalidJP2() {
		
		List<String> badJP2 = new ArrayList<>();
		badJP2.add("JP2 1.1 1");
		
		block.parse(badJP2);
		
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void JPGToofewArguments() {
		
		List<String> badJPG = new ArrayList<>();
		badJPG.add("JPG 100");
		
		block.parse(badJPG);
		
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void BMPToofewArguments() {
		
		List<String> badBMP = new ArrayList<>();
		badBMP.add("BMP");
		
		block.parse(badBMP);
		
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void JP2ToofewArguments() {
		
		List<String> badJP2 = new ArrayList<>();
		badJP2.add("JP2 10000000");
		
		block.parse(badJP2);
		
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void JPGfunnyImput() {
		
		List<String> badJPG = new ArrayList<>();
		badJPG.add("JPG hej hej hej");
		
		block.parse(badJPG);
		
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void BMPfunnyInput() {
		
		List<String> badBMP = new ArrayList<>();
		badBMP.add("BMP no no");
		
		block.parse(badBMP);
		
	}
	
	@Test(expected = InvalidImageParameterException.class)
	public void JP2funnyInput() {
		
		List<String> badJP2 = new ArrayList<>();
		badJP2.add("JP2 this should not work");
		
		block.parse(badJP2);
		
	}
	
	@Test(expected = UnsupportedCommandException.class)
	public void unsupportedCommand() {
		
		List<String> badCommand = new ArrayList<>();
		badCommand.add("MPEG 100 1000");
		
		block.parse(badCommand);

	}
	
	@Test(expected = InvalidGroupException.class)
	public void doubleMember() {
		
		usrInput1.add("G 2 3");
		block.parse(usrInput1);
	}
	
	@Test(expected = InvalidGroupException.class)
	public void uniMember() {
		
		usrInput1.add("G 3");
		block.parse(usrInput1);
	}
	
	

}
