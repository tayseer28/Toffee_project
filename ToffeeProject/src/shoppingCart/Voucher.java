package shoppingCart;

public class Voucher {

    private int id;

    private static int Statid;
    private String code;
    private double price;

    static {
        Statid = 202100;
    }
    public Voucher(String code, double price) {
        this.code = code;
        this.price = price;
        id = Statid;
        Statid++;
    }

    public int getId() {
        return id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //
    public void buyVoucher(double price){
        this.price = price;

    }
}
