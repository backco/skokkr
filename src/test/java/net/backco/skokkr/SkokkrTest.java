package net.backco.skokkr;

import static org.junit.Assert.assertEquals;
import net.backco.skokkr.Combinatorics;
import net.backco.skokkr.MinMax;
import net.backco.skokkr.Operations;
import net.backco.skokkr.SetUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SkokkrTest {

	int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
	int[] array2 = { 4, 5, 4, 6, 7, 8, 9, 9, 9 };
	String[] array3 = { "a", "b", "c", "d", "e", "f", "f" };
	String[] array4 = { "d", "d", "e", "f", "g", "h", "i", "j" };
	List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
	List<Integer> list2 = Arrays.asList(4, 5, 4, 6, 7, 8, 9, 9, 9);
	List<String> list3 = Arrays.asList("a", "b", "c", "d", "e", "f", "f");
	List<String> list4 = Arrays.asList("d", "d", "e", "f", "g", "h", "i", "j");
	Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
	Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
	Set<String> set3 = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
	Set<String> set4 = new HashSet<>(Arrays.asList("d", "e", "f", "g", "h", "i", "j"));

	@Test
	public void testMinMax() {
		Integer three = 3;
		Integer eleven = 11;
		assertEquals(three, MinMax.minimum(Arrays.asList(11, 9, 8, 7, 8, 11, 5, 3, 3)));
		assertEquals(eleven, MinMax.maximum(Arrays.asList(11, 9, 8, 7, 8, 11, 5, 3, 3)));
	}

	@Test
	public void testComplement() {
		Set<Integer> inter1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<?> inter2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
		assertEquals(inter1, SetUtils.complement(this.set1, this.list2));
		assertEquals(inter2, SetUtils.complement(this.list2, this.set3));
	}

	@Test
	public void testIntersection() {
		Set<Integer> inter1 = new HashSet<>(Arrays.asList(4, 5, 6, 7));
		// Set<?> inter2 = new HashSet<>();
		assertEquals(inter1, SetUtils.intersection(this.set1, this.list2));
		// assertEquals(inter2, SetUtils.intersection(this.list2, this.set3));
	}

	@Test
	public void testUnion() {
		Set<Integer> inter1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Set<?> inter2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9, "a", "b", "c", "d", "e", "f"));
		assertEquals(inter1, SetUtils.union(this.set1, this.list2));
		assertEquals(inter2, SetUtils.union(this.list2, this.set3));
	}

	@Test
	public void testPartition() {
		List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		for (int k = -3; k < 11; k++) {
			Combinatorics.partition(l, k);
		}

		List<Integer> m = Arrays.asList(1, 2, 3);
		for (int k = -3; k < 11; k++) {
			Combinatorics.partition(m, k);
		}

		List<Integer> n = Arrays.asList(1, 2);
		for (int k = -1; k < 4; k++) {
			Combinatorics.partition(n, k);
		}

		List<Integer> o = Arrays.asList(1);
		for (int k = -1; k < 4; k++) {
			Combinatorics.partition(o, k);
		}
	}

	/*
	@Test
	public void testGetIndicesPartitions() throws Exception {

		List<Object> seq = Arrays.asList("a", "b", "c", "d");
		for (List<List<Object>> partition : Combinatorics.getPartitions(seq)) {
			System.out.println(partition);
		}
	}
	 */

	/*
	@Test
	public void testIndicesPartitioning() throws Exception {

		List<Integer> indices = Arrays.asList(1, 2, 3);
		Set<List<Integer>> result;
		result = Combinatorics.getPartitionIndices(indices, 6);
		System.out.println("indicesPartitioning: " + result);
	}
	*/

	@Test
	public void testProduct() {

		double[] arr = { 0.5, 0.8, 0.25 };
		assertEquals(0.1, Operations.product(arr), 0);
	}
}
