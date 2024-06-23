package SQL;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Quang Huy
 */
public class DataValidator {

    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
        if (field.getText().trim().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();

        }else{
            field.setBackground(Color.white);
        }
    }
    
     public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
         String password = new String(field.getPassword());
         if (password.trim().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();

        }else{
            field.setBackground(Color.white);
        }
    }

   
}
