package net.kiranatos.examples.v02;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 228: FX 4: Canvas https://www.youtube.com/watch?v=cCC_qk48-c4&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=5&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/CanvasLesson.java

9 Working with the Canvas API : https://docs.oracle.com/javase/8/javafx/graphics-tutorial/canvas.htm#JFXGR214
*/

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Option2b extends Application
{    
    public static void main(String[] args) { launch(); }
    
    @Override
    public void start(Stage prinaryStage) throws Exception {
        Canvas canvas = new Canvas(400,300);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawShapes(context);
        
        Group root = new Group();
        root.getChildren().add(canvas);
                
        Scene scene = new Scene(root, 400, 300);        
        
        prinaryStage.setScene(scene);
        prinaryStage.show();
        prinaryStage.setAlwaysOnTop(true);         
        prinaryStage.setTitle("Drawing Shapes on a Canvas");
    }
    
    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
    
    
}
