package net.kiranatos.examples.v02;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
https://github.com/hacker85/JavaLessons/blob/master/src/fx/EventLesson.java

*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Option2c extends Application
{    
    public static void main(String[] args) { launch(); }
    
    @Override
    public void start(Stage prinaryStage) throws Exception {
        System.out.println("Приклад слоя і кнопок зі слухачами");
        Button b1 = new Button("Up");
        Button b2 = new Button("Down");
        
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("1st way to add listener");
            }
        });
        b2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("2nd way to add listener");
            }
        });
        
        BorderPane bP = new BorderPane();
        bP.setBottom(b1);
        bP.setTop(b2);
        
        bP.setMinWidth(200);
        bP.setMinHeight(150);
        
        
        Group root = new Group();
        root.getChildren().add(bP);
        prinaryStage.setScene(new Scene(root, 400, 300));
        prinaryStage.show();
        prinaryStage.setAlwaysOnTop(true);         
        prinaryStage.setTitle("Name");
    }
    
   
    
}
