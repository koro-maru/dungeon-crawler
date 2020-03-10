/*package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GUI extends JPanel {
	private static final long serialVersionUID = 2105636824083083324L;
	
	 private JTextArea textArea;
	 private JTextField textField;
	 private JButton submitButton;
	public GUI(){
    	JFrame startFrame = new JFrame("ASTRO");
        JPanel container = new JPanel();
        JPanel start = new JPanel(new GridBagLayout());
        JPanel mainArea = new JPanel(new FlowLayout());
        JButton startButton = new JButton("Start");
        submitButton  = new JButton("Submit");
        JButton backButton = new JButton("Back");
        CardLayout card = new CardLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel label = new JLabel("ASTRO");
        label.setFont(new Font("Serif", Font.PLAIN, 200));
        
        container.setLayout(card);
        c.gridx = 0;
        c.gridy = 0;
        start.add(label, c);
        
        c.gridy = 1;
        start.add(startButton, c);

       textArea = new JTextArea(60, 80);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createCompoundBorder(
                textArea.getBorder(), 
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField = new JTextField(20);

        mainArea.add(textArea);
        mainArea.add(textField);
        mainArea.add(submitButton);
        //Second parameter identifier string
        container.add(start, "1");
        container.add(mainArea, "2");

        card.show(container, "1");

        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                card.show(container, "2");
               }    
        });

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                card.show(container, "1");
               }    
        });
        
        startFrame.add(container);
        startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startFrame.pack();
        startFrame.setVisible(true);
        startFrame.setSize(1000,1000);
    }

   @Override
    public void paintComponent(Graphics g){
    	 Image img;
    			try {
					img = ImageIO.read(new File("persona.jpg"));
					super.paintComponent(g);
				    g.drawImage(img, 0, 0, null);
				    System.out.println("Paint component was called");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Paint component failed.");
				}
}
   
   public JTextArea getTextArea() {
	   return textArea;
   }

   public void setTextArea(String str) {
	   textArea.append(str);
   }
   public JTextField getTextField() {
	   return textField;
   }
   void addSubmitListener(ActionListener submitListener) {
	   submitButton.addActionListener(submitListener);
   }
   
   void errorMessage(String errorMessage) {
	   JOptionPane.showMessageDialog(this, errorMessage);
   }
}
*/

