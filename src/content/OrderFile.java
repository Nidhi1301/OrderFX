/**
 * Project - final
 * Name - NidhiNidhi 
 * Date - April,10 2020
 * This part of code will get the data from file and saves data in file
 */
package content;

import content.Order;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrderFile {

    public static ArrayList<Order> getData()
            throws IOException {

        ArrayList<Order> orderList = new ArrayList<>();

        try (FileReader fr = new FileReader("Order.dat"); 
                BufferedReader br = new BufferedReader(fr)) {
            
            String line = br.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreTokens()){
                String orderId = st.nextToken();
                String customerId = st.nextToken();
                String product = st.nextToken();
                String shipping = st.nextToken();
                
                Order one = new Order(orderId);
                one.setCustomerId(customerId);
                one.setProduct(product);
                one.setShipping(shipping);
                
                orderList.add(one);
                }
                line = br.readLine();
            }
        }

        return orderList;
    }

    public static void setData(ArrayList<Order> orderList)
            throws IOException {

        try (FileWriter fw = new FileWriter("Order.dat"); 
                BufferedWriter bw = new BufferedWriter(fw)) {
            
            for (Order one : orderList) {
                String data = ( one.getOrderId() + "," + one.getCustomerId() +
                        "," + one.getProduct() + "," + one.getShipping());
                
                bw.write(data);
                bw.newLine();
            }
        }

    }

}
