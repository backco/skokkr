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

import java.util.Collection;

public class MinMax {

  public static <T extends Comparable<T>> T maximum(Collection<T> values) {

    T m = null;

    for (T v : values) {

      if (m == null || v.compareTo(m) > 0) {

        m = v;
      }
    }

    return m;
  }

  public static double maximum(double[] values) {

    double m = values[0];

    for (double v : values) {

      if (v > m) {

        m = v;
      }
    }

    return m;
  }

  public static float maximum(float[] values) {

    float m = values[0];

    for (float v : values) {

      if (v > m) {

        m = v;
      }
    }

    return m;
  }

  public static int maximum(int[] values) {

    int m = values[0];

    for (int v : values) {

      if (v > m) {

        m = v;
      }
    }

    return m;
  }

  public static <T extends Comparable<T>> T minimum(Collection<T> values) {

    T m = null;

    for (T v : values) {

      if (m == null || v.compareTo(m) < 0) {

        m = v;
      }
    }

    return m;
  }

  public static double minimum(double[] values) {

    double m = values[0];

    for (double v : values) {

      if (v < m) {

        m = v;
      }
    }

    return m;
  }

  public static float[] minimum(float[] values, int n) {

    n = n > values.length ? values.length : n;

    float[] result = new float[n];

    for (int i = 0; i < n; i++) {

      result[i] = Float.MAX_VALUE;
    }

    for (float v : values) {

      for (int i = 0; i < n; i++) {

        if (v < result[i]) {

          for (int j = n - 1; j > i; j--) {

            result[j] = result[j - 1];
          }

          result[i] = v;
          break;
        }
      }
    }

    return result;
  }

  public static float minimum(float[] values) {

    float m = values[0];

    for (float v : values) {

      if (v < m) {

        m = v;
      }
    }

    return m;
  }

  public static int minimum(int[] values) {

    int m = values[0];

    for (int v : values) {

      if (v < m) {

        m = v;
      }
    }

    return m;
  }
}