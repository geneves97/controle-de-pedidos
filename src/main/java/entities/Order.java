package entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;
import lombok.Data;

@Data
public class Order {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Instant moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();


    public Order(){}

    public Order(Instant moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0.0;
        for(OrderItem it : items){
            sum += it.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {

        LocalDateTime dt = LocalDateTime.ofInstant(moment, ZoneId.systemDefault());

        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(dt.format(formatter) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
