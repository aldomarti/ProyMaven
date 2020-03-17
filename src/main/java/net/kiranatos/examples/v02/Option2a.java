package net.kiranatos.examples.v02;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
*/

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Option2a extends Application
{    
    public static void main(String[] args) { launch(); }
    
    @Override
    public void start(Stage prinaryStage) throws Exception {        
        // Arc, Circle, CubicCurve, Ellipse, Line, Path, Polygon, Polyline, QuadCurve, Rectangle, SVGPath, Text (its a type of shape too)
        Ellipse ellipse = new Ellipse(0, 0, 200, 50); // centerX, centerY, radiusX, radiusY
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.YELLOW);
        
        Text text = new Text(0, 250, "Hello World");
        text.setStroke(Color.BLUE);
        text.setFont(Font.font(50));
        
        Group root = new Group();
        root.getChildren().add(ellipse);
        root.getChildren().add(text);        
        
        Scene scene = new Scene(root, 400, 300);        
        
        prinaryStage.setScene(scene);
        prinaryStage.show();
        prinaryStage.setAlwaysOnTop(true);
        prinaryStage.setTitle("Пример отрисовки фигур");
    }    
}
