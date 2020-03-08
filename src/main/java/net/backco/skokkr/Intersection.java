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

import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;

public class Intersection implements TIntProcedure {

  TIntSet otherSet;
  TIntSet result;

  public Intersection(TIntSet big, TIntSet intersection) {
    this.otherSet = big;
    this.result = intersection;
  }

  @Override
  public boolean execute(int arg0) {
    if (this.otherSet.contains(arg0)) {
      this.result.add(arg0);
    }
    return true;
  }
}