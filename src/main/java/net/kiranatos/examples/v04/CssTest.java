package net.kiranatos.examples.v04;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.kiranatos.examples.OzoHelpClass;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 237: FX 13: CSS https://www.youtube.com/watch?v=7PnnCvJM3Tg&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=14&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/CssStyleLesson.java

Дополнительные ресурсы:
http://aquafx-project.com/downloads.html

37 Styling UI Controls with CSS	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/apply-css.htm
Handling JavaFX Events - 1 Processing Events	https://docs.oracle.com/javafx/2/events/processing.htm
JavaFX: Mastering FXML - 1 Why Use FXML	https://docs.oracle.com/javase/8/javafx/fxml-tutorial/why_use_fxml.htm
29 Customization of UI Controls	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/custom.htm
5 Creating a Custom Control with FXML	https://docs.oracle.com/javafx/2/fxml_get_started/custom_control.htm
*/

public class CssTest  extends Application {
    
    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage stage) throws Exception {
        OzoHelpClass.printMe(null, 
                "Типу пояснення:",
                "5 основних вариантів + можливість модифікувати(6) під себе",
                "(2)(3) - основні встроєні стилі",
                "(4) - повнюстью перекриває основний стиль за замовчуванням, бере стиль з css-файлу - з нуля так сказати",
                "(5) - не перекриває основний стиль, дозволяє так сказати дописати, переробити існуючі окрумі обєкти. css-файл",
                "(1) - http://aquafx-project.com макбук стиль, подібний до (2)(3), але потрібно скачати jar-нік або встановити через maven",
                "",
                "");
        
        HBox hbox = new HBox();        
//        AquaFx.style(); /* 1 */
//        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN); /* 2 */
//        Application.setUserAgentStylesheet(STYLESHEET_MODENA); /* 3 */
//        Application.setUserAgentStylesheet(getClass().getResource("sample.css").toExternalForm()); /* 4 */
          
        Label label = new Label("It is Label");
        Button button_01 = new Button("Button 1");
        Button button_02 = new Button("Button 2");
        Button button_03 = new Button("Button 3");
        Button button_04 = new Button("Button 4");
        
        /* 6: */
        button_03.getStyleClass().add("MySomeStyle");
        button_04.setStyle("-fx-background-color: red; -fx-font-size: 10");
        button_02.setId("my-button");
        
        Group group = new Group();
        Scene scene = new Scene(group, 780, 200);
        
        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm()); /* 5 */
        
                
        hbox.getChildren().addAll(button_01, label, button_02, button_03, button_04);
        group.getChildren().add(hbox);        
        
        stage.setTitle("CSS Tester");
        stage.setScene(scene);
        stage.show();
        stage.setAlwaysOnTop(true);
    }    
}

