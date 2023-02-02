import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserPage extends JFrame{

    private JTextField regionField;
    private JButton newUserBtn;
    private JComboBox<User> userListDropdown;
    private JTextField nameField;
	private ArrayList<User> users;
    
    public UserPage() {
    	
    	users = new ArrayList<User>();
    	
        setTitle("User Page");
        setSize(400, 200);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,3,0,0));
        
        JLabel userNameLabel = new JLabel("Enter your name: ");
        mainPanel.add(userNameLabel);
        
        JPanel namePanel_1 = new JPanel();
        mainPanel.add(namePanel_1);
        
        nameField = new JTextField(15);
        namePanel_1.add(nameField);
        
        JLabel regionLabel = new JLabel("Select a region: ");
        mainPanel.add(regionLabel);
        
        JPanel namePanel = new JPanel();
        mainPanel.add(namePanel);
        
        regionField = new JTextField(15);
        namePanel.add(regionField);
        
        newUserBtn = new JButton("Submit");
        namePanel.add(newUserBtn);
        
        newUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String region = regionField.getText();
                String userName = nameField.getText();
                User newUser = new User(region, userName);
                userListDropdown.addItem(newUser);
                
                if (!users.contains(newUser)) {
                	
                	users.add(newUser);
                }
            }
        });

        JLabel userListLabel = new JLabel("Select a user: ");
        mainPanel.add(userListLabel);
        
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(2,1,0,0));
        mainPanel.add(userPanel);
        
        userListDropdown = new JComboBox<>();
        userPanel.add(userListDropdown);
        
        JButton existingUserBtn = new JButton("Choose User");
        
        existingUserBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                User selectedUser = (User) userListDropdown.getSelectedItem();
                System.out.println("Selected user: " + selectedUser);
                
                CalendarPage calendarPage = new CalendarPage(selectedUser);
                calendarPage.setVisible(true);
        	}
        });
        
        userPanel.add(existingUserBtn);

        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        UserPage userPage = new UserPage();
        userPage.setVisible(true);
    }
}
