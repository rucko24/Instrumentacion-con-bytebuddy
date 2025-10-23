package com.prueba.bytebuddyagent;

import javax.swing.*;
import java.awt.*;

class ReflectionOnClass extends JFrame {


        private MyProgram2 user = new MyProgram2();
        private JLabel jLabel = new JLabel("X: ");

        public ReflectionOnClass() {
            jLabel.setText("X: " + user.getLife());
            jLabel.setText("X: " + getValue());
            setLayout(new FlowLayout());
            setPreferredSize(new Dimension(200, 200));
            add(jLabel);
            pack();

            setDefaultCloseOperation(3);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public int getValue() {
            return 10;
        }
    }