import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Cell extends JButton{

    private Date date;
    private boolean title;
    private Event event;

    public Cell(String label) {
        super(label);
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
     }

    public void asTitle(){
        this.title = true;
    }

    public boolean isTitle(){
        return title;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void currentMonth(boolean act) {
        if (act){
            setForeground(new Color(68,68,68));
        } else{
            setForeground(new Color(169,169,169));
        }
    }
    
    public Date getDate() {
    	return date;
    }
}
