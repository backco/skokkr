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
import java.util.List;
import java.util.Set;

public class Encoding {

  public static List<Integer> deltaEncoding(Set<Integer> originalData) {

    List<Integer> encoding = new ArrayList<>();
    encoding.addAll(originalData);

    encoding.sort((x, y) -> x.compareTo(y));

    for (int i = encoding.size() - 1; i > 0; i--) {

      int delta = encoding.get(i) - encoding.get(i - 1);
      encoding.set(i, delta);
    }

    return encoding;
  }

  public static List<Integer> deltaDecoding(List<Integer> encoding) {

    List<Integer> decoding = new ArrayList<>();
    decoding.addAll(encoding);

    for (int i = 0; i < decoding.size() - 1; i++) {

      int orig = decoding.get(i) + decoding.get(i + 1);
      decoding.set(i + 1, orig);
    }

    return decoding;
  }
}