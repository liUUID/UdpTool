import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.UDPUtil;

import java.io.IOException;

/**
 * PACKAGE_NAME
 * 李院斌
 **/
public class main   extends Application  {
    private TextField ipTextField;
    private TextField portTextField;
    private TextField commandTextField;
    private TextArea responseTextArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("物理沙盘工具管理");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label ipLabel = new Label("IP:");
        grid.add(ipLabel, 0, 0);

        ipTextField = new TextField("192.168.0.200");
        grid.add(ipTextField, 1, 0);

        Label portLabel = new Label("Port:");
        grid.add(portLabel, 0, 1);

        portTextField = new TextField("12345");
        grid.add(portTextField, 1, 1);

        Label commandLabel = new Label("指令:");
        grid.add(commandLabel, 0, 2);

        commandTextField = new TextField();
        grid.add(commandTextField, 1, 2);

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendCommand());
        grid.add(sendButton, 0, 3, 2, 1);

        responseTextArea = new TextArea();
        responseTextArea.setEditable(false);
        grid.add(responseTextArea, 0, 4, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sendCommand() {
        String ip = ipTextField.getText();
        int port = Integer.parseInt(portTextField.getText());
        String command = commandTextField.getText();

        try {
            UDPUtil.send(ip, port, command);
            responseTextArea.appendText("\n命令发送成功: " + command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
