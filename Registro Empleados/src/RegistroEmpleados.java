import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistroEmpleados extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField fechaNacimientoField;
    private JButton guardarButton;
    private JLabel listaEmpleadosLabel;
    private ArrayList<String> empleados;

    public RegistroEmpleados() {
        empleados = new ArrayList<>();
        crearInterfaz();
    }

    private void crearInterfaz() {
        setTitle("Registro de Empleados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField(20);
        
        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento (DD/MM/YYYY):");
        fechaNacimientoField = new JTextField(15);
        
        guardarButton = new JButton("Guardar");
        listaEmpleadosLabel = new JLabel("Lista de Empleados:");

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEmpleado();
            }
        });

        add(nombreLabel);
        add(nombreField);
        add(apellidoLabel);
        add(apellidoField);
        add(fechaNacimientoLabel);
        add(fechaNacimientoField);
        add(guardarButton);
        add(listaEmpleadosLabel);

        setVisible(true);
    }

    private void guardarEmpleado() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String fechaNacimiento = fechaNacimientoField.getText();

        if (!nombre.isEmpty() && !apellido.isEmpty() && !fechaNacimiento.isEmpty()) {
            String empleado = "Nombre: " + nombre + ", Apellido: " + apellido + ", Fecha de Nacimiento: " + fechaNacimiento;
            empleados.add(empleado);
            mostrarListaEmpleados();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }

    private void mostrarListaEmpleados() {
        StringBuilder lista = new StringBuilder("<html>Lista de Empleados:<br>");
        for (String empleado : empleados) {
            lista.append(empleado).append("<br>");
        }
        lista.append("</html>");
        listaEmpleadosLabel.setText(lista.toString());
    }

    private void limpiarCampos() {
        nombreField.setText("");
        apellidoField.setText("");
        fechaNacimientoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroEmpleados());
    }
}