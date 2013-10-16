/*
 c  RunVSE.java
 c
 c  Copyright (C) 2000, 2008 Kurt Motekew
 c
 c  This program is free software; you can redistribute it and/or modify
 c  it under the terms of the GNU General Public License as published by
 c  the Free Software Foundation; either version 2 of the License, or
 c  (at your option) any later version.
 c
 c  This program is distributed in the hope that it will be useful,
 c  but WITHOUT ANY WARRANTY; without even the implied warranty of
 c  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 c  GNU General Public License for more details.
 c
 c  You should have received a copy of the GNU General Public License along
 c  with this program; if not, write to the Free Software Foundation, Inc.,
 c  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

import com.motekew.vse.servm.ISimModel;

/**
 * This program was built to run simulations implementing models from the
 * Vehicle Simulation Environment Library.  Such models implement the 
 * <code>ISimModel</code> interface.
 * <P>
 * Currently, an argument list is not supported - this might be a design
 * enhancement for the future....
 */ 
public class RunVSE {
  /**
   * @param args   The full path name (including package name, such as "com.foo.bar")
   *               to a class that is to be instantiated and run.
   *               
   * @author       Kurt Motekew
   * @since        20081014
   *               
   */
  public static void main(String[] args) {
      // Need to supply the class name - nothing else currently supported
    if (args.length == 1) {
      try {
          // Get Class from name using new fancy Generics stuff
        Class<? extends ISimModel> cModel = Class.forName(args[0]).asSubclass(ISimModel.class);
        ISimModel model = cModel.newInstance();
        model.launch();
      } catch(ClassNotFoundException cnfe) {
        System.out.println("Class not found:  " + cnfe);
      } catch(InstantiationException ie) {
        System.out.println("Can't instantiate class:  " + ie);
      } catch(IllegalAccessException iae) {
        System.out.println("Not allowed access to class:  " + iae);
      }
    } else {
      System.out.println("Correct usage is:  java RunVSE <model_name>");
      System.out.println("Where <model_name> is the class name, including full package path");
    }

  }

}
