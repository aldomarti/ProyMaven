package net.kiranatos.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.kiranatos.examples.v01.Option1;
import net.kiranatos.examples.v02.AllUIContrls;
import net.kiranatos.examples.v02.Option2a;
import net.kiranatos.examples.v02.Option2b;
import net.kiranatos.examples.v02.Option2c;
import net.kiranatos.examples.v02.Option2f_Image;
import net.kiranatos.examples.v02.Option2g_Animation;
import net.kiranatos.examples.v02.SwingToJavaFX;
import net.kiranatos.examples.v09collection.PropertiesAndBindingExample;
import net.kiranatos.examples.v03.Option2d;
import net.kiranatos.examples.v04.CssTest;
import net.kiranatos.examples.v05media.TestMedia;
import net.kiranatos.examples.v06.Test01_HTML_JavaScript_in_WebView;
import net.kiranatos.examples.v06.Test02_HTML_JavaScript_in_WebView;
import net.kiranatos.examples.v06.Test03_HTML_JavaScript_in_WebView;
import net.kiranatos.examples.v06.WebLesson;
import net.kiranatos.examples.v07charts.TestChart;
import net.kiranatos.examples.v08_3d.Test3D_Box;
import net.kiranatos.examples.v08_3d.Test3D_Cylinder;
import net.kiranatos.examples.v08_3d.Test3D_Sphere;
import net.kiranatos.examples.v09collection.ObservableCollection;
import net.kiranatos.examples.v09collection.TestConcurrency;

public class App {
    public static void main(String[] args) throws IOException {
        OzoHelpClass.printMe(null,
                "Использованные материалы: ",
                "2-6) Канал: Уроки Java - Плейлист: Java FX",
                "\n",
                "\n Choose version of project:\n",
                "1. Had created automatically by NetBeans (29.12.2019)",
                "2.1. Пример отрисовки фигур without Canvas",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "2.2. Drawing Shapes on a Canvas from Oracle site",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t HomeWork: нужно доделать остальные примеры",
                "2.3. Приклад слоя і кнопок зі слухачами",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "2.4. Связь Swing i JavaFX",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t ПРОБЛЕМА: почему-то нету отображения",
                "2.5. Example of image.",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t HomeWork: поиграться с путями к файлам ресурсов jpg|fxml|txt. Есть много вариатов. Почитать в нЭте",
                "2.6. Example of Animation.",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t HomeWork: доредактировать класс для себя + перечитать статтью Oracle",
                "2.7. Демонстрування багатьох елементів JavaFX",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "3. Пример тестового поля, в котором можно печатать только цифры, c FXML",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "4. CSS",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t HomeWork: Повторить CSS, переделать всё на нормальное отображение, т.к. блоггер хрень сделал",
                    "\t HomeWork: Перечитать статтьи Oracle - ссылки в классе",
                "5. Media",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t ПРОБЛЕМА: код не рабочий, то ли путь не находит, то ли форматы не подходят, то ли код у блоггера кривой - нужно перечитать все статьи и вернутся позже",
                    "\t HomeWork: переделать всё",
                    "\t HomeWork: Перечитать статтьи Oracle - ссылки в классе",
                "6. Отображение HTML и JavaScript в WebView",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "7. Графики - Charts",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t HomeWork: Перечитать статтьи Oracle и реализовать дополнительно остальные примеры (ссылки в классе)",
                "8. 3D shapes",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "9.1. Example of Using JavaFX Properties and Binding (BEANS)",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "9.2. Example of Using JavaFX Observable Collections",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                "9.3. Concurrency and Multithreading in Java FX",
                    "\t Youtube channel <<Уроки Java: Java FX>>",
                    "\t HomeWork: из видео не понятно - что куда и как. Разобраться и переписать самому. Видео смотреть бесполезно.",
                    "\t HomeWork: Перечитать статтью Oracle - ссылкa в классе",
                "10.1. Change Languages from properties files (источник утерян)",                    
                    "\t HomeWork: разобраться что вообще происходит. Законспектировать коректным языком. Классы: ResourceBundle, MessageFormat, ChoiceFormat, Format, NumberFormat",
                "10.2. Dynamic language change in window (источник утерян, вроде youtube-видео)",
                    "\t HomeWork: как работает. Законспектировать коректным языком.",
                    "",
                    "",
                "");
                        
        String theChoice = OzoHelpClass.getRead();
        System.out.println("Your choice: " + theChoice);
        
        switch (theChoice) {
            case "1": 
                Option1.main(null);           
                break;
            case "2.1":
                Option2a.main(null);                
                break;
            case "2.2": 
                Option2b.main(null);
                break;
            case "2.3": 
                Option2c.main(null);
                break;
            case "2.4": 
                SwingToJavaFX.main(null);
                break;
            case "2.5": 
                Option2f_Image.main(null);
                break;
            case "2.6": 
                Option2g_Animation.main(null);
                break;
            case "2.7": 
                AllUIContrls.main(null);
                break;
            case "3": 
                Option2d.main(null);
                break;
            case "4": 
                CssTest.main(null);
                break;
            case "5": 
                TestMedia.main(null);
                break;
            case "6": 
                start_HTML_JavaScript_in_WebView();
                break;
            case "7": 
                TestChart.main(null);
                break;
            case "8": 
                start3D();
                break;
            case "9.1": 
                PropertiesAndBindingExample.test();
                break;
            case "9.2": 
                ObservableCollection.main(null);
                break;
            case "9.3": 
                TestConcurrency.main(null);
                break;
            case "10.1": 
                net.kiranatos.examples.v10lang.ChangeLanguage.main(null);
                break;
            case "10.2": 
                net.kiranatos.examples.v10lang.I18nApplication.main(null);
                break;
                
                
            default: System.out.println("Incorrect choice !!!");
                break;
        }
    } // end of main method
    
