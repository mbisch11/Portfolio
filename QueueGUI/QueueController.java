package Controller;
import View.QueueView;
import Model.QueueModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class QueueController {

    private QueueModel model;
    private QueueView view;
    public QueueController(QueueModel m, QueueView v){
        this.model = m;
        this.view = v;

        if(!model.isEmpty()){
            String front = Integer.toString(model.peek());
            view.frontValueLabel.setText(front);
        }
        view.enqueueBttn.addActionListener(new enqueueBttnListener());
        view.dequeueBttn.addActionListener(new dequeueBttnListener());
        view.saveBttn.addActionListener(new saveBttnListener());
        view.loadBttn.addActionListener(new loadBttnListener());
        view.clearBttn.addActionListener(new clearBttnListener());
    }

    public class enqueueBttnListener implements ActionListener{
        public enqueueBttnListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            int toQ = Integer.parseInt(view.enqueueTxt.getText());
            model.enqueue(toQ);
            view.rearValueLabel.setText(Integer.toString(toQ));
            view.frontValueLabel.setText(Integer.toString(model.peek()));
        }
    }

    public class dequeueBttnListener implements ActionListener{
        public dequeueBttnListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!model.isEmpty()) {
                model.dequeue();
                if(model.isEmpty()){
                    view.frontValueLabel.setText("0");
                    view.rearValueLabel.setText("0");
                }else{
                    view.frontValueLabel.setText(Integer.toString(model.peek()));
                }
            }else{
                JOptionPane.showMessageDialog(view,"The Queue is empty!");
            }
        }
    }

    public class saveBttnListener implements ActionListener{
        public saveBttnListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            model.save(model.getQueue());
        }
    }

    public class loadBttnListener implements ActionListener{
        public loadBttnListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!model.isEmpty()){
                model.clear();
            }
            int len = model.load().size();
            int last = 0;
            Queue<Integer> q = model.load();
            for(int i = 0; i < len; i++){
                model.enqueue(q.poll());
                last = i;
            }
            view.rearValueLabel.setText(Integer.toString(last));
            view.frontValueLabel.setText(Integer.toString(model.peek()));
        }
    }

    public class clearBttnListener implements ActionListener{
        public clearBttnListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            model.clear();
            view.frontValueLabel.setText("0");
            view.rearValueLabel.setText("0");
        }
    }

}
