package net.backco.skokkr;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;

public class SetUtils {

  public static Set<?> complement(Collection<?> colA, Collection<?> colB) {

    Set<? super Object> complement = new HashSet<>();

    complement.addAll(colA);
    complement.removeAll(colB);

    return complement;
  }

  public static <T> Set<T> intersection(Collection<T> colA, Collection<T> colB) {

    Set<T> intersection = new HashSet<>();

    if (colA != null && colB != null) {

      Collection<T> small;
      Collection<T> big;

      if (colA.size() < colB.size()) {

        small = colA;
        big = colB;
      } else {

        small = colB;
        big = colA;
      }

      for (T element : small) {

        if (big.contains(element)) {

          intersection.add(element);
        }
      }
    }

    return intersection;
  }

  public static TIntSet intersectionForEach(TIntSet colA, TIntSet colB) {

    TIntSet intersection = new TIntHashSet();

    if (colA != null && colB != null) {

      TIntSet small;
      TIntSet big;

      if (colA.size() < colB.size()) {

        small = colA;
        big = colB;
      } else {

        small = colB;
        big = colA;
      }
      small.forEach(new Intersection(big, intersection));
    }
    return intersection;
  }

  public static TIntHashSet intersectionIterator(TIntHashSet colA, TIntHashSet colB) {

    TIntHashSet intersection = new TIntHashSet();

    if (colA != null && colB != null) {

      TIntHashSet small;
      TIntHashSet big;

      if (colA.size() < colB.size()) {

        small = colA;
        big = colB;
      } else {

        small = colB;
        big = colA;
      }

      TIntIterator iter = small.iterator();

      while (iter.hasNext()) {

        int x = iter.next();

        if (big.contains(x)) {

          intersection.add(x);
        }
      }
    }
    return intersection;
  }

  public static Set<?> union(Collection<?> colA, Collection<?> colB) {

    Set<? super Object> union = new HashSet<>();

    union.addAll(colA);
    union.addAll(colB);

    return union;
  }

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
}