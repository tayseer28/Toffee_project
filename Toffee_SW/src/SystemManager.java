import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class SystemManager {
    private ArrayList<UserAccount> userAccounts;
    private ArrayList<Order> orders;
    private ArrayList<Cart> carts;
    private Catalog catalogs;
    private Registration registration;
    private LogIN login;

    public SystemManager(ArrayList<UserAccount> userAccounts,  ArrayList<Order> orders, ArrayList<Cart> carts, Catalog catalogs, Registration registration, LogIN login)
    {
        this.userAccounts = userAccounts;
        this.orders = orders;
        this.carts = carts;
        this.catalogs = catalogs;
        this.registration = registration;
        this.login = login;
    }
    public SystemManager()
    {
        userAccounts = new ArrayList<>();
        orders = new ArrayList<>();
        carts = new ArrayList<>();
        catalogs = new Catalog();
        registration = new Registration();
        login = new LogIN();
    }
    public void systemInterface()
    {
        readUsers();
        catalogs.readItems();
        Cart cart = new Cart();
        cart.setCatalog(catalogs);


        while (true) {
            if(login.getloggedin() == false) {

                    System.out.println("Welcome to the system interface");
                    System.out.println("1. Registration");
                    System.out.println("2. Log in");
                    System.out.println("3. view catalog");
                    System.out.println("4. exit");
                    int choice;
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            registration.register();
                            userAccounts.add(registration.getUser());
                            break;
                        case 2:
                            login.logIn();
                            break;
                        case 3:
                            catalogs.display();
                            break;
                        case 4:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
            }
            else
            {
                System.out.println("Welcome to the system interface");
                System.out.println("1. view catalog");
                System.out.println("2. view cart");
                System.out.println("3. make order");
                System.out.println("4. exit");
                int choice;
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                cart.setUserAccount(login.getUser());


                switch (choice) {
                    case 1:
                        catalogs.display();
                        System.out.println("1. add item to cart");
                        System.out.println("2. exit");
                        int choice2;
                        choice2 = sc.nextInt();
                        if(choice2 == 1)
                        {
                            cart.addItemToCart();
                            carts.add(cart);
                            for(int i = 0; i < userAccounts.size(); i++)
                            {
                                if(userAccounts.get(i).getId() == login.getUser().getId())
                                {
                                    userAccounts.get(i).setCart(cart);
                                }
                            }
                          }
                        else if(choice2 == 2)
                            break;
                        else
                            System.out.println("Invalid choice");
                        break;
                    case 2:
                        cart.display();
                        break;
                    case 3:
                        Order order = new Order(cart);
                        orders.add(order);
                        order.placeOrder();



                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
    }
    public void readUsers(){

        File file = new File("users.txt");
        try(FileReader myReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(myReader)){

            String line;
            while((line = bufferedReader.readLine()) != null){
                UserAccount uc = new UserAccount();
                uc.setId(parseInt(line));
                uc.setUserName(bufferedReader.readLine());
                uc.setPassword(bufferedReader.readLine());
                uc.setEmail(bufferedReader.readLine());
                String add = bufferedReader.readLine();
                String word = "";
                Address address = new Address();
                int count = 1;
                for(int i = 0; i < add.length(); i++)
                {
                    if(add.indexOf(i) == '|' || i == add.length() - 1)
                    {
                        if(count == 1)
                            address.setGovernorate(word);
                        else if(count == 2)
                            address.setDistrict(word);
                        else if(count == 3)
                            address.setStreet(word);
                        else if(count == 4)
                            address.setBuildingNumber(parseInt(word));
                        else if(count == 5)
                            address.setFloorBuilding(parseInt(word));
                        else if(count == 6)
                            address.setFlatBuilding(parseInt(word));
                        else if(count == 7)
                            address.setLandMark(word);
                        count++;
                        word = "";
                    }
                    else
                        word += add.indexOf(i);
                }
                uc.setAddress(address);
                uc.setPhoneNum(bufferedReader.readLine());
                userAccounts.add(uc);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

}
