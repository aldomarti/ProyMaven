package net.kiranatos.examples.v09collection;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 243: FX 19: Collections https://www.youtube.com/watch?v=wqHsWoTN1QM&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=20&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/CollectionsLesson.java

Дополнительные ресурсы:
1 Using JavaFX Collections
https://docs.oracle.com/javase/8/javafx/collections-tutorial/collections.htm
*/
public class ObservableCollection {
     public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");

        ObservableList<String> observableList = FXCollections.observableList(list);        
        
        observableList.addListener(new ListChangeListener<String>() {
        //observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change<? extends String> change) {
            //public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change in observableList! ");
            }
        });
        System.out.println("Size of observableList: " + observableList.size());
        System.out.println("Size of list: " + list.size());
        
        observableList.add("item one");
        
        System.out.println("Size of observableList: " + observableList.size());
        System.out.println("Size of list: " + list.size());
        
        list.add("item two");

        System.out.println("Size of observableList: " + observableList.size());
        System.out.println("Size of list: " + list.size());
    }    
}
