package entities;

import entities.enums.OrderStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();


    public Order(){}

    public Order(Date moment, OrderStatus status, Client client) {
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
}
