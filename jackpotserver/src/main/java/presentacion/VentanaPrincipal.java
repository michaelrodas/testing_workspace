package presentacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal {
	private Modelo modelo;
	private Controlador controlador;

	// Various GUI components and info
	public  JFrame mainFrame = null;
	public  JTextArea chatText = null;
	public  JTextField chatLine = null;
	public  JLabel statusBar = null;
	public  JTextField ipField = null;
	public  JTextField portField = null;
	public  JButton connectButton = null;
	public  JButton disconnectButton = null;
	public JPanel buttonPane = null;
	public JPanel pane = null;
	public JPanel optionsPane = null;
	public JPanel tablePane = null;
	public JScrollPane tableScrollPane = null;
	public JPanel mainPane = null;
	
	// Connection info
	public  String hostIP = "localhost";
	public  int port = 1234;
	public  boolean isHost = true;
	public DefaultTableModel modeloTabla;
	public JTable tablaDatos;

	public VentanaPrincipal(Modelo modelo) {
		this.modelo = modelo;
		initGUI();
	}

	private JPanel initOptionsPane() {
		// Create an options pane
		optionsPane = new JPanel(new GridLayout(4, 1));

		// IP address input
		pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pane.add(new JLabel("Host IP:"));
		ipField = new JTextField(10);
		ipField.setText(hostIP);
//		ipField.setEditable(true);
		ipField.setEnabled(false);
		pane.add(ipField);
		optionsPane.add(pane);

		// Port input
		pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pane.add(new JLabel("Port:"));
		portField = new JTextField(10);
//		portField.setEditable(true);
		portField.setText((new Integer(port)).toString());
		portField.setEnabled(false);
		pane.add(portField);
		optionsPane.add(pane);

		// Host/guest option
		pane = new JPanel(new GridLayout(1, 2));
		optionsPane.add(pane);

		// Connect/disconnect buttons
		buttonPane = new JPanel(new GridLayout(1, 2));

		connectButton = new JButton("Connect");
		connectButton.setMnemonic(KeyEvent.VK_C);
		connectButton.setActionCommand("connect");
		connectButton.addActionListener(getControlador());
		connectButton.setEnabled(true);
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setMnemonic(KeyEvent.VK_D);
		disconnectButton.setActionCommand("disconnect");
		disconnectButton.addActionListener(getControlador());
		disconnectButton.setEnabled(false);
		buttonPane.add(connectButton);
		buttonPane.add(disconnectButton);
		optionsPane.add(buttonPane);

		return optionsPane;
	}

	private void initGUI() {
		// Set up the status bar
		statusBar = new JLabel();
		statusBar.setText("Offline");

		// Set up the options pane
		optionsPane = initOptionsPane();
		String[] columnNames = { "Machine", "triunfos", "creditos", "dinero" };
		modeloTabla = new DefaultTableModel(null,columnNames);
		tablaDatos = new JTable(modeloTabla);
		// Set up the chat pane
		tablePane = new JPanel(new BorderLayout());
		tableScrollPane = new JScrollPane(tablaDatos,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		tablePane.add(tablePane, BorderLayout.SOUTH);
		tableScrollPane.setAutoscrolls(true);
		tableScrollPane.setViewportView(tablaDatos);
		tablePane.add(tableScrollPane, BorderLayout.CENTER);
		tablePane.setPreferredSize(new Dimension(200, 200));
		
		// Set up the main pane
		mainPane = new JPanel(new BorderLayout());
		mainPane.add(statusBar, BorderLayout.SOUTH);
		mainPane.add(optionsPane, BorderLayout.WEST);
		mainPane.add(tablePane, BorderLayout.CENTER);

		// Set up the main frame
		mainFrame = new JFrame("Simple Jackpot Server");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setContentPane(mainPane);
		mainFrame.setSize(mainFrame.getPreferredSize());
		mainFrame.setLocation(200, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	private Controlador getControlador() {
        if(controlador == null){
            controlador = new Controlador(this);
        }
        return controlador;
    }

	public void addFilaTabla(Object[] fila) {
		modeloTabla.addRow(fila);
		tablaDatos.scrollRectToVisible(tablaDatos.getCellRect(tablaDatos.getRowCount(), 0, true));
	}
}
