package mycodes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWindow {
    public static void main(String[] args) {

//        new JFrame() {
//            int i = 0;
//            {
//
//                add(new JButton("Click") {
//                    {
//                        addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                System.out.println(i++%2 == 0 ? "One" : "Two");
//                            }
//                        });
//                        setBounds(200,230,100, 40);
//                        setLayout(null);
//                    }
//                });
//                setSize(500, 500);
//                setVisible(true);
//                setDefaultCloseOperation(EXIT_ON_CLOSE);

        JFrame window = new JFrame();

        JButton button =new JButton("click");//creating instance of JButton
        button.setBounds(200,230,100, 40);//x axis, y axis, width, height
        button.addActionListener(new ActionListener() {
            int i =0;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(i++%2 == 0 ? "One" : "Two");
            }
        });

        window.add(button);//adding button in JFrame
        window.setLayout(null);                                 //using no layout managers
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //close program while click X
        window.setSize(500, 500);

//            }
//        };
    }
}
