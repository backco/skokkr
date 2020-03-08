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
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class GraphUtils {

    public static List<BitSet> adjacencyListsToMatrix(List<Set<Integer>> adjacencyLists) {

	List<BitSet> matrix = new ArrayList<>();

	int c = 1;
	int size = matrix.size();

	for (Collection<Integer> row : adjacencyLists) {

	    System.out.println("adjacencyListsToMatrix: " + c++ + " of " + size);
	    BitSet bitRow = new BitSet();

	    for (int i : row) {

		bitRow.set(i);
	    }

	    matrix.add(bitRow);
	}

	return matrix;
    }

    public static List<Set<Integer>> adjacencyMatrixToLists(List<BitSet> matrix) {

	List<Set<Integer>> lists = new ArrayList<>();

	int c = 1;
	int size = matrix.size();

	for (BitSet row : matrix) {

	    System.out.println("adjacencyMatrixToLists: " + c++ + " of " + size);
	    Set<Integer> rowSet = new HashSet<>();

	    for (int i = 0; i < row.size(); i++) {

		if (row.get(i)) {

		    rowSet.add(i);
		}
	    }

	    lists.add(rowSet);
	}
	return lists;
    }

    public static List<BitSet> transformToPathMatrix(List<BitSet> matrix) {

	List<BitSet> pathMatrix = MatrixUtils.cloneBitMatrix(matrix);

	// REMOVE SELF LOOPS
	for (int i = 0; i < pathMatrix.size(); i++) {

	    pathMatrix.get(i).set(i, false);
	}

	int size = pathMatrix.size();

	// compute path matrix
	for (int i = 0; i < size; i++) {

	    for (int j = 0; j < size; j++) {

		if (i == j) {

		    continue;
		}

		if (pathMatrix.get(j).get(i)) {

		    for (int k = 0; k < size; k++) {

			if (!pathMatrix.get(j).get(k)) {

			    pathMatrix.get(j).set(k, pathMatrix.get(i).get(k));
			}
		    }
		}
	    }
	}

	return pathMatrix;
    }

    public static List<BitSet> transitiveReduction(List<BitSet> pathMatrix) {

	List<BitSet> reducedMatrix = MatrixUtils.cloneBitMatrix(pathMatrix);

	int size = reducedMatrix.size();

	// transitively reduce
	for (int j = 0; j < size; j++) {

	    for (int i = 0; i < size; i++) {

		if (reducedMatrix.get(i).get(j)) {

		    for (int k = 0; k < size; k++) {

			if (reducedMatrix.get(j).get(k)) {

			    reducedMatrix.get(i).set(k, false);
			}
		    }
		}
	    }
	}

	return reducedMatrix;
    }

    public static Map<Integer, Set<Integer>> suffixTree(List<Set<Integer>> adjacencyLists) {

	Map<Integer, Set<Integer>> tree = new HashMap<>();

	for (int i = adjacencyLists.size() - 1; i >= 0; i--) {

	    System.out.println("Suffix tree - adjacency list row " + i + " of " + adjacencyLists.size());

	    Set<Integer> taIntSeq = new HashSet<>();
	    NavigableSet<Integer> frontier = new TreeSet<>();
	    frontier.add(i);

	    // int next;

	    while (!frontier.isEmpty()) {

		// next =
		frontier.pollFirst();

		// TODO: OUGHT TO WORK BACKWARDS
		for (int j : adjacencyLists.get(i)) {

		    // ONLY FUTURE EVENTS
		    if (j > i) {

			if (tree.containsKey(j)) {

			    taIntSeq.add(j);
			    taIntSeq.addAll(tree.get(j));
			} else {

			    taIntSeq.add(j);
			    frontier.add(j);
			}
		    }
		}

		tree.put(i, taIntSeq);
	    }
	}

	return tree;
    }
}