/*package user;

import shoppingCart.Address;
import shoppingCart.Cart;
import catalog.Catalog;
import catalog.Item;
import shoppingCart.Order;
import shoppingCart.Voucher;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Customer extends UserAccount{

    private int loyaltyPoints;
    private Address address;

    private Cart cart;
    private ArrayList<Voucher> vouchers;

    public Customer(String userName, String password, String status, String email,String governorate, String district, String street, int buildingNumber, int floorBuilding, String flatBuilding, String landMark) {
        super(userName, password, status, email);
        this.address = new Address(governorate, district, street, buildingNumber, floorBuilding, flatBuilding, landMark);
    }

    public void selectItem(LocalDateTime dateOfCheckout, Item i){
        Order o = new Order(dateOfCheckout, i);
        cart.addOrder(o);
    }

    public void addVoucher(Voucher v){
        vouchers.add(v);
    }


}
*/