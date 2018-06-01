package Reloj;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EjercicioReloj extends JFrame{
	private JTextField hh;
	private JTextField mm;
	private JTextField info;
	public EjercicioReloj(){
		super("Validar hora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel c=new JPanel();
			getContentPane().add(c);;
			c.setBorder(BorderFactory.createEmptyBorder(20,20,20,20 ));
		c.setLayout(new BorderLayout());

		JPanel p= new JPanel();
		p.add(new JLabel("Introduce una hora(hh:mm"));
		p.add(hh=new JTextField(2));
		p.add(new JLabel(":"));
		p.add(mm=new JTextField(2));
	
		c.add(p, BorderLayout.NORTH);
		JButton b=new JButton("OK");
		c.add(b);
		b.addActionListener(new ActionListener(){
		

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if((boolean) validarHora(hh.getText(), mm.getText())){
					info.setText("Hora correcta");
				}
				else  info.setText("Hora incorrecta");
				
			}

			
			
		});
		c.add(info=new JTextField(), BorderLayout.SOUTH);
		info.setEditable(false);
		pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
			new Runnable(){

					@Override
					public void run() {
						new EjercicioReloj().setVisible(true);
						
			}		
		});
	}

	public static Object validarHora(String hh, String mm) {
		try{int h= Integer.parseInt(hh);
		int m= Integer.parseInt(mm);
		
		return h>=0 && h<=23 && m>=0 && m<=59;
			
		}catch(NumberFormatException e){
			return false;
		}
		
	}

}
