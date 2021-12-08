
package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Food {
    private String m_name;
    private int m_price;
    private AtomicInteger amountOfOrders;
    private int result = 0;

    public Food(){}
    public Food(String name, int price) {
        setName(name);
        setPrice(price);
        setAmountOfOrders(new AtomicInteger(0));

    }

    public String getName() {
        return m_name;
    }

    private void setName(String m_name) {
        this.m_name = m_name;
    }

    public int getPrice() {
        return m_price;
    }

    private void setPrice(int m_price) {
        this.m_price = m_price;
    }

    private void setAmountOfOrders(AtomicInteger amountOfOrders) {
        this.amountOfOrders = amountOfOrders;
    }

    public AtomicInteger getAmountOfOrders() {
        return amountOfOrders;
    }

    @Override
    public String toString() {
        return getName() + " - " + getPrice() + " tg";
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void addProductPrice(int n){
        this.result += n;
    }
}

