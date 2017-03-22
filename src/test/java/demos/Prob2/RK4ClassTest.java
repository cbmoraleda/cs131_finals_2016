package webarebears.prob2branch;

import static org.junit.Assert.*;
import org.junit.Test;

public class RK4ClassTest {
	RK4Class rk = new RK4Class();
	Double a = 0d;
    Double b = 18d;
    Double h = 0.25d;
    Double x1 = Math.PI/2d;
    Double y1 = 0d;
    Double [][] rk4Answers = rk.RK4("y", "-(0.16/0.5)*y - (9.81/1.2)*sin(x)", a, b, h, x1, y1);

	@Test
	public void testCheckInitialVal() {
		assertEquals(a,rk4Answers[0][0]);
		assertEquals(b,rk4Answers[0][72]);
		assertEquals(x1,rk4Answers[1][0]);
		assertEquals(y1,rk4Answers[2][0]);
	}
	
	@Test
	public void testStepSize() {
		assertEquals(rk4Answers[0][5]-rk4Answers[0][4], 0.25, 0.01);
	}
	
	@Test
	public void testAnswers() {
		assertEquals(rk4Answers[1][1], 1.32269759043, 0.00000000001);
		assertEquals(rk4Answers[2][1], -1.94861565612, 0.00000000001);
		assertEquals(rk4Answers[1][72], 0.075698291528, 0.00000000001);
		assertEquals(rk4Answers[2][72], 0.0631967885205, 0.00000000001);
	}
}