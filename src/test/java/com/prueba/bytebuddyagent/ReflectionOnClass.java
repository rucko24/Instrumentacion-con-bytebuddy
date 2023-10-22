package com.prueba.bytebuddyagent;

import javax.swing.*;
import java.awt.*;

class ReflectionOnClass extends JFrame {


        private JButton button = new JButton("Create new user");
//        private MyProgram2 user = new MyProgram2();
        private JLabel jLabel = new JLabel("X: ");

        public ReflectionOnClass() {
            jLabel.setText("X: " + getValue());
            setLayout(new FlowLayout());
            setPreferredSize(new Dimension(200, 200));
            add(jLabel, Box.createVerticalBox());
            add(button, Box.createVerticalBox());
            button.addActionListener(event -> {
                MyProgram2 user2 = new MyProgram2();
                System.out.println("User created " + user2.getLife());
                jLabel.setText("X: " + user2.getLife());
            });
            pack();

            setDefaultCloseOperation(3);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public int getValue() {
            return 10;
        }

        public static void main(String[] args) {
            new Thread(ReflectionOnClass::new).start();
        }

    }