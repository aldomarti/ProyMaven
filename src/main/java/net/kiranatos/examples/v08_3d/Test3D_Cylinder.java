package net.kiranatos.examples.v08_3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 242: FX 18: Работа с 3D https://www.youtube.com/watch?v=iqBlEjcCqP0&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=19&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/Scene3DLesson.java
*/

public class Test3D_Cylinder extends Application {    
    private final double sceneWidth = 600;
    private final double sceneHeight = 600;
    
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, sceneWidth, sceneHeight);
        scene.setFill(Color.GOLD);

        scene.setOnMouseClicked(event-> {
            Node picked = event.getPickResult().getIntersectedNode();
            if(null != picked) {
                double scalar = 2;
                if(picked.getScaleX() > 1)
                    scalar = 1;
                picked.setScaleX(scalar);
                picked.setScaleY(scalar);
                picked.setScaleZ(scalar);
            }
        });

        PerspectiveCamera camera = new PerspectiveCamera(true);
//        camera.setNearClip(0.1);
        camera.setFarClip(50000.0);
        camera.setTranslateZ(-1000);
        
        Cylinder cylinder = new Cylinder(50, 100);
        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.LIGHTCYAN);
        blueMaterial.setSpecularColor(Color.BLUE);
        cylinder.setMaterial(blueMaterial);

        cylinder.setRotationAxis(Rotate.X_AXIS);
        cylinder.setRotate(45);
//        cylinder.setTranslateZ(-200);

        sceneRoot.getChildren().add(cylinder);
        scene.setCamera(camera);
        stage.setTitle("3D Циліндр зі слухачем ПКМ і ЛКМ");
        stage.setScene(scene);
        stage.show();
        stage.setAlwaysOnTop(true);
    }    
}
