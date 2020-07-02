
/**
 * Project - final
 * Name - NidhiNidhi 
 * Date - April,10 2020
 * This portion of code will help you to display the products.
 */
package content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayProduct extends Stage {

    TextArea displayProduct = new TextArea();
    Pane pane = new Pane(displayProduct);
    String data = new String();

    public DisplayProduct(String str) {
        setScene(addScene());
        data = str;
    }

    private Scene addScene() {
        Scene scene = new Scene(getGrid(), 300, 240);
        return scene;

    }

    private GridPane getGrid() {
        displayProduct.setText(data);
        GridPane pane = new GridPane();
        pane.add(displayProduct, 0, 0);
        return pane;
    }

}