    private static void start_HTML_JavaScript_in_WebView() {
        System.out.println("Фазы программы:\n 6.1 \n 6.2 \n 6.3 \n 6.4 Original");
        String theChoice = OzoHelpClass.getRead();
        System.out.println("Your choice: " + theChoice);
        switch (theChoice) {
            case "6.1": 
                Test01_HTML_JavaScript_in_WebView.main(null);
                break;
            case "6.2":
                Test02_HTML_JavaScript_in_WebView.main(null);
                break;
            case "6.3": 
                Test03_HTML_JavaScript_in_WebView.main(null);
                break;
            case "6.4": 
                WebLesson.main(null);
                break;
                
            default: System.out.println("Incorrect choice !!!");
                break;
        }        
    }
    
    private static void start3D() {
        OzoHelpClass.printMe(null, 
                "8.1) 3D Циліндр зі слухачем ПКМ і ЛКМ",
                "8.2) 3D Коробка зі слухачем кнопок W, S, A, D",
                "8.3) 3D Шар зі слухачем миші press and drug",
                "\t HomeWork:",
                "\t\t - розібратися що роблять деякі строки всередині кода",
                "\t\t - класс MeshView: user-defined shape - зрозуміти як працює");        
        String theChoice = OzoHelpClass.getRead();
        System.out.println("Your choice: " + theChoice);
        switch (theChoice) {
            case "8.1": 
                Test3D_Cylinder.main(null);
                break;
            case "8.2":
                Test3D_Box.main(null);
                break;
            case "8.3": 
                Test3D_Sphere.main(null);
                break;            
                
            default: System.out.println("Incorrect choice !!!");
                break;
        }        
    }
}

