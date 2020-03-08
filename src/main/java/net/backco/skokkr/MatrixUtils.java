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
import java.util.List;

public class MatrixUtils {

  public static List<BitSet> cloneBitMatrix(List<BitSet> matrix) {

    List<BitSet> clone = new ArrayList<>();

    for (BitSet row : matrix) {

      clone.add(BitSetUtils.cloneBitSet(row));
    }

    return clone;
  }

  public static List<BitSet> randomBitMatrix(int size, double sparsity) {

    List<BitSet> matrix = new ArrayList<>();

    for (int i = 0; i < size; i++) {

      matrix.add(BitSetUtils.randomBitSet(size, sparsity));
    }

    return matrix;
  }
}