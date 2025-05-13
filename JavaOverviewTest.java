import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JavaOverviewTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	void testExercise1() {
		JavaOverview.exercise1();
		assertEquals("The sum is: 62790"+System.lineSeparator(), outContent.toString());
	}

	@Test
	void testExercise2() {
		JavaOverview.exercise2();
		Scanner s = new Scanner(outContent.toString());
		assertEquals("HB", s.nextLine());
		assertEquals("HB", s.nextLine());
		assertEquals("a1", s.nextLine());
		assertEquals("a1", s.nextLine());
		assertEquals("a1", s.nextLine());
		assertEquals("1a", s.nextLine());
		s.close();
	}

	@Test
	void testFirstLongerShorter() {
		try {
			Method m = JavaOverview.class.getDeclaredMethod("firstLongerShorter", String.class, String.class);

			Throwable thrown;
			thrown = assertThrows(InvocationTargetException.class, () -> m.invoke(null, "", "Test"));
			assertThat(thrown.getCause(), instanceOf(IllegalArgumentException.class));
			thrown = assertThrows(InvocationTargetException.class, () -> m.invoke(null, "Test", ""));
			assertThat(thrown.getCause(), instanceOf(IllegalArgumentException.class));
			thrown = assertThrows(InvocationTargetException.class, () -> m.invoke(null, null, "Test"));
			assertThat(thrown.getCause(), instanceOf(IllegalArgumentException.class));
			thrown = assertThrows(InvocationTargetException.class, () -> m.invoke(null, "Test", null));
			assertThat(thrown.getCause(), instanceOf(IllegalArgumentException.class));

			assertEquals("xs", m.invoke(null, "x x x x x x x x x x x x x x x x x x x x x x x x s x s sdasf dsfsdf sdf sdf sdfewfasf fsakkkasdfkwa o93 2", "sad"));
			assertEquals("\n\t", m.invoke(null, "\taddasdad \n\n we", "\n \t\n\n\n\t\tx x x x x x x x x x x x x x x x x x x x x x x x s x s sdasf dsfsdf sdf sdf sdfewfasf fsakkkasdfkwa o93 2"));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Exception " + e);
		}
		assertEquals("", outContent.toString(), "firstLongerShorter should not produce console output");
	}

	@Test
	void testExercise3() {
		JavaOverview.exercise3();
		assertEquals("1, 2, 3, 4, 6, 7, 8, 9, 10, 5"+System.lineSeparator(), outContent.toString());
	}

	@Test
	void testMoveToEnd() {
		try {
			Method m = JavaOverview.class.getDeclaredMethod("moveToEnd", int[].class, int.class);
			int[] oneToTen = new int[] {1,2,3,4,5,6,7,8,9,10};
			m.invoke(null, oneToTen, 0);
			assertArrayEquals(oneToTen, new int[] {2,3,4,5,6,7,8,9,10,1});
			m.invoke(null, oneToTen, 9);
			assertArrayEquals(oneToTen, new int[] {2,3,4,5,6,7,8,9,10,1});
			m.invoke(null, oneToTen, 1);
			assertArrayEquals(oneToTen, new int[] {2,4,5,6,7,8,9,10,1,3});
			m.invoke(null, oneToTen, 8);
			assertArrayEquals(oneToTen, new int[] {2,4,5,6,7,8,9,10,3,1});
			m.invoke(null, oneToTen, 2);
			assertArrayEquals(oneToTen, new int[] {2,4,6,7,8,9,10,3,1,5});
			m.invoke(null, oneToTen, 7);
			assertArrayEquals(oneToTen, new int[] {2,4,6,7,8,9,10,1,5,3});
			m.invoke(null, oneToTen, 3);
			assertArrayEquals(oneToTen, new int[] {2,4,6,8,9,10,1,5,3,7});
			m.invoke(null, oneToTen, 6);
			assertArrayEquals(oneToTen, new int[] {2,4,6,8,9,10,5,3,7,1});
			m.invoke(null, oneToTen, 4);
			assertArrayEquals(oneToTen, new int[] {2,4,6,8,10,5,3,7,1,9});
			m.invoke(null, oneToTen, 5);
			assertArrayEquals(oneToTen, new int[] {2,4,6,8,10,3,7,1,9,5});

			int[] shorter = new int[] {10000,-243,32,367845};
			m.invoke(null, shorter, 2);
			assertArrayEquals(shorter, new int[] {10000,-243,367845, 32});
			m.invoke(null, shorter, 3);
			assertArrayEquals(shorter, new int[] {10000,-243,367845, 32});
			m.invoke(null, shorter, 0);
			assertArrayEquals(shorter, new int[] {-243,367845, 32, 10000});
			m.invoke(null, shorter, 1);
			assertArrayEquals(shorter, new int[] {-243,32, 10000, 367845});

			int[] duplicates = new int[] {1,2,3,1,2,3,4,4,3,2};
			m.invoke(null, duplicates, 0);
			assertArrayEquals(duplicates, new int[] {2,3,1,2,3,4,4,3,2,1});
			m.invoke(null, duplicates, 2);
			assertArrayEquals(duplicates, new int[] {2,3,2,3,4,4,3,2,1,1});
			m.invoke(null, duplicates, 2);
			assertArrayEquals(duplicates, new int[] {2,3,3,4,4,3,2,1,1,2});
			m.invoke(null, duplicates, 5);
			assertArrayEquals(duplicates, new int[] {2,3,3,4,4,2,1,1,2,3});
			m.invoke(null, duplicates, 7);
			assertArrayEquals(duplicates, new int[] {2,3,3,4,4,2,1,2,3,1});
			m.invoke(null, duplicates, 1);
			assertArrayEquals(duplicates, new int[] {2,3,4,4,2,1,2,3,1,3});

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Exception " + e);
		}
		assertEquals("", outContent.toString(), "moveToEnd should not produce console output");
	}

	@Test
	void testExercise4() {
		JavaOverview.exercise4();
		Scanner s = new Scanner(outContent.toString());
		assertEquals("9", s.nextLine());
		assertEquals("9", s.nextLine());
		assertEquals("28", s.nextLine());
		assertEquals("28", s.nextLine());
		assertEquals("406", s.nextLine());
		assertEquals("406", s.nextLine());
		s.close();
	}

	@Test
	void testRecursiveSeq() {
		assertThrows(IllegalArgumentException.class, () -> JavaOverview.recursiveSeq(-30));
		assertThrows(IllegalArgumentException.class, () -> JavaOverview.recursiveSeq(-5));
		assertThrows(IllegalArgumentException.class, () -> JavaOverview.recursiveSeq(-1));

		assertEquals(1,JavaOverview.recursiveSeq(0));
		assertEquals(2,JavaOverview.recursiveSeq(1));
		assertEquals(3,JavaOverview.recursiveSeq(2));
		assertEquals(4,JavaOverview.recursiveSeq(3));
		assertEquals(6,JavaOverview.recursiveSeq(4));
		assertEquals(9,JavaOverview.recursiveSeq(5));
		assertEquals(13,JavaOverview.recursiveSeq(6));
		assertEquals(19,JavaOverview.recursiveSeq(7));
		assertEquals(28,JavaOverview.recursiveSeq(8));
		assertEquals(41,JavaOverview.recursiveSeq(9));
		assertEquals(60,JavaOverview.recursiveSeq(10));
		assertEquals(88,JavaOverview.recursiveSeq(11));
		assertEquals(129,JavaOverview.recursiveSeq(12));
		assertEquals(189,JavaOverview.recursiveSeq(13));
		assertEquals(277,JavaOverview.recursiveSeq(14));
		assertEquals(406,JavaOverview.recursiveSeq(15));
		assertEquals(595,JavaOverview.recursiveSeq(16));
		assertEquals(872,JavaOverview.recursiveSeq(17));
		assertEquals(1278,JavaOverview.recursiveSeq(18));
		assertEquals(1873,JavaOverview.recursiveSeq(19));
		assertEquals(2745,JavaOverview.recursiveSeq(20));
		assertEquals(4023,JavaOverview.recursiveSeq(21));
		assertEquals(5896,JavaOverview.recursiveSeq(22));
		assertEquals(8641,JavaOverview.recursiveSeq(23));
		assertEquals(12664,JavaOverview.recursiveSeq(24));
		assertEquals(18560,JavaOverview.recursiveSeq(25));
		assertEquals(27201,JavaOverview.recursiveSeq(26));
		assertEquals(39865,JavaOverview.recursiveSeq(27));
		assertEquals(58425,JavaOverview.recursiveSeq(28));
		assertEquals(85626,JavaOverview.recursiveSeq(29));
		assertEquals(125491,JavaOverview.recursiveSeq(30));
		assertEquals(183916,JavaOverview.recursiveSeq(31));
		assertEquals(269542,JavaOverview.recursiveSeq(32));
		assertEquals(395033,JavaOverview.recursiveSeq(33));
		assertEquals(578949,JavaOverview.recursiveSeq(34));
		assertEquals(848491,JavaOverview.recursiveSeq(35));
		assertEquals(1243524,JavaOverview.recursiveSeq(36));
		assertEquals(1822473,JavaOverview.recursiveSeq(37));
		assertEquals(2670964,JavaOverview.recursiveSeq(38));
		assertEquals(3914488,JavaOverview.recursiveSeq(39));
		assertEquals(5736961,JavaOverview.recursiveSeq(40));
		assertEquals(8407925,JavaOverview.recursiveSeq(41));
		assertEquals(12322413,JavaOverview.recursiveSeq(42));
		assertEquals(18059374,JavaOverview.recursiveSeq(43));
		assertEquals(26467299,JavaOverview.recursiveSeq(44));
		assertEquals(38789712,JavaOverview.recursiveSeq(45));
		assertEquals(56849086,JavaOverview.recursiveSeq(46));
		assertEquals(83316385,JavaOverview.recursiveSeq(47));
		assertEquals(122106097,JavaOverview.recursiveSeq(48));
		assertEquals(178955183,JavaOverview.recursiveSeq(49));

	}

	@Test
	void testDynamicSeq() {
		assertThrows(IllegalArgumentException.class, () -> JavaOverview.dynamicSeq(-30));
		assertThrows(IllegalArgumentException.class, () -> JavaOverview.dynamicSeq(-5));
		assertThrows(IllegalArgumentException.class, () -> JavaOverview.dynamicSeq(-1));

		assertEquals(1L,JavaOverview.dynamicSeq(0));
		assertEquals(2L,JavaOverview.dynamicSeq(1));
		assertEquals(3L,JavaOverview.dynamicSeq(2));
		assertEquals(4L,JavaOverview.dynamicSeq(3));
		assertEquals(6L,JavaOverview.dynamicSeq(4));
		assertEquals(9L,JavaOverview.dynamicSeq(5));
		assertEquals(13L,JavaOverview.dynamicSeq(6));
		assertEquals(19L,JavaOverview.dynamicSeq(7));
		assertEquals(28L,JavaOverview.dynamicSeq(8));
		assertEquals(41L,JavaOverview.dynamicSeq(9));
		assertEquals(60L,JavaOverview.dynamicSeq(10));
		assertEquals(88L,JavaOverview.dynamicSeq(11));
		assertEquals(129L,JavaOverview.dynamicSeq(12));
		assertEquals(189L,JavaOverview.dynamicSeq(13));
		assertEquals(277L,JavaOverview.dynamicSeq(14));
		assertEquals(406L,JavaOverview.dynamicSeq(15));
		assertEquals(595L,JavaOverview.dynamicSeq(16));
		assertEquals(872L,JavaOverview.dynamicSeq(17));
		assertEquals(1278L,JavaOverview.dynamicSeq(18));
		assertEquals(1873L,JavaOverview.dynamicSeq(19));
		assertEquals(2745L,JavaOverview.dynamicSeq(20));
		assertEquals(4023L,JavaOverview.dynamicSeq(21));
		assertEquals(5896L,JavaOverview.dynamicSeq(22));
		assertEquals(8641L,JavaOverview.dynamicSeq(23));
		assertEquals(12664L,JavaOverview.dynamicSeq(24));
		assertEquals(18560L,JavaOverview.dynamicSeq(25));
		assertEquals(27201L,JavaOverview.dynamicSeq(26));
		assertEquals(39865L,JavaOverview.dynamicSeq(27));
		assertEquals(58425L,JavaOverview.dynamicSeq(28));
		assertEquals(85626L,JavaOverview.dynamicSeq(29));
		assertEquals(125491L,JavaOverview.dynamicSeq(30));
		assertEquals(183916L,JavaOverview.dynamicSeq(31));
		assertEquals(269542L,JavaOverview.dynamicSeq(32));
		assertEquals(395033L,JavaOverview.dynamicSeq(33));
		assertEquals(578949L,JavaOverview.dynamicSeq(34));
		assertEquals(848491L,JavaOverview.dynamicSeq(35));
		assertEquals(1243524L,JavaOverview.dynamicSeq(36));
		assertEquals(1822473L,JavaOverview.dynamicSeq(37));
		assertEquals(2670964L,JavaOverview.dynamicSeq(38));
		assertEquals(3914488L,JavaOverview.dynamicSeq(39));
		assertEquals(5736961L,JavaOverview.dynamicSeq(40));
		assertEquals(8407925L,JavaOverview.dynamicSeq(41));
		assertEquals(12322413L,JavaOverview.dynamicSeq(42));
		assertEquals(18059374L,JavaOverview.dynamicSeq(43));
		assertEquals(26467299L,JavaOverview.dynamicSeq(44));
		assertEquals(38789712L,JavaOverview.dynamicSeq(45));
		assertEquals(56849086L,JavaOverview.dynamicSeq(46));
		assertEquals(83316385L,JavaOverview.dynamicSeq(47));
		assertEquals(122106097L,JavaOverview.dynamicSeq(48));
		assertEquals(178955183L,JavaOverview.dynamicSeq(49));
		assertEquals(262271568L,JavaOverview.dynamicSeq(50));
		assertEquals(384377665L,JavaOverview.dynamicSeq(51));
		assertEquals(563332848L,JavaOverview.dynamicSeq(52));
		assertEquals(825604416L,JavaOverview.dynamicSeq(53));
		assertEquals(1209982081L,JavaOverview.dynamicSeq(54));
		assertEquals(1773314929L,JavaOverview.dynamicSeq(55));
		assertEquals(2598919345L,JavaOverview.dynamicSeq(56));
		assertEquals(3808901426L,JavaOverview.dynamicSeq(57));
		assertEquals(5582216355L,JavaOverview.dynamicSeq(58));
		assertEquals(8181135700L,JavaOverview.dynamicSeq(59));
		assertEquals(11990037126L,JavaOverview.dynamicSeq(60));
		assertEquals(17572253481L,JavaOverview.dynamicSeq(61));
		assertEquals(25753389181L,JavaOverview.dynamicSeq(62));
		assertEquals(37743426307L,JavaOverview.dynamicSeq(63));
		assertEquals(55315679788L,JavaOverview.dynamicSeq(64));
		assertEquals(81069068969L,JavaOverview.dynamicSeq(65));
		assertEquals(118812495276L,JavaOverview.dynamicSeq(66));
		assertEquals(174128175064L,JavaOverview.dynamicSeq(67));
		assertEquals(255197244033L,JavaOverview.dynamicSeq(68));
		assertEquals(374009739309L,JavaOverview.dynamicSeq(69));
		assertEquals(548137914373L,JavaOverview.dynamicSeq(70));
		assertEquals(803335158406L,JavaOverview.dynamicSeq(71));
		assertEquals(1177344897715L,JavaOverview.dynamicSeq(72));
		assertEquals(1725482812088L,JavaOverview.dynamicSeq(73));
		assertEquals(2528817970494L,JavaOverview.dynamicSeq(74));
		assertEquals(3706162868209L,JavaOverview.dynamicSeq(75));
		assertEquals(5431645680297L,JavaOverview.dynamicSeq(76));
		assertEquals(7960463650791L,JavaOverview.dynamicSeq(77));
		assertEquals(11666626519000L,JavaOverview.dynamicSeq(78));
		assertEquals(17098272199297L,JavaOverview.dynamicSeq(79));
		assertEquals(25058735850088L,JavaOverview.dynamicSeq(80));
		assertEquals(36725362369088L,JavaOverview.dynamicSeq(81));
		assertEquals(53823634568385L,JavaOverview.dynamicSeq(82));
		assertEquals(78882370418473L,JavaOverview.dynamicSeq(83));
		assertEquals(115607732787561L,JavaOverview.dynamicSeq(84));
		assertEquals(169431367355946L,JavaOverview.dynamicSeq(85));
		assertEquals(248313737774419L,JavaOverview.dynamicSeq(86));
		assertEquals(363921470561980L,JavaOverview.dynamicSeq(87));
		assertEquals(533352837917926L,JavaOverview.dynamicSeq(88));
		assertEquals(781666575692345L,JavaOverview.dynamicSeq(89));
		assertEquals(1145588046254325L,JavaOverview.dynamicSeq(90));
		assertEquals(1678940884172251L,JavaOverview.dynamicSeq(91));
		assertEquals(2460607459864596L,JavaOverview.dynamicSeq(92));
		assertEquals(3606195506118921L,JavaOverview.dynamicSeq(93));
		assertEquals(5285136390291172L,JavaOverview.dynamicSeq(94));
		assertEquals(7745743850155768L,JavaOverview.dynamicSeq(95));
		assertEquals(11351939356274689L,JavaOverview.dynamicSeq(96));
		assertEquals(16637075746565861L,JavaOverview.dynamicSeq(97));
		assertEquals(24382819596721629L,JavaOverview.dynamicSeq(98));
		assertEquals(35734758952996318L,JavaOverview.dynamicSeq(99));
	}

	@Test
	void testExercise5() {
		JavaOverview.exercise5();
		assertEquals("Maximum value: 201"+System.lineSeparator()+"Average value: 8.688524590163935"+System.lineSeparator(), outContent.toString());
	}

	@Test
	void testExercise5DifferentFile() {
		File original = new File("numbers.txt");
		File copy = new File("numbers.cpy");
		original.renameTo(copy);

		PrintStream nums = null;
		try {
			nums = new PrintStream(new File("numbers.txt"));
			nums.println(-34);
			nums.println(-12312);
			nums.println(-200);
			nums.println(-3);
			nums.println(-145);
			nums.println(-57);
			nums.println(-9494);
			nums.println(-90909);
			nums.close();

			JavaOverview.exercise5();
			assertEquals("Maximum value: -3"+System.lineSeparator()+"Average value: -14144.25"+System.lineSeparator(), outContent.toString());
		} catch (FileNotFoundException e) {
			fail("Exception " + e);
		} finally {
			if(nums != null) nums.close();

			original = new File("numbers.txt");
			original.delete();
			copy = new File("numbers.cpy");
			copy.renameTo(new File("numbers.txt"));
		}
	}

	@Test
	void testExercise5NoFile() {
		File original = new File("numbers.txt");
		File copy = new File("numbers.cpy");
		original.renameTo(copy);

		try {
			JavaOverview.exercise5();
			assertEquals("The file \"numbers.txt\" does not exist. Exiting."+System.lineSeparator(), outContent.toString());
		} finally {
			copy = new File("numbers.cpy");
			copy.renameTo(new File("numbers.txt"));
		}
	}

	@Test
	void testExercise6() {
		JavaOverview.exercise6();
		Scanner s = new Scanner(outContent.toString());
		assertEquals("Employee 1 earns $330.00 for 40 hours of work.", s.nextLine());
		assertEquals("Employee 1 earns $214.50 for 26 hours of work.", s.nextLine());
		assertEquals("Employee 2 earns $604.00 for 40 hours of work.", s.nextLine());
		s.close();
	}
}
