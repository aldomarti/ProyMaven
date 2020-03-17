package net.kiranatos.examples.v08_3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 242: FX 18: Работа с 3D https://www.youtube.com/watch?v=iqBlEjcCqP0&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=19&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/Scene3DLesson.java
*/

public class Test3D_Box extends Application {
    private final double cameraModifier = 50.0;
    private final double cameraQuantity = 10.0;
    private final double sceneWidth = 600;
    private final double sceneHeight = 600;
    
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, sceneWidth, sceneHeight);
        scene.setFill(Color.BROWN);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setFarClip(50000.0);
        camera.setTranslateZ(-400);

        Box box = new Box(50, 50, 50);
        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.MAGENTA);
        blueMaterial.setSpecularColor(Color.WHEAT);
        box.setMaterial(blueMaterial);

        box.setRotationAxis(Rotate.X_AXIS);
        box.setRotate(25);
        
        sceneRoot.getChildren().add(box);
        scene.setCamera(camera);

        scene.setOnKeyPressed(event -> {
            double change = cameraQuantity;
            if (event.isShiftDown()) {
                change = cameraModifier;
            }
            KeyCode keycode = event.getCode();
            if (keycode == KeyCode.W) {
                camera.setTranslateZ(camera.getTranslateZ() + change);
            }
            if (keycode == KeyCode.S) {
                camera.setTranslateZ(camera.getTranslateZ() - change);
            }
            if (keycode == KeyCode.A) {
                camera.setTranslateX(camera.getTranslateX() - change);
            }
            if (keycode == KeyCode.D) {
                camera.setTranslateX(camera.getTranslateX() + change);
            }
        });

        stage.setTitle("3D Коробка зі слухачем кнопок W, S, A, D");
        stage.setScene(scene);
        stage.show();
        stage.setAlwaysOnTop(true);
    }    
}
