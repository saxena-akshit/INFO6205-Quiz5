import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RedBlackBSTTest {

    private RedBlackBST<String, Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new RedBlackBST<>();
        bst.put("S", 1);
        bst.put("E", 2);
        bst.put("A", 3);
        bst.put("R", 4);
        bst.put("C", 5);
        bst.put("H", 6);
        bst.put("X", 7);
        bst.put("M", 8);
        bst.put("P", 9);
        bst.put("L", 10);
    }

    @Test
    public void testSize() {
        assertEquals(10, bst.size(), "Size should be 10 after inserting 10 elements");
    }

    @Test
    public void testGet() {
        assertEquals(2, bst.get("E"), "Value for key 'E' should be 2");
        assertEquals(8, bst.get("M"), "Value for key 'M' should be 8");
        assertNull(bst.get("Z"), "Value for key 'Z' should be null as it doesn't exist");
    }

    @Test
    public void testContains() {
        assertTrue(bst.contains("A"), "Tree should contain key 'A'");
        assertFalse(bst.contains("Z"), "Tree should not contain key 'Z'");
    }

    @Test
    public void testDeleteMin() {
        bst.deleteMin();
        assertEquals(9, bst.size(), "Size should be 9 after deleting minimum key");
        assertNull(bst.get("A"), "Minimum key 'A' should be deleted");
    }

    @Test
    public void testDeleteMax() {
        bst.deleteMax();
        assertEquals(9, bst.size(), "Size should be 9 after deleting maximum key");
        assertNull(bst.get("X"), "Maximum key 'X' should be deleted");
    }

    @Test
    public void testDelete() {
        bst.delete("M");
        assertEquals(9, bst.size(), "Size should be 9 after deleting key 'M'");
        assertNull(bst.get("M"), "Key 'M' should be deleted");
    }

    @Test
    public void testIsEmpty() {
        RedBlackBST<String, Integer> emptyBst = new RedBlackBST<>();
        assertTrue(emptyBst.isEmpty(), "New tree should be empty");
        emptyBst.put("A", 1);
        assertFalse(emptyBst.isEmpty(), "Tree should not be empty after insertion");
    }

    @Test
    public void testHeight() {
        int height = bst.height();
        assertTrue(height >= 0, "Height should be non-negative");
    }

    @Test
    public void testBalance() {
        assertTrue(bst.isBalanced(), "Tree should be balanced after insertions");
        bst.delete("M");
        assertTrue(bst.isBalanced(), "Tree should remain balanced after deletion");
    }
}
