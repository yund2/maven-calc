package pi.video;

import org.junit.Test;

import junit.framework.TestCase;

public class Test1 extends TestCase {
	
	double[] testValues1 = {1920, 1080, 24, 50, 52, 16, 44100};
	@Test
	public void testToCalculate1() {
		assertTrue(Calculate.toCalculate(testValues1) == 1297.4431738257408);
	}

}
