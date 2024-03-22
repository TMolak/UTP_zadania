package zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskList extends JFrame {

    public TaskList(){
        super("Task List");

        JButton addButton = new JButton("Dodaj zadanie");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        setLayout(new BorderLayout());
        add(new JList<>());
        JPanel buttons = new JPanel();
        buttons.add(addButton);

        add(buttons, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addTask(){

    }
}
