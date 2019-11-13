import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    static JFrame frame = new JFrame("A star algorithm");
    static JPanel buttons= new JPanel();
    static Grid grid = new Grid();

    static ButtonGroup group=new ButtonGroup();
    static JRadioButton barrier=new JRadioButton("Prepreke");
    static JRadioButton setStart=new JRadioButton("Pocetak",true);
    static JRadioButton setEnd=new JRadioButton("Kraj");

    static JButton findB=new JButton("Pronadjii najkraci put");


    public static void main(String a[]) {

        group.add(barrier);
        group.add(setStart);
        group.add(setEnd);


        frame.add(grid);
        buttons.add(barrier);
        buttons.add(setStart);
        buttons.add(setEnd);
        buttons.add(findB);
        frame.add(buttons, BorderLayout.NORTH);

        grid.addMouseListener(new MouseHandler(grid));
        findB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AStar(grid).start();
            }
        });

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    Main.grid.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace(); 
                    }
                }
            }
        }.start();   

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
