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

import java.util.List;

public class Operations {

  public static double product(double[] values) {

    double result = 1.0;

    for (int i = 0; i < values.length; i++) {

      result = result * values[i];
    }

    return result;
  }

  public static double sum(double[] values) {

    double result = 0.0;

    for (int i = 0; i < values.length; i++) {

      result = result + values[i];
    }

    return result;
  }

  public static double sum(int[] values) {

    double result = 0.0;

    for (int i = 0; i < values.length; i++) {

      result = result + values[i];
    }

    return result;
  }

  public static double sum(List<Double> values) {

    double result = 0.0;

    for (int i = 0; i < values.size(); i++) {

      result = result + values.get(i);
    }

    return result;
  }

  public static double log(double n, int base) {

    return Math.log(n) / Math.log(base);
  }

  public static double binaryLog(double n) {

    return log(n, 2);
  }

  // ROUNDING
  public static double round(double d, int p) {

    double m = Math.pow(10, p);
    return Math.round(d * m) / m;
  }

  public static double round(Number d, int p) {

    return round((double) d, p);
  }
}