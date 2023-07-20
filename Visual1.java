package proyectoFinal;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Visual1 extends JFrame {

    private JPanel contentPane;
    private ArrayList<Automovil> autos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Visual1 frame = new Visual1();
                    frame.setVisible(true);
                    frame.cargarDatosInventario();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Visual1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("Button.shadow"));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnConsultarPorTipo = new JButton("Consultar por Tipo");
        btnConsultarPorTipo.setBounds(129, 119, 170, 23);
        contentPane.add(btnConsultarPorTipo);
        btnConsultarPorTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTipo();
            }
        });

        JButton btnConsultarInventario = new JButton("Consultar Inventario");
        btnConsultarInventario.setBounds(129, 71, 170, 23);
        contentPane.add(btnConsultarInventario);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(129, 173, 170, 23);
        contentPane.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel lblNewLabel = new JLabel("MENU RANGE ROVER");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(129, 29, 170, 14);
        contentPane.add(lblNewLabel);
    }

    private void cargarDatosInventario() {
        autos = new ArrayList<>();
        autos.add(new TipoSport("Urban 4", 1398000, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagenes\\urban4.jpg"));
        autos.add(new TipoSport("Urban 2", 1390000, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagnes\\urban2.jpg"));
        autos.add(new TipoSport("Dinamic", 1890000, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagnes\\sportDinamic.jpg"));
        
        autos.add(new TipoDefender("Defender X Ingenium 3", 2822158, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagenes\\defenderx.jpg"));
        autos.add(new TipoDefender("LAND ROVER Defender 2023", 2849150, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagenes\\defender2023.jpg"));
        autos.add(new TipoDefender("Defender110", 1690000, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagnes\\defender110.jpg"));
        autos.add(new TipoDefender("First Edition", 1700900, "C:\\Users\\Tere Parra\\eclipse-workspace\\ProyectoFinal\\src\\proyectoFinal\\imagnes\\DefenderFirstEdition.jpg"));
    }

    private void mostrarTodos() {
        StringBuilder sb = new StringBuilder();
        sb.append("**** Lista Total de Automóviles ****\n");
        for (Automovil automovil : autos) {
            sb.append("Nombre: ").append(automovil.getNombre()).append("\n");
            sb.append("Tipo: ").append(automovil.getTipo()).append("\n");
            sb.append("Precio: ").append(automovil.getPrecio()).append("\n");
            //sb.append("Descripcion: ").append(automovil.descripcion()).append("\n");
            sb.append("\n");
        }
        mostrarVentana("Inventario", sb.toString());
    }

    private void mostrarTipo() {
        String tipo = JOptionPane.showInputDialog("Digite el tipo de auto (Defender / Sport): ");
        StringBuilder sb = new StringBuilder();
        sb.append(" **** Automóviles Tipo ").append(tipo).append(" ****\n");
        
       
               
        for (Automovil automovil : autos) {
        	
            if (automovil.getTipo().equalsIgnoreCase(tipo)) {
                sb.append("Nombre: ").append(automovil.getNombre()).append("\n");
                sb.append("Precio: ").append(automovil.getPrecio()).append("\n");
                sb.append("Descripcion: ").append(automovil.descripcion()).append("\n");
             
                sb.append("\n");
            }
        }
        mostrarVentana("Consulta por Tipo", sb.toString());
    }

    private void mostrarVentana(String titulo, String contenido) {
        JFrame frame = new JFrame(titulo);
        frame.setBounds(100, 100, 450, 300);
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(null);

        JTextArea textArea = new JTextArea(contenido);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 250, 200);
        panel.add(scrollPane);

        // Mostrar la imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(280, 10, 150, 200);
        String imagenPath = autos.get(0).getImagen(); // Obtener la ruta de la imagen
        ImageIcon imagen = new ImageIcon(imagenPath);
        Image img = imagen.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        imagenLabel.setIcon(new ImageIcon(img));
        panel.add(imagenLabel);

        frame.setVisible(true);
    }
}
