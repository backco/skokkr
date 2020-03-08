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

import java.util.BitSet;
import java.util.List;

public class Out {

  public static void printBitSet(BitSet bs) {

    for (int i = 0; i < bs.length(); i++) {

      System.out.print(bs.get(i) ? "1 " : "0 ");
    }
    System.out.println("");
  }

  public static String bitSetAsString(BitSet bs) {

    String out = "";

    for (int i = 0; i < bs.length(); i++) {

      out += bs.get(i) ? "1 " : "0 ";
    }

    return out;
  }

  public static void printBitMatrix(List<BitSet> matrix) {

    for (BitSet row : matrix) {

      printBitSet(row);
    }
  }
}