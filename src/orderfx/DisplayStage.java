/**
 * Project - final
 * Name - NidhiNidhi 
 * Date - April,10 2020
 */

package orderfx;

import content.Order;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class DisplayStage extends Stage{
    private final ArrayList<Order> orderList;
    public DisplayStage(ArrayList<Order> orderList) {
        this.orderList = orderList;
        setScene(addScene());
    }
    String elements = new String();
    TextArea txtDisplay = new TextArea();

    private Scene addScene() {

       for (int i = 0; i < orderList.size(); i++) {
            Order one = orderList.get(i);
            elements += "Order Id:" + one.getOrderId() + "\n" 
                            + "CustomerId :" + one.getCustomerId() + "\n" 
                            + "Product" + one.getProduct()+ "\n" 
                            + "Shipping :" + one.getShipping()+ "\n" 
                            +".....................";
                
        }
        txtDisplay.setText(elements);

        Scene scene = new Scene(getGrid(), 320, 240);
        return scene;

    }

    private GridPane getGrid() {

        GridPane pane = new GridPane();
        pane.add(txtDisplay, 0, 0);
        return pane;
    }
}
