package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

/**
 * 
 * @author Group 21 
 * Class in which is for testing the methods of the Range Class 
 * Using boundaries and edge cases to create the following test cases for each method.
 *
 */
public class RangeTest {
    private Range exampleRange; //The example range which was given to us 
    private Range testRange1; //Created this range to test other functionalities of the test range.
    private Range testExpandRange; //This is the expanded range in use for the expand method. 
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    //This calls the setUpBefore even the class exists and does nothing. 
    }

    @Before
    public void setUp() throws Exception {
    	//Before each test case this object of range is ready for us to use. 
    	exampleRange = new Range(-1, 1);    	
    }

    @Test
    public void centralValueShouldBeZero() {
    	//This is testing the centralValue function which checks what the value between
    	//the range is. 
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d); //This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
    }

	@Test
    public void expandTestLowerMarginInt() { //This is created the see if the range will change or not. 
		//Using the margin value in percentages which will return the lower bound as an integer. 
    	testRange1 = new Range(2, 6); //This is creating the range for testing purposes. 
    	testExpandRange = Range.expand(testRange1, 0.25, 0.5); //Using the expand method to pass in the test
    	//range and the margin values
    	assertEquals("The lower margin range will be 1", 
    			1, testExpandRange.getLowerBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
    }
	
	@Test
    public void expandTestUpperMarginInt() {//This is created the see if the range will change or not. 
		//Using the margin value in percentages which will return the upper bound as an integer. 
    	testRange1 = new Range(2, 6); //This is creating the range for testing purposes. 
    	testExpandRange = Range.expand(testRange1, 0.25, 0.5);//Using the expand method to pass in the test
    	//range and the margin values
    	assertEquals("The upper margin range will be 8", 
    			8, testExpandRange.getUpperBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
    }
	
	@Test
    public void expandTestLowerMarginDecimal() {//This is created the see if the range will change or not. 
		//Using the margin value in percentages which will return the lower bound as a decimal. 
    	testRange1 = new Range(2, 6); //This is creating the range for testing purposes. 
    	testExpandRange = Range.expand(testRange1, 0.33, 0.44);//Using the expand method to pass in the test
    	//range and the margin values
    	assertEquals("The lower margin range will be 1", 
    			0.68, testExpandRange.getLowerBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
    }
	
	@Test
    public void expandTestUpperMarginDecimal() {//This is created the see if the range will change or not. 
		//Using the margin value in percentages which will return the upper bound as a decimal. 
    	testRange1 = new Range(2, 6); //This is creating the range for testing purposes. 
    	testExpandRange = Range.expand(testRange1, 0.33, 0.44);//Using the expand method to pass in the test
    	//range and the margin values
    	assertEquals("The upper margin range will be 8", 
    			7.76, testExpandRange.getUpperBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
    }
	
	@Test
	public void expandToInlcudeInsideUpperRange(){ //This test is for testing the expanding the range
		//which will include 5 in the range and making sure the upper value bound is still the same. 
		Range tempRange1 = Range.expandToInclude(new Range (4, 6), 5); //This is creating the test range for this test.
		assertEquals("The upper value will be 6", 
				6, tempRange1.getUpperBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
	}
	
	@Test
	public void expandToInlcudeInsideLowerRange(){//This test is for testing the expanding the range
		//which will include 5 in the range and making sure the lower value bound is still the same. 
		Range tempRange1 = Range.expandToInclude(new Range (4, 6), 5);//This is creating the test range for this test.
		assertEquals("The upper value will be 4", 
				4, tempRange1.getLowerBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
	}
	
	@Test
	public void expandToInlcudeOutsideUpperRange(){ //This test is for testing the expanding the range
		//which will include 7 in the range and making sure the upper value bound reflects the updated range. 
		Range tempRange1 = Range.expandToInclude(new Range (4, 6), 7);//This is creating the test range for this test.
		assertEquals("The upper value will be 7", 
				7, tempRange1.getUpperBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
	}

	@Test
	public void expandToInlcudeOutsideLowerRange(){//This test is for testing the expanding the range
		//which will include 1 in the range and making sure the lower value bound reflects the updated range. 
		Range tempRange3 = Range.expandToInclude(new Range (3,7), 1);//This is creating the test range for this test.
		assertEquals("The lower value will be 1", 
				1, tempRange3.getLowerBound(), .000000001d);//This is the assert statement which takes 
        //in the expected, the actual value and the eplison for the standard deviation. 
	}
    
    @After
    public void tearDown() throws Exception {
    	//Tear down function for after running the tests it does nothing. 
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	//Do nothing once the class is over running the cases in the SUT 
    }
}
