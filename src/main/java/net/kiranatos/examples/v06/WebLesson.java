package net.kiranatos.examples.v06;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 240: FX 16: Отображение HTML и JavaScript в WebView https://www.youtube.com/watch?v=lB25LIajFHo&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=17&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/WebLesson.java

Дополнительные ресурсы:
*/

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;

import static javafx.concurrent.Worker.State.SUCCEEDED;

public class WebLesson extends Application {
    public static void main(String[] args) { launch(args);  }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        //webEngine.load();
        Document dom = webEngine.getDocument();
        webEngine.loadContent("<div id=\"div\" style=\"color: red\">text</div><script>document.getElementById(\"div\").style.color=\"blue\";" +
                "function changeColor(){" +
                "var message = hello.sayGoodbye(\"Max\");" +
                "document.getElementById(\"div\").innerHTML = message;" +
                "document.getElementById(\"div\").style.color=\"green\"" +
                "};" +
                "</script>");
        JSObject jsObject = (JSObject) webEngine.executeScript("window");
        jsObject.setMember("hello", new MyHelloWorld());
        webEngine.getLoadWorker()
                .stateProperty()
                .addListener( (obs, oldValue, newValue) -> {
                    if (newValue == SUCCEEDED) {
                        webEngine.executeScript("changeColor();");
                    }
                });

        Group group = new Group();
        group.getChildren().add(webView);
        primaryStage.setScene(new Scene(group, 400, 300));
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    public class MyHelloWorld {
        public String sayGoodbye(String name) {
            return "Hello " + name;
        }
    }
}