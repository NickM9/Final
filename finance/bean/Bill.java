package by.epam.finance.bean;

import java.io.Serializable;

public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    private int sum;


    public Bill() {
    }


    public Bill(int sum) {

        this.sum = sum;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        return sum == bill.sum;
    }

    @Override
    public int hashCode() {
        return sum;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "sum=" + sum +
                '}';
    }
}
