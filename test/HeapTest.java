import static org.junit.Assert.;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

	private Heap maxHeap;

	@Before
	public void setUp() throws Exception {
		maxHeap = new Heap();
	}

	@Test
	public void testInsertDelete() {
		for (int i = 0; i <= 10; i++) {
			maxHeap.insert(new TreeNode(i));
		}

		for (int i = 10; i >= 0; i--){
			assertTrue(i == maxHeap.delete().getValue());
		}
	}
}
