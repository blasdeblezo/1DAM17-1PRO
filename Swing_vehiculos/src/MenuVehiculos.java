import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MenuVehiculos extends JFrame {
	JTable tabla;
	JTextField modelo;
	JTextField potencia;
	JComboBox listaMotor;
	JComboBox listaMarca;

	public MenuVehiculos() {
		super("Lista de vehiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel texto;
		texto = new JLabel("Marca");
		panel.add(texto);
		listaMarca = new JComboBox();
		listaMarca.addItem("");

		panel.add(listaMarca);
		texto = new JLabel("Modelo");
		panel.add(texto);
		modelo = new JTextField();
		panel.add(modelo);
		texto = new JLabel("Motor");
		panel.add(texto);
		listaMotor = new JComboBox();
		leerlista();
		panel.add(listaMotor);

		listaMotor.addItem("");
		listaMotor.addItem("Gasolina");
		listaMotor.addItem("Diesel");
		listaMotor.addItem("Hibrido");
		listaMotor.addItem("Electrico");

		texto = new JLabel("Potencia");
		panel.add(texto);
		potencia = new JTextField();
		panel.add(potencia);

		c.add(panel);
		JPanel panel2 = new JPanel();

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		JButton boton;
		boton = new JButton("Agregar");
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaMarca.getSelectedItem().equals(null) || modelo.getText().equals("")
						|| listaMotor.getSelectedItem().equals(null) || potencia.getText().equals("")) {
					JOptionPane.showMessageDialog(MenuVehiculos.this,
							"No se puede agregar " + "porque no faltan datos.", "Guardar",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					DefaultTableModel model = (DefaultTableModel) tabla.getModel();
					model.addRow(new String[] { (String) listaMarca.getSelectedItem(), modelo.getText(),
							(String) listaMotor.getSelectedItem(), potencia.getText() });
				}

			}
		});
		panel2.add(boton);

		boton = new JButton("Eliminar");
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tabla.getSelectedRow()>=0) {
					DefaultTableModel model = (DefaultTableModel) tabla.getModel();
					model.removeRow(tabla.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(MenuVehiculos.this,
							"No se puede eliminar ya que " + "no se selecciono ninguna fila", " Eliminar",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		panel2.add(boton);
		boton = new JButton("Limpiar");
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listaMarca.setSelectedItem(null);
				listaMotor.setSelectedItem(null);
				potencia.setText(null);
				modelo.setText(null);
			}
		});
		panel2.add(boton);
		boton = new JButton("Guardar");
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int resultado = fc.showOpenDialog(c);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					BufferedWriter out = null;
					try {
						out = new BufferedWriter(new FileWriter(f));

						for (int i = 0; i < tabla.getRowCount(); i++) {
							for (int j = 0; j < tabla.getColumnCount(); j++) {
								out.write((String) tabla.getValueAt(i, j));
								if (j < tabla.getColumnCount() -1) {
			                        out.write("; ");
			                        }
							}
							out.newLine();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if (out != null)
							try {
								out.close();
							} catch (IOException e1) {

								e1.printStackTrace();
							}
					}
				}

			}
		});
		panel2.add(boton);
		panel.add(panel2);

		JPanel PTabla = new JPanel();

		tabla = new JTable(new DefaultTableModel(new String[] { "Marca", "Modelo", "Motor", "Potencia" }, 0));

		tabla.setFillsViewportHeight(true);
		PTabla.add(new JScrollPane(tabla));
		c.add(PTabla);
		pack();
	}

	private Object leerlista() {
		BufferedReader in = null;

		try {
			in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/marcas.txt")));
			String linea;
			while ((linea = in.readLine()) != null) {
				in.readLine();
				listaMarca.addItem(linea);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MenuVehiculos().setVisible(true);
			}

		});

	}

}
