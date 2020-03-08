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

import java.util.List;

import net.backco.skokkr.Operations;

public class InformationTheory {

  public static double information(double p) throws IllegalArgumentException {

    double result = 0.0;

    if (p < 0 || p > 1.0) {

      throw new IllegalArgumentException(
          "Probability value must be between 0 and 1. Received input: " + p);
    } else if (p == 0.0) {

      result = 0.0;

    } else {

      result = -Operations.binaryLog(p);
    }

    return result;
  }

  public static double entropy(List<Double> probDist) {

    double[] probDistArr = new double[probDist.size()];

    for (int i = 0; i < probDist.size(); i++) {

      probDistArr[i] = probDist.get(i);
    }

    return entropy(probDistArr);
  }

  public static double entropy(double[] probDist) throws IllegalArgumentException {

    double result = 0.0;

    for (double p : probDist) {

      result += p * information(p);
    }
    return result;
  }

  public static double entropySafe(double[] probDist) throws IllegalArgumentException {

    double result = 0.0;

    double sum = 0.0;

    for (double p : probDist) {
      sum += p;
    }

    if (Operations.round(sum, 4) != 1.0) {
      throw new IllegalArgumentException(
          "Invalid probability distribution: does not sum to 1.0. Sums to " + sum);
    } else {

      for (double p : probDist) {

        result += p * information(p);
      }
      return result;
    }
  }

  public static double entropyRawCounts(int[] counts, int total) {

    if (total <= 0) {

      throw new IllegalArgumentException();
    }

    double result = 0.0;

    for (double c : counts) {

      double p = (double) c / total;
      result += p * information(p);
    }
    return result;
  }
}