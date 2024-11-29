package tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import classes.Containers;

public class UnitTests {

	@Test
	void testWeight() {
		assertEquals(12000,Containers.totalWeight(8000,"small","pounds"));
	}
	@Test
	void testWeight2() {
		assertEquals(8000,Containers.totalWeight(5000,"medium","Kilos"));
	}
	@Test
	void testLimit() {
		assertEquals("Weight within limits.",Containers.WeightLimit(8000,"small","pounds"));
	}
	@Test
	void testLimit2() {
		assertEquals("Over the weight limit",Containers.WeightLimit(60000,"medium","Kilos"));
	}
}
