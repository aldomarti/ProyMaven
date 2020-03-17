package net.kiranatos.examples.v08_3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 242: FX 18: Работа с 3D https://www.youtube.com/watch?v=iqBlEjcCqP0&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=19&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/Scene3DLesson.java
*/

public class Test3D_Sphere extends Application {
    private final double sceneWidth = 600;
    private final double sceneHeight = 600;
    private double mouseXold = 0;
    private double mouseYold = 0;
    private final double cameraYlimit = 15;
    private final double rotateModifier = 25;
    
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, sceneWidth, sceneHeight);
        scene.setFill(Color.GOLD);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setFarClip(50000.0);
        camera.setTranslateZ(-1000);

        Sphere sphere = new Sphere(100);
        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.LIGHTCYAN);
        blueMaterial.setSpecularColor(Color.BLUE);
        sphere.setMaterial(blueMaterial);

        sphere.setRotationAxis(Rotate.X_AXIS);
        sphere.setRotate(45);

        sceneRoot.getChildren().add(sphere);
        scene.setCamera(camera);

        Rotate xRotate = new Rotate(0,0,0,0,Rotate.X_AXIS);
        Rotate yRotate = new Rotate(0,0,0,0,Rotate.Y_AXIS);
        camera.getTransforms().addAll(xRotate,yRotate);
        scene.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED ||
                    event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double mouseXnew = event.getSceneX();
                double mouseYnew = event.getSceneY();
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    double pitchRotate = xRotate.getAngle() + (mouseYnew - mouseYold) / rotateModifier;
                    pitchRotate = pitchRotate > cameraYlimit ? cameraYlimit : pitchRotate;
                    pitchRotate = pitchRotate < -cameraYlimit ? -cameraYlimit : pitchRotate;
                    xRotate.setAngle(pitchRotate);
                    double yawRotate=yRotate.getAngle()-(mouseXnew - mouseXold) / rotateModifier;
                    yRotate.setAngle(yawRotate);
                }
                mouseXold = mouseXnew;
                mouseYold = mouseYnew;
            }
        });

        stage.setTitle("3D Шар зі слухачем миші press and drug");
        stage.setScene(scene);
        stage.show();
        stage.setAlwaysOnTop(true);
    }    
}
