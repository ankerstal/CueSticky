package extra;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class QuestionDialog extends MessageDialog 
                            implements ActionListener {
  private Panel buttons = new Panel();
  private String answer;

  public QuestionDialog(Frame parent, String question, String[] answers) {
    super(parent, question, true);
    initButtons(answers);
  }
/*
  public QuestionDialog(Dialog parent, String question, String[] answers) { 
    super(parent, question, true);  // Java 1.2
    initButtons(answers);
  }
*/
  private void initButtons(String[] answers) {
    for (int i=0; i<answers.length; i++) {
      Button b = new Button(answers[i]);
      buttons.add(b);  // FlowLayout
      b.addActionListener(this);
    }
    add("South", buttons);
    pack();
    setResizable(false);
    addWindowListener(wl);
  }

  public String getAnswer() {
    return answer;
  }
  
  public void actionPerformed(ActionEvent e) {
   answer = e.getActionCommand();  // ger texten på knappen
   setVisible(false);
  }

 WindowListener wl = new WindowAdapter() {
   public void windowActivated(WindowEvent e) {
     // låt den vänstra knappen hamna i fokus
     buttons.getComponents()[0].requestFocus();
   }
 };  
}   
