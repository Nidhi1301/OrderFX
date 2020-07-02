/**
 * Project - final
 * Name - NidhiNidhi 
 * Date - April,10 2020
 * This portion of code will help you to display and search customers.
 */
package content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayCustomer extends Stage {

    private TextArea displayCustomer = new TextArea();
    Pane pane = new Pane(displayCustomer);
    String elements = new String();


    public DisplayCustomer(String str) {
        elements = str;
        setScene(addScene());
    }

    private Scene addScene() {

        Scene scene = new Scene(getGrid(), 300, 240);
        return scene;

    }

    private GridPane getGrid() {
        displayCustomer.setText(elements);
        GridPane pane = new GridPane();
        pane.add(displayCustomer, 0, 0);
        return pane;
    }

}
