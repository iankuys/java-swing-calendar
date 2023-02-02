import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellActionListeners implements ActionListener {

	public void actionPerformed(ActionEvent e) {
        // your handle button click code
		Cell o = (Cell)e.getSource();
		String name = o.getName();
		
		if (!o.isTitle()) {
			
		}
    }
}
