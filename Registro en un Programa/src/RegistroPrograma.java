import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroPrograma {
    private JFrame frame;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JRadioButton masculinoButton;
    private JRadioButton femeninoButton;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JCheckBox javascriptCheckBox;
    private JComboBox<String> cargoComboBox;
    private JComboBox<String> estadoComboBox;

    public RegistroPrograma() {
        frame = new JFrame("Registro de Programa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 2));

        // Nombre
        frame.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        frame.add(nombreField);

        // Apellido
        frame.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        frame.add(apellidoField);

        // Género
        frame.add(new JLabel("Género:"));
        ButtonGroup generoGroup = new ButtonGroup();
        masculinoButton = new JRadioButton("Masculino");
        femeninoButton = new JRadioButton("Femenino");
        generoGroup.add(masculinoButton);
        generoGroup.add(femeninoButton);
        JPanel generoPanel = new JPanel();
        generoPanel.add(masculinoButton);
        generoPanel.add(femeninoButton);
        frame.add(generoPanel);

        // Lenguajes de programación
        frame.add(new JLabel("Lenguajes de programación:"));
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        javascriptCheckBox = new JCheckBox("JavaScript");
        JPanel lenguajesPanel = new JPanel();
        lenguajesPanel.add(javaCheckBox);
        lenguajesPanel.add(pythonCheckBox);
        lenguajesPanel.add(javascriptCheckBox);
        frame.add(lenguajesPanel);

        // Cargo
        frame.add(new JLabel("Cargo:"));
        String[] cargos = {"Desarrollador", "Analista", "Gerente", "Tester"};
        cargoComboBox = new JComboBox<>(cargos);
        frame.add(cargoComboBox);

        // Estado
        frame.add(new JLabel("Estado:"));
        String[] estados = {"Activo", "Inactivo", "Suspendido"};
        estadoComboBox = new JComboBox<>(estados);
        frame.add(estadoComboBox);

        // Botón de enviar
        JButton enviarButton = new JButton("Registrar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar();
            }
        });
        frame.add(enviarButton);

        frame.setVisible(true);
    }

    private void registrar() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String genero = masculinoButton.isSelected() ? "Masculino" : "Femenino";
        StringBuilder lenguajes = new StringBuilder();
        if (javaCheckBox.isSelected()) lenguajes.append("Java ");
        if (pythonCheckBox.isSelected()) lenguajes.append("Python ");
        if (javascriptCheckBox.isSelected()) lenguajes.append("JavaScript ");
        String cargo = (String) cargoComboBox.getSelectedItem();
        String estado = (String) estadoComboBox.getSelectedItem();

        String mensaje = String.format("Nombre: %s\nApellido: %s\nGénero: %s\nLenguajes: %s\nCargo: %s\nEstado: %s",
                nombre, apellido, genero, lenguajes.toString(), cargo, estado);

        JOptionPane.showMessageDialog(frame, mensaje, "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistroPrograma::new);
    }
}