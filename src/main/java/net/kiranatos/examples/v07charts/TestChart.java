package net.kiranatos.examples.v07charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 241: FX 17: Графики - Charts https://www.youtube.com/watch?v=4DN054V5Yw4&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=18&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/ChartLesson.java

Дополнительные ресурсы:
32 Line Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/line-chart.htm
33 Area Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/area-chart.htm
34 Bubble Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/bubble-chart.htm
35 Scatter Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/scatter-chart.htm
36 Bar Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/bar-chart.htm
*/

public class TestChart extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                new PieChart.Data("C++", 13),
                new PieChart.Data("Java", 25),
                new PieChart.Data("Python", 10),
                new PieChart.Data("Pascal", 22),
                new PieChart.Data("JavaScript", 30));
        PieChart chart = new PieChart(data);
        chart.setTitle("Languages");

        Group root = new Group();
        root.getChildren().addAll(chart);
        primaryStage.setScene(new Scene(root, 520, 460));
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }    
}