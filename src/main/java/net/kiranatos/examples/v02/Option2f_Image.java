package net.kiranatos.examples.v02;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-

Перечитати ще раз це обговорення - https://stackoverflow.com/questions/16374235/resources-and-config-loading-in-maven-project
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils; // додана залежність № 3 javafx-swing в POM.xml
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class Option2f_Image extends Application
{    
    public static void main(String[] args) { launch(); }
        
    private String path = "/img/img.jpg";
    
    @Override
    public void start(Stage prinaryStage) throws Exception {
        System.out.println("Приклад image");
        
        InputStream resource = Option2f_Image.class.getResourceAsStream(path);
        
        Image image = new Image(resource);
        ImageView iv = new ImageView(image);
        iv.setFitHeight(150);
        iv.setFitWidth(200);
        
        System.out.println("Приклад reading image");
        PixelReader pR = image.getPixelReader();
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = pR.getColor(i, j);                
            }            
        }
        
        System.out.println("Приклад writing image. Файл створюється на одному рівні з папкою src");
        WritableImage wImage = new WritableImage((int)image.getWidth(), (int)image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                pixelWriter.setColor(j, i, Color.ALICEBLUE);                
            }            
        }
                
        ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("test.png"));
        System.out.println("Image was wrote in file");
        
        System.out.println("Вывести в окно прочитанный image from resources folder or image created inside class? (y/n)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String yesNo = reader.readLine();
        
        Group root = new Group();            
        root.getChildren().add(
                yesNo.equalsIgnoreCase("y") ? iv : new ImageView(wImage)                
        );
        prinaryStage.setScene(new Scene(root, 400, 300));
        prinaryStage.show();
        prinaryStage.setAlwaysOnTop(true);         
        prinaryStage.setTitle("Example of Image");
    }
}
