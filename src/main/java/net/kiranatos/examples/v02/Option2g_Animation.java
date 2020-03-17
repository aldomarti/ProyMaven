package net.kiranatos.examples.v02;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок по Java 235: FX 11: Анимация https://www.youtube.com/watch?v=3uILUbkR1Ls&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=12&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/AnimationLesson.java

Дополнительные ресурсы:
Animation Basics : 
https://docs.oracle.com/javafx/2/animations/basics.htm
*/

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Option2g_Animation extends Application
{    
    private String path = "/img/img.jpg";
    
    public static void main(String[] args) { launch(); }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Приклад Animation");
        
        Rectangle rectangle = new Rectangle(0, 0, 50, 50);
        KeyValue xValue = new KeyValue(rectangle.xProperty(), 500);
        KeyValue yValue = new KeyValue(rectangle.yProperty(), 100);
        rectangle.setFill(Color.CHOCOLATE);
        
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5000), xValue, yValue);
        
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
        
        Image image = new Image(Option2g_Animation.class.getResourceAsStream(path));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        
        FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), imageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(Timeline.INDEFINITE);
        fadeOut.setAutoReverse(true);
        fadeOut.play();
                
        Rectangle rectPath = new Rectangle(0, 0, 40, 40);
        rectPath.setFill(Color.ORANGE);
        
        Path path = new Path();
        path.getElements().add(new MoveTo(20,20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(rectPath);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        
        Rectangle r03 = new Rectangle(50, 100, 60, 40);
        r03.setFill(Color.DARKRED);
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), r03);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        
        Rectangle r04 = new Rectangle(150, 50, 40, 60);
        r03.setFill(Color.YELLOW);
        
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), r04);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        
        Rectangle r05 = new Rectangle(200, 150, 20, 20);
        r03.setFill(Color.BLUE);
        
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), r05);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectPath);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();     
        
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        sequentialTransition.setCycleCount(Timeline.INDEFINITE);
        sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();        
        
        Group root = new Group();
        root.getChildren().add(rectangle);
        root.getChildren().add(rectPath);
        root.getChildren().addAll(r03, r04, r05);
        root.getChildren().add(imageView);
        primaryStage.setScene(new Scene(root, 550, 300));
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);         
        primaryStage.setTitle("Animation");
    }    
}
