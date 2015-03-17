
import javax.swing.JTextField;

public class MyTextField extends JTextField {

    public void append(String txt) {
        String current = this.getText();
        this.setText(current + txt);
    }

}
