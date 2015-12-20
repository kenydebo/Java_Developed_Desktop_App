/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.table.*;
import javax.swing.*;
import java.text.NumberFormat;

/**
* Display a <tt>Number</tt> in a table cell in the format defined by  
* {@link NumberFormat#getCurrencyInstance()}, and aligned to the right.
*/
final class CurrencyRenderer extends DefaultTableCellRenderer {
  
  CurrencyRenderer() { 
    setHorizontalAlignment(SwingConstants.RIGHT);  
  }
  
  @Override public void setValue(Object aValue) {
    Object result = aValue;
    if ((aValue != null) && (aValue instanceof Number)) {
      Number numberValue = (Number)aValue;
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      result = formatter.format(numberValue.doubleValue());
    } 
    super.setValue(result);
  }   
} 