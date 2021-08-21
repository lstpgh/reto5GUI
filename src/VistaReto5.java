import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VistaReto5 extends JFrame{
    
    Controller controller = new Controller("jdbc:mysql://localhost:3306/proyectos");
    
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaReto5(){

        setVisible(true);
        setTitle("   R E T O   5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800,650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Consultas SQL");
        lbltitulo.setBounds(28, 26, 61, 16);
        contentPane.add(lbltitulo);

        // Dimensiona el contenido dentro de la ventana
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        // Proporciona una vista desplazable de un componente en una ventana grafica
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Requerimiento 1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(20, 537, 133, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Requerimiento 2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(157, 537, 133, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Requerimiento 3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(294, 537, 133, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public void requerimiento1(){
        controller.req1();
        String salida = "\n\n\t\t\t   R E Q U E R I M I E N T O   1\n\n\n";
            
        for (Req1 req1 : controller.req1s){
            salida += "\t";
            salida += req1;
            salida += "\n";
            }
        textArea.setText(salida);

    }


    public void requerimiento2(){
        controller.req2();
        String salida = "\n\n\t\t\t   R E Q U E R I M I E N T O   2\n\n\n";
            
        for (Req2 req2 : controller.req2s){
            salida += "\t";
            salida += req2;
            salida += "\n";
            }
        textArea.setText(salida);

    }


    public void requerimiento3(){
        controller.req3();
        String salida = "\n\n\t\t\t   R E Q U E R I M I E N T O   3\n\n\n";
            
        for (Req3 req3 : controller.req3s){
            salida += "\t";
            salida += req3;
            salida += "\n";
            }
        textArea.setText(salida);

    }


}