/*
    YOUTUBE :

Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-

Канал: Vladislav Kavunenko https://www.youtube.com/channel/UCzLxgOC73OVLR3zS-SeOkiQ					
    https://github.com/Kawun/tutorials
Плейлист: JavaFX UI Controls https://www.youtube.com/playlist?list=PLgZIR_u-_cLq84WzlMaGdY5-9UuRPo0Sa
    27 lessons

Канал: Ripples Code https://www.youtube.com/channel/UCF7RTcfO02xQ94cWH6C35bg
Плейлист: JavaFx Tutorial for Beginners https://www.youtube.com/playlist?list=PLCaS22Sjc8YTLc6rndMFbrc2FuGj70h5L
    43 lessons

Канал: thenewboston https://www.youtube.com/user/thenewboston/featured
Плейлист: JavaFX Java GUI Design Tutorials https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
    35 lessons

Канал: Genius Coders https://www.youtube.com/channel/UC2gbhxhWVXOEgdqR7Xup9cw
Плейлист: JavaFX Basic Course (32 уроков)
Плейлист: JavaFX CSS Tutorial (9 уроков)
Плейлист: JavaFX Projects (8 уроков)
Плейлист: JavaFX GUI Design (7 уроков)
Плейлист: JavaFX Car Review Project (12 уроков)
Плейлист: JavaFX Tutorial (3 уроков)
Плейлист: JavaFX Animation Tutorial (3 уроков)
Плейлист: JavaFX ControlsFX Tutorial (22 уроков)
Плейлист: JavaFX Material Design (2 уроков)
Плейлист: JavaFX JFoenix Tutorial (5 уроков)


Канал: Almas Baimagambetov https://www.youtube.com/channel/UCmjXvUa36DjqCJ1zktXVbUA/featured
    https://github.com/AlmasB
Плейлист: FXGL - JavaFX Game Engine (81 уроков)
Плейлист: JavaFX Software (24 уроков)
Плейлист: JavaFX Game Development (10 уроков)
Плейлист: JavaFX Game Tutorials (20 уроков)
Плейлист: JavaFX 3D (3 уроков)
Плейлист: JavaFX Custom Game Menu (8 уроков)
*/

/*
Список статей для закріплення матеріалу

Working With Layouts in JavaFX: Using Built-in Layout Panes | JavaFX 2 Tutorials and Documentation	
https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm

Client Technologies: Java Platform, Standard Edition (Java SE) 8 Release 8	
https://docs.oracle.com/javase/8/javase-clienttechnologies.htm

Using JavaFX UI Controls: About This Tutorial | JavaFX 2 Tutorials and Documentation	
https://docs.oracle.com/javafx/2/ui_controls/jfxpub-ui_controls.htm#

Mastering FXML: Creating a Custom Control with FXML | JavaFX 2 Tutorials and Documentation	
https://docs.oracle.com/javafx/2/fxml_get_started/custom_control.htm

2 Working with Convenience Methods	
https://docs.oracle.com/javase/8/javafx/events-tutorial/convenience_methods.htm

Animation Basics : 
https://docs.oracle.com/javafx/2/animations/basics.htm

Перечитати ще раз це обговорення:
https://stackoverflow.com/questions/16374235/resources-and-config-loading-in-maven-project

9 Working with the Canvas API :
https://docs.oracle.com/javase/8/javafx/graphics-tutorial/canvas.htm#JFXGR214

Using JavaFX Properties and Binding : 
https://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm

Animation Basics : 
https://docs.oracle.com/javafx/2/animations/basics.htm

37 Styling UI Controls with CSS	
https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/apply-css.htm

Handling JavaFX Events - 1 Processing Events	
https://docs.oracle.com/javafx/2/events/processing.htm

JavaFX: Mastering FXML - 1 Why Use FXML	
https://docs.oracle.com/javase/8/javafx/fxml-tutorial/why_use_fxml.htm

29 Customization of UI Controls	
https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/custom.htm

5 Creating a Custom Control with FXML	
https://docs.oracle.com/javafx/2/fxml_get_started/custom_control.htm

1 Introduction to JavaFX Media	
https://docs.oracle.com/javase/8/javafx/media-tutorial/overview.htm

2 Embedding Media Into a Web Page
https://docs.oracle.com/javase/8/javafx/media-tutorial/simpleplayer.htm

32 Line Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/line-chart.htm
33 Area Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/area-chart.htm
34 Bubble Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/bubble-chart.htm
35 Scatter Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/scatter-chart.htm
36 Bar Chart	https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/bar-chart.htm

1 Using JavaFX Collections
https://docs.oracle.com/javase/8/javafx/collections-tutorial/collections.htm

1 Concurrency in JavaFX
https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/concurrency.htm
*/