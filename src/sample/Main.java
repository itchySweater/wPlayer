package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.File;

public class Main extends Application {
    private File file;
    private MediaPlayer plejer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileChooser fc = new FileChooser();
        ExtensionFilter extFilter = new ExtensionFilter("Audio Files", "*.wav", "*.mp3");
        fc.getExtensionFilters().add(extFilter);

        Button open = new Button("Open");
        open.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            file = fc.showOpenDialog(null);
            if (file != null) {
                String path = file.toURI().toString();
                Media media = new Media(path);
                plejer = new MediaPlayer(media);
            }
        });

        Button play = new Button("Play");
        play.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            plejer.play();
        });

        Button pause = new Button("Pause");
        pause.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            plejer.pause();
        });

        Button stop = new Button("Stop");
        stop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            plejer.stop();
        });

        HBox hbox = new HBox(play, pause, stop, open);
        VBox vbox = new VBox(hbox);
        BorderPane root = new BorderPane(vbox);
        Scene scene = new Scene(root, 250, 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WacPlayer");

        primaryStage.show();
    }
}
