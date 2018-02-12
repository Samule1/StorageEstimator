package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.InputHandler;
import eval.StorageEvaluator;
import exception.InvalidGroupException;
import exception.InvalidImageParameterException;
import exception.UnsupportedCommandException;

public class AllTests {
	
	List<String> usrInput1;
	List<String> usrInput2;
	List<String> usrInput3;
	List<String> usrInput4;
	
	InputHandler block;

	@Before
	public void setUp() throws Exception {
		
		usrInput1 = new ArrayList<>();
		usrInput1.add("JPG 2048 1024");
		usrInput1.add("J 5000 3000");
		usrInput1.add("G 1 2");
		usrInput1.add("JP2 1000 2000");
		usrInput1.add("BMP 2000 1000");
		
		usrInput2 = new ArrayList<>();
		usrInput2.add("BMP 3333 3333");
		usrInput2.add("BMP 333 333");
		usrInput2.add("BMP 33 33");
		usrInput2.add("BMP 3 3");
		usrInput2.add("G 1 2 3 4");
		
		usrInput3 = new ArrayList<>();
		usrInput3.add("JPEG2000 10 10");
		usrInput3.add("JPEG2000 3333 1222");
		usrInput3.add("BMP 1 999");
		usrInput3.add("BMP 5056 1000");
		usrInput3.add("JP2 100 200");
		usrInput3.add("JP2 999 999");
		usrInput3.add("JPG 1000 1222");
		usrInput3.add("JPG 2323 2323");
		usrInput3.add("G 2 8");
		usrInput3.add("G 6 7");
		
		usrInput4 = new ArrayList<>();
		usrInput4.add("BMP 3333 3333");
		usrInput4.add("JP2 333 333");
		usrInput4.add("JPG 33 33");
		usrInput4.add("J 3 3");
		usrInput4.add("G 1 2 3 4");
		
		block = new InputHandler();
		
	}

	@Test
	public void allTypesWithSimpleGroup() {
		
		block.parse(usrInput1);
		StorageEvaluator evaluator= new StorageEvaluator();
		int res = evaluator.evaluate(block);
		
		assertEquals(res, 5753091);
	}
	
	@Test
	public void oneGroupHomogeneous() {
		
		block.parse(usrInput2);
		StorageEvaluator evaluator= new StorageEvaluator();
		int res = evaluator.evaluate(block);
		
		assertEquals(res, 7674659);
	}
	
	@Test
	public void oneGroupHetrogeneous() {
		
		block.parse(usrInput4);
		StorageEvaluator evaluator= new StorageEvaluator();
		int res = evaluator.evaluate(block);
		
		assertEquals(res, 7612354);
	}
	
	@Test
	public void multipleGroups() {
		
		usrInput1.add("G 3 4");
		block.parse(usrInput1);
		StorageEvaluator evaluator= new StorageEvaluator();
		int res = evaluator.evaluate(block);
		
		assertEquals(res, 4645839);
	}
	
	@Test
	public void mixedTypesAndMultipleGroups() {
		
		block.parse(usrInput3);
		StorageEvaluator evaluator= new StorageEvaluator();
		int res = evaluator.evaluate(block);
		
		assertEquals(res, 8199023);
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
