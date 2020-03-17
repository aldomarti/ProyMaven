package net.kiranatos.examples.v05media;

/* Пример на основе:
Канал: Уроки Java https://www.youtube.com/channel/UCBk48R8tFfqaDWUB84NENLQ
Плейлист: Java FX https://www.youtube.com/playlist?list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-
Видео: Урок Java 237: FX 13: CSS https://www.youtube.com/watch?v=7PnnCvJM3Tg&list=PL786bPIlqEjQ-0zPCuCcVDYdrCGdu71r-&index=14&t=0s

Дополнительные ресурсы:
1 Introduction to JavaFX Media	https://docs.oracle.com/javase/8/javafx/media-tutorial/overview.htm
2 Embedding Media Into a Web Page	https://docs.oracle.com/javase/8/javafx/media-tutorial/simpleplayer.htm
Поддержка воспроизведения MP3 и WAV форматов в Java 	https://jazzteam.org/ru/technical-articles/support-of-mp3-and-wav-format-files-playback-in-java/	
Java Tip 24: How to play audio in applications	https://www.javaworld.com/article/2077521/java-tip-24--how-to-play-audio-in-applications.html
*/

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import net.kiranatos.examples.OzoHelpClass;


public class TestMedia extends Application {
    
    private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
    private static final String VIDEO_PATH = "D:\\oow.flv";
    private static final String PATH = "oow.flv";
    
    private static final String AUDIO_PATH = "D:/kis.mp3";
    private static final String PATH_AUDIO = "kis.mp3";
    
    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage stage) throws Exception {
//        String rrr = OzoHelpClass.getRead();
//        System.out.println(rrr);
        
        // Audio:
        Media media = new Media(AUDIO_PATH);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        
        
        //Video:
//        Media mediaVideo = new Media(rrr);
//        MediaPlayer mediaPlayerVideo = new MediaPlayer(mediaVideo);
//        mediaPlayerVideo.play();
//        //mediaPlayer.setAutoPlay(true);
//        MediaView mV = new MediaView(mediaPlayerVideo);
        
        Group group = new Group();
        Scene scene = new Scene(group, 780, 200);
        
//        group.getChildren().add(mV);

        group.getChildren().add(new Button("music"));
        
        stage.setTitle("Media Player");
        stage.setScene(scene);
        stage.show();
        stage.setAlwaysOnTop(true);
    }
}
