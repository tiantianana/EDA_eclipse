package examples.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RussianTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void mult() {
		assertEquals(0*5, Russian.mult(0, 5));
		assertEquals(2*5, Russian.mult(2, 5));
	}
}
