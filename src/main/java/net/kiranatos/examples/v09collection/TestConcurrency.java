package net.kiranatos.examples.v09collection;

import java.io.IOException;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 244: FX 20: Concurency https://www.youtube.com/watch?v=eG4I8vVi4lE&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=21&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/ThreadsLesson.java

Дополнительные ресурсы:
1 Concurrency in JavaFX
https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/concurrency.htm
*/

public class TestConcurrency extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MyService service = new MyService();
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                System.out.println("done:" + t.getSource().getValue());
            }
        });
        service.start();
    }

    public static void main(String[] args) {
        launch();
    }

    private static class MyService extends Service<String> {
        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws IOException, MalformedURLException {
                    return "hello";
                }
            };
        }
    }
}

   