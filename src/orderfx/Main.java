/**
 * Project - final Name - NidhiNidhi 
 * Date - April,10 2020
 * This code will give you an idea about taking orders , 
 * displaying orders , searching new orders,saving orders in file,
 * getting orders from file , using previous , next buttons. 
 */
package orderfx;

import content.DisplayCustomer;
import content.DisplayProduct;
import content.Order;
import content.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final Label lblOrderId = new Label("Order Id");
    private final TextField txtOrderId = new TextField();
    private final Label lblCustomerId = new Label("Customer Id:");
    private TextField txtCustomerId = new TextField();
    private final Label lblProduct = new Label("Product");
    private final TextField txtProduct = new TextField();
    private final Label lblShipping = new Label("Shipping Method :");
    private final TextField txtShipping = new TextField();
    private final Label lblCustomer = new Label("Enter Customer Id :");
    private TextField displayCustomer = new TextField();
    private final Label lblProductName = new Label("Enter Product name :");
    private TextField displayProduct = new TextField();
    private Button btnnext = new Button("Next");
    private Button btnprevious = new Button("Previous");
    private Button btnlast = new Button("Last");
    private Button btnfirst = new Button("First");
    private Button btnupdate = new Button("Update");
    private Button btnDlt = new Button("Delete");
    private Button btnadd = new Button("Add");
    private Button btnsearchCust = new Button("Search Customer");
    private Button btnsearchProdt = new Button("Search Product");
    private Button btnDisplay = new Button("Display");

   
    private ArrayList<Order> orderList;
    private int a;
    boolean change;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            orderList = OrderFile.getData();
            OrderFile.setData(orderList);
        } catch (IOException ex) {

            System.out.println(ex);
        }

        btnfirst.setOnAction(e -> {
            Order one = orderList.get(0);
            process(one);

        });
        btnlast.setOnAction(e -> {
            Order two = orderList.get(orderList.size() - 1);
            process(two);

        });
        btnnext.setOnAction(e -> {
            a++;
            Order three = orderList.get(a);
            process(three);

        });

        btnprevious.setOnAction(e -> {
            a--;
            Order four = orderList.get(a);
            process(four);

        });

        btnupdate.setOnAction(e -> {
            Order five = orderList.get(a);

            Alert dlgconfrm = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> record = dlgconfrm.showAndWait();
            if (change) {
                addNew();
            }
            if (record.get() == ButtonType.OK) {
                modify();
            } else {

                process(five);
            }
            Alert dlgMsg = new Alert(Alert.AlertType.INFORMATION);
            orderList.add(five);
            dlgMsg.setContentText("confirm");
            dlgMsg.show();
            try {
                OrderFile.setData(orderList);

            } catch (IOException ep) {
                System.out.println("Add is not done");

            }

        });
        btnadd.setOnAction(e -> {

            txtOrderId.clear();
            txtCustomerId.clear();
            txtProduct.clear();
            txtShipping.clear();

            change = true;
        });
        btnDlt.setOnAction(e -> {
            Alert digConf = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> record = digConf.showAndWait();
            if (record.get() == ButtonType.OK) {
                orderList.remove(a);
                Order six = orderList.get(a);
                process(six);

            } else {
                Order six = orderList.get(a);
                process(six);

            }
            Alert dlgMsg = new Alert(Alert.AlertType.INFORMATION);
            dlgMsg.setContentText("confirm");
            dlgMsg.show();
            try {
                OrderFile.setData(orderList);

            } catch (IOException ep) {
                System.out.println("Add is not done");

            }

        });

        btnsearchCust.setOnAction(e -> {
            String find = displayCustomer.getText();
            String str = new String();
            for (int i = 0; i < orderList.size(); i++) {

                Order seven = orderList.get(a);
                if (seven.getCustomerId().equals(find)) 
                    str += "Order Id:" + seven.getOrderId() + "\n" 
                            + "CustomerId :" + seven.getCustomerId() + "\n" 
                            + "Product" + seven.getProduct()+ "\n" 
                            + "Shipping :" + seven.getShipping();
                

            }
            DisplayCustomer dc = new DisplayCustomer(str);
            dc.show();

        });
        btnsearchProdt.setOnAction(e -> {
            String datap = displayProduct.getText();
            String st = new String();
            for (int i = 0; i < orderList.size(); i++) {

                Order eight = orderList.get(i);
                if (eight.getProduct().equals(datap)) 
                    st += "Order Id:" + eight.getOrderId() + "\n" 
                            + "CustomerId :"+ eight.getCustomerId() + "\n" 
                            + "Product"  + eight.getProduct() + "\n" 
                            + "Shipping :" + eight.getShipping();
             
            }
            DisplayProduct dp = new DisplayProduct(st);
            dp.show();

        });
        btnDisplay.setOnAction(e -> {
        DisplayStage ds = new DisplayStage(orderList);
            ds.show();
        });
        Scene scene = new Scene(addPane(), 370, 250);
        primaryStage.setTitle("Order Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private void process(Order one) {

        txtOrderId.setText(one.getOrderId());
        txtCustomerId.setText(one.getCustomerId());
        txtProduct.setText(one.getProduct());
        txtShipping.setText(one.getShipping());

    }

    private void modify() {
        Order five = orderList.get(a);

        String product = txtProduct.getText();
        String shipping = txtShipping.getText();
        txtProduct.setText(product);
        txtShipping.setText(shipping);

        five.setProduct(product);
        five.setShipping(shipping);

    }

    private void addNew() {
        String orderId = txtOrderId.getText();
        String customerId = txtCustomerId.getText();
        String product = txtProduct.getText();
        String shipping = txtShipping.getText();
        Order add = new Order(orderId);
        add.setCustomerId(customerId);
        add.setProduct(product);
        add.setShipping(shipping);
        orderList.add(add);

    }

    private GridPane addPane() {

        GridPane pane = new GridPane();
        pane.add(lblOrderId, 0, 1);
        pane.add(txtOrderId, 1, 1);
        pane.add(lblCustomerId, 0, 2);
        pane.add(txtCustomerId, 1, 2);
        pane.add(lblProduct, 0, 3);
        pane.add(txtProduct, 1, 3);
        pane.add(lblShipping, 0, 4);
        pane.add(txtShipping, 1, 4);
        pane.add(btnnext, 0, 6);
        pane.add(btnprevious, 1, 6);
        pane.add(btnfirst, 0, 5);
        pane.add(btnlast, 1, 5);
        pane.add(btnupdate, 2, 5);
        pane.add(btnDlt, 2, 6);
        pane.add(btnadd, 0, 7);
        pane.add(btnDisplay, 1, 7);
        pane.add(lblCustomer, 0, 8);
        pane.add(displayCustomer, 1, 8);
        pane.add(btnsearchCust, 2, 8);
        pane.add(lblProductName, 0, 9);
        pane.add(displayProduct, 1, 9);
        pane.add(btnsearchProdt, 2, 9);

        return pane;
    }

    public static void main(String[] args) {
        launch(args);

    }

}
