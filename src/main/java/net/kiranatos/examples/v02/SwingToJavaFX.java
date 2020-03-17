package net.kiranatos.examples.v02;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 245: FX 21: Swing и Fx https://www.youtube.com/watch?v=6Py7WNolqxw&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=22&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/SwingFxLesson.java
*/

public class SwingToJavaFX {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing and JavaFX");
        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Group  root  =  new Group();
        Scene  scene  =  new  Scene(root, Color.BLUE);

        Text text  =  new  Text();
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().addAll(new Button("press"), text);

        fxPanel.setScene(scene);
    }
}