/*
 * 	skokkr - a toolbox of mathematical utilities. Graph algorithms,
 * 	information theory, combinatorics, and more.
 *
 * 	Author: Christoffer Olling Back	<www.christofferback.com>
 *
 * 	Copyright (C) 2020 University of Copenhagen
 *
 *	This file is part of skokkr.
 *
 *	skokkr is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	skokkr is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with skokkr.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.backco.skokkr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Combinatorics {

  public static <T> List<List<T>> partition(Collection<T> col, int numOfPartitions) {

    List<List<T>> result = new ArrayList<>();
    List<T> input = new ArrayList<>();

    for (T o : col) {
      input.add(o);
    }

    if (numOfPartitions <= 0) {
      result.add(input);
      return result;
    }

    int s = col.size();
    int q = s > numOfPartitions ? s / numOfPartitions : 1;
    int r = s > numOfPartitions ? s % numOfPartitions : 0;

    int step = q;
    for (int i = 0, c = 1; i < s; i += step, c++) {
      step = c <= r ? q + 1 : q;
      result.add(input.subList(i, i + step));
    }

    return result;
  }

  public static <T> List<List<List<T>>> getPartitions(List<T> seq) throws Exception{
      throw new Exception("Not yet implemented");
  }
  /*
   * List<List<List<T>>> result = new ArrayList<>();
   *
   * for (int j = 1; j < seq.size(); j++) { // System.out.println("j: " + j);
   * List<Integer> initIndices = new ArrayList<>(); for (int i = 1; i <= j; i++) {
   * // System.out.println("i: " + i); initIndices.add(i); }
   *
   * Set<List<Integer>> partitionIndicesSet = getPartitionIndices(initIndices,
   * seq.size()); // System.out.println(" getting actual partitions..."); for
   * (List<Integer> partitionIndices : partitionIndicesSet) { List<List<T>>
   * partition = new ArrayList<>(); for (int i = 1; i < partitionIndices.size();
   * i++) { List<T> part = seq.subList(partitionIndices.get(i - 1),
   * partitionIndices.get(i)); partition.add(part); } result.add(partition); } }
   *
   * return result; }
   */

  /*
   * private static Set<Node<Integer>> buildIndexTrie(Trie<Integer> t,
   * Node<Integer> n, int depth, int numOfIndices, int length, int parentVal)
   * throws LabelTypeException, Exception {
   *
   * Set<Node<Integer>> endNodes = new HashSet<>();
   *
   * if (depth < numOfIndices) { for (Integer i = parentVal; i <= length -
   * numOfIndices + depth; i++) { Node<Integer> m = t.createNode(i, n);
   * endNodes.addAll(buildIndexTrie(t, m, depth + 1, numOfIndices, length, i +
   * 1)); } } else { endNodes.add(n); }
   *
   * return endNodes; }
   */

  public static Set<List<Integer>> getPartitionIndices(List<Integer> indices, int length) throws Exception{
    throw new Exception("Not yet implemented");
  }
  /*
   * if (indices.size() > 0) {
   *
   * Set<List<Integer>> result = new HashSet<>();
   *
   * Trie<Integer> indexTrie = new QIntTrie(); Node<Integer> root =
   * indexTrie.getRoot();
   *
   * Set<Node<Integer>> endNodes = buildIndexTrie(indexTrie, root, 0,
   * indices.size(), length, indices.get(0));
   *
   * for (Node<Integer> n : endNodes) { List<Integer> prefix =
   * indexTrie.getVisitingPrefix(n); List<Integer> resIndices = new ArrayList<>();
   * resIndices.add(0); for (Object e : prefix) { resIndices.add((Integer) e); }
   * resIndices.add(length); result.add(resIndices); }
   *
   * return result;
   *
   * } else { return null; } }
   */

  /*
   * public static Set<List<Integer>> getPartitionIndicesRecursive(List<Integer>
   * indices, int length, Map<Integer, Map<List<Integer>, Set<List<Integer>>>>
   * indicesMap) throws LabelTypeException, Exception {
   *
   * System.out.println("         length: " + length + " - indices: " + indices);
   *
   * if (indicesMap.containsKey(length)) { if
   * (indicesMap.get(length).containsKey(indices)) {
   *
   * System.out.println("         found in map!"); return
   * indicesMap.get(length).get(indices); } }
   *
   * System.out.println("         not found in map, computing...");
   *
   * Set<List<Integer>> result = getPartitionIndices(indices, length);
   *
   * Map<List<Integer>, Set<List<Integer>>> map = new HashMap<>();
   * map.put(indices, result); indicesMap.put(length, map);
   *
   * return result;
   *
   * }
   */

  /*
   * public static Set<List<Integer>> getPartitionIndicesRecursive(List<Integer>
   * indices, int length, int depth) throws LabelTypeException, Exception {
   *
   * for (int i = 0; i < depth; i++) { System.out.print(" "); }
   * System.out.println(depth + ": " + length + " - indices: " + indices);
   *
   * Set<List<Integer>> result = new HashSet<>(); List<Integer> resIndices = new
   * ArrayList<>(); resIndices.add(0);
   *
   * for (Integer i : indices) { if (i > 0) { resIndices.add(i); } else { return
   * null; } }
   *
   * resIndices.add(length); result.add(resIndices);
   *
   * for (int i = 0; i < indices.size(); i++) { List<Integer> newIndices = new
   * ArrayList<>();
   *
   * if (i < indices.size() - 1 && indices.get(i) + 1 != indices.get(i + 1) || i
   * == indices.size() - 1 && indices.get(i) + 1 < length) { for (int j : indices)
   * { newIndices.add(j); } newIndices.set(i, indices.get(i) + 1);
   * result.addAll(getPartitionIndicesRecursive(newIndices, length, depth + 1)); }
   * }
   *
   * return result; }
   */

}