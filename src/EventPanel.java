import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventPanel extends JPanel {

   private JLabel titleLabel;
   private JTextField titleTextField;
   private JLabel startTimeLabel;
   private JTextField startTimeTextField;
   private JLabel endTimeLabel;
   private JTextField endTimeTextField;

   public EventPanel() {
      // set the layout to grid layout
      setLayout(new GridLayout(3, 2));

      // add components to the panel
      titleLabel = new JLabel("Title:");
      add(titleLabel);
      titleTextField = new JTextField();
      add(titleTextField);

      startTimeLabel = new JLabel("Start Time:");
      add(startTimeLabel);
      startTimeTextField = new JTextField();
      add(startTimeTextField);

      endTimeLabel = new JLabel("End Time:");
      add(endTimeLabel);
      endTimeTextField = new JTextField();
      add(endTimeTextField);
   }

   public String getTitle() {
      return titleTextField.getText();
   }

   public String getStartTime() {
      return startTimeTextField.getText();
   }

   public String getEndTime() {
      return endTimeTextField.getText();
   }
}
