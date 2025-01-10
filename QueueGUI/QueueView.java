package View;
import java.awt.*;
import javax.swing.*;

public class QueueView extends JFrame {
    //Enqueue
    public JTextField enqueueTxt;
    public JButton enqueueBttn;

    //Front/Rear Value Labels and Value Labels
    public JLabel rearLabel;
    public JLabel rearValueLabel;
    public JLabel frontLabel;
    public JLabel frontValueLabel;

    //Buttons
    public JButton dequeueBttn; //peak()
    public JButton loadBttn;
    public JButton saveBttn;
    public JButton clearBttn;


    public QueueView(){
        super("Queue");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        enqueueTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(enqueueTxt,constraints);

        enqueueBttn = new JButton("Enqueue");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(enqueueBttn,constraints);

        dequeueBttn = new JButton("Dequeue");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(dequeueBttn,constraints);

        loadBttn = new JButton("Load");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(loadBttn,constraints);

        saveBttn = new JButton("Save");
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(saveBttn,constraints);

        clearBttn = new JButton("Clear");
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(clearBttn,constraints);

        frontLabel = new JLabel("Front:  ");
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(frontLabel,constraints);

        frontValueLabel = new JLabel("0");
        constraints.gridx = 2;
        constraints.gridy = 1;
        add(frontValueLabel,constraints);

        rearLabel = new JLabel("Rear:  ");
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(rearLabel,constraints);

        rearValueLabel = new JLabel("0");
        constraints.gridx = 2;
        constraints.gridy = 2;
        add(rearValueLabel,constraints);


        /**Instantiate Buttons and JFrame stuff*/

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
