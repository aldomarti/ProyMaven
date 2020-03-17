package net.kiranatos.examples.v06;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 240: FX 16: Отображение HTML и JavaScript в WebView https://www.youtube.com/watch?v=lB25LIajFHo&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=17&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/WebLesson.java

Дополнительные ресурсы:
*/

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Test02_HTML_JavaScript_in_WebView extends Application  {
    
    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage stage) throws Exception {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        //webEngine.load("file:"); //www
        webEngine.loadContent(""
                + "<div id='div'>hello world</div>"
                + "<script>document.getElementById('div').style.color='blue';"
                + "function changeColor() {"
                + " document.getElementById('div').style.color='green';"
                + "}</script>");
        
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldValue, newValue)->{
            if (newValue == Worker.State.SUCCEEDED){
                webEngine.executeScript("changeColor();");
            }
        });
        
        
        
        Group group = new Group();
        Scene scene = new Scene(group, 780, 200);

        group.getChildren().add(webView);
        
        stage.setTitle("Отображение HTML и JavaScript в WebView");
        stage.setScene(scene);
        stage.show();
        stage.setAlwaysOnTop(true);
    }
    
}
