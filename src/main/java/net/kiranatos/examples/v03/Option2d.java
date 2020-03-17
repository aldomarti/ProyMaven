package net.kiranatos.examples.v03;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
*/


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Option2d extends Application
{    
    public static void main(String[] args) { launch(); }
    
    @Override
    public void start(Stage prinaryStage) throws Exception {        
        NumberTextField nTF = new NumberTextField();
        //CustomControl cc = new CustomControl();        
        
        Group root = new Group();
        root.getChildren().add(nTF);        
        prinaryStage.setScene(new Scene(root, 400, 300));
        prinaryStage.show();
        prinaryStage.setAlwaysOnTop(true);
        prinaryStage.setTitle("Пример тестового поля, в котором можно печатать только цифры");
    }    
}
