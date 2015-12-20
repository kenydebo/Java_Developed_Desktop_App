/*
 * Purpose: SwingValidtor class used to validate text fields 
 * Author: Mark Poffenroth
 * Date: August 2015
 * Based on Murach Java Prograaming pp.491-2
 */

package gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import org.jdesktop.swingx.JXDatePicker;

public class SwingValidator {
    
    // Display validator message to user   
    private void showMessage(JTextComponent c, String message)
    {
        JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
    }
    
    
    // Check if input value is present
    public boolean isPresent(JTextComponent c, String fieldName)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, fieldName + " is a required field.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    
    
    public boolean checkinputlength(JTextComponent c, String fieldName, int size)
    {
     if (c.getText().length() > size)
        {
            showMessage(c, fieldName + " Maximum allowed input character is " + size + ".");
            c.requestFocusInWindow();
            return false;
        }
        return true;
        
        
    }
      
      
    public boolean isValidEmail(JTextComponent c, String fieldName)
    {
         Pattern pattern;
	 Matcher matcher;

	String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(c.getText().trim());          
        
        if (!matcher.matches())
        {
            showMessage(c, fieldName + " is not a valid Email .");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    
    public boolean isValidPhoneNumber(JTextComponent c, String fieldName)
    {
         Pattern pattern;
	 Matcher matcher;

	String PHONE_PATTERN = 
		"^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$";
        
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(c.getText().trim());        
        
        
        if (!matcher.matches())
        {
            showMessage(c, fieldName + " is not a Valid phone Number .");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    
    // Check if input value is an integer
    public boolean isInteger(JTextComponent c, String fieldName)
    {
        try
        {
            int i = Integer.parseInt(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, fieldName + " must be an integer.");
            c.requestFocusInWindow();
            return false;
        }
    }

    
    // Check if input value is a double
    public boolean isDouble(JTextComponent c, String fieldName)
    {
        try
        {
            double d = Double.parseDouble(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, fieldName + " must be a valid number.");
            c.requestFocusInWindow();
            return false;
        }
    }

    
    // Check if input value is a positive number
    public boolean isPositive(JTextComponent c, String fieldName)
    {
        double d = Double.parseDouble(c.getText());
        if (d < 0)
        {
            showMessage(c, fieldName + " must be a positive number.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

          
    // Check if input value1 is greater than input value2
    public boolean isGreaterThan(JTextComponent c, JTextComponent c2, String fieldName, String fieldName2)
    {
        double d = Double.parseDouble(c.getText());
        double d2 = Double.parseDouble(c2.getText());
        if (d2 > d)
        {
            showMessage(c, fieldName + " must be greater than " + fieldName2);
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
      

    // Check if input value is within specified min max number range
    public boolean isWithinRange(JTextComponent c, String fieldName, double min, double max)
    {
        //check that the agency commission is less than the base price
        double d = Double.parseDouble(c.getText());
        if (d < min || d > max)
        {
            showMessage(c, fieldName + " must be between " + min + " and " + max);
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

      
    // Check if input is a valid date format
    public static boolean isDate(JXDatePicker jdate, String fieldName) 
    {
        try {
            // Specify valid date format    
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            
            // Get date and format it
            Date date = jdate.getDate();
            String resultDateFrom = sdf.format(date);
            
            //System.out.println("Date: " + resultDateFrom);
            return true;
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, fieldName + " must be a valid date.");
            return false;
        }
    }
    
    
    // Check if JXDatePicker dates are valid
    public boolean isValidDate(Date startDate, Date endDate, String fieldName, String fieldName2)
    {
        // Check if start date is before end date
        if (startDate.after(endDate))
        {        
            JOptionPane.showMessageDialog(null, "Start date "+ startDate + " must be before \nEnd date " + endDate);
            return false;
        }
        return true;    
    } 
    
}