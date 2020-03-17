package net.kiranatos.examples.v09collection;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 229: FX 5: Properties и binding https://www.youtube.com/watch?v=6BgRfItf-Uo&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=6&t=0s
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/BindingLesson.java

Дополнительные ресурсы:
Using JavaFX Properties and Binding : https://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm
*/

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class PropertiesAndBindingExample {
    
    public static void main(String[] args) {
        test();
    }
    
    public static void test(){
        System.out.println("\n\nПример работы обёрток-бинов");
        IntegerProperty intP_1 = new SimpleIntegerProperty(1);        
        IntegerProperty intP_2 = new SimpleIntegerProperty(2);
        IntegerProperty intP_3 = new ReadOnlyIntegerWrapper(3);
        
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- no bound");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- no bound");
        
        System.out.println("...adding listener...");
        intP_1.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("_Inside Listener intP_1: New Value = " + newValue + "; Old Value = " + oldValue + "; observable = " + observable);                
            }
        });
        
        System.out.println("\nOne way binding: intP_1 depends from intP_2");
        intP_1.bind(intP_2);
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- bounded");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- no bound");
        intP_2.set(10); // possible to set intP_2, but not intP_1
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- bounded");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- no bound");
        
        intP_1 = new SimpleIntegerProperty(1);
        intP_2 = new SimpleIntegerProperty(2);
        System.out.println("\nTwo way binding");
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- no bound");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- no bound");
        intP_2.bindBidirectional(intP_1);
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- bounded");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- bounded");
        intP_2.set(100); 
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- bounded");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- bounded");
        intP_1.set(200); 
        System.out.println("Values intP_1 = " + intP_1 + " .get() = " + intP_1.get() + " <- bounded");
        System.out.println("Values intP_2 = " + intP_2 + " .get() = " + intP_2.get() + " <- bounded");
        
        
        System.out.println("\n[High-Level Binding API] Приклад додавання: " + intP_1.add(intP_2).getValue());               
        NumberBinding sum = intP_1.add(intP_2); // there are three variables involved: intP_1 (a dependency), intP_2 (a dependency), and sum (the binding)
        //NumberBinding total = Bindings.add(num1.multiply(num2),num3.multiply(num4)); - схожа функция
        System.out.println("Value intP_1 = " + intP_1.get() + " Value intP_2 = " + intP_2.get() + " Sum = " + sum.getValue());        
        intP_2.set(1000);
        System.out.println("Value intP_1 = " + intP_1.get() + " Value intP_2 = " + intP_2.get() + " Sum = " + sum.getValue());        
        
        System.out.print("\n[Low-Level Binding API] Приклад звязування для будь-якого математичного виразу : ");
        final DoubleProperty a = new SimpleDoubleProperty(1);
        final DoubleProperty b = new SimpleDoubleProperty(2);
        final DoubleProperty c = new SimpleDoubleProperty(3);
        final DoubleProperty d = new SimpleDoubleProperty(4);
        DoubleBinding db = new DoubleBinding() {
            {
                super.bind(a, b, c, d);
            }
            
            @Override
            protected double computeValue() {
                return (a.get() * b.get()) + (c.get() * d.get());
            }
        };
 
        System.out.println(db.get());
        b.set(300);
        System.out.println("Після зміни одного значення : " + db.get());                
    }
}

/*
GitHub: https://github.com/hacker85/JavaLessons/blob/master/src/fx/BindingLesson.java

package fx;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class BindingLesson {
    public static void main(String[] args) {
        IntegerProperty integerProperty = new SimpleIntegerProperty(5);
        IntegerProperty integerProperty2 = new ReadOnlyIntegerWrapper(5);

        IntegerBinding integerBinding = new IntegerBinding() {
            {
                super.bind(integerProperty, integerProperty2);
            }
            @Override
            protected int computeValue() {
                return integerProperty.get() + integerProperty2.get();
            }
        };
        System.out.println(integerBinding.get());
        integerProperty.set(1);
        System.out.println(integerBinding.get());


        System.out.println(integerProperty.add(integerProperty2).getValue());


        integerProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("new value = " + newValue);
            }
        });

        integerProperty.bindBidirectional(integerProperty2);
        integerProperty2.set(6);
        //System.out.println(integerProperty.get());
        integerProperty.set(7);
        //System.out.println(integerProperty2.get());
    }
}

class User {
    SimpleStringProperty userName = new SimpleStringProperty("Max");

    User() {
        userName.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("new value: " + newValue);
            }
        });
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }
}
*/