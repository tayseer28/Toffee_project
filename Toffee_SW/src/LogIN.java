import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class LogIN {
    private String username;
    private String password;
    private boolean loggedin;
    private UserAccount user;

    public LogIN() {
        this.username = "";
        this.password = "";
    }

    boolean isExist(String userN, String pass){


        File file = new File("users.txt");
        try(FileReader myReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(myReader)){
            String id = new String();
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.equals(userN)){
                    line = bufferedReader.readLine();
                    if(line.equals(pass))
                    {
                        joinUSer(parseInt(id));
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                id = line;
            }
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    void logIn(){

        Scanner input = new Scanner(System.in);
        String userN, pass;

        do{
            System.out.println("Enter your username: ");
            userN = input.nextLine();
            System.out.println("Enter your password: ");
            pass = input.nextLine();
            if(isExist(userN, pass)){
                username=userN;
                password=pass;
                System.out.println("Welcome " + userN);
            }
            else{
                System.out.println("Invalid username or password");
            }

        }while (!isExist(userN, pass));
        loggedin=true;



    }
    public void setLoggedin(boolean loggedin){
        this.loggedin=loggedin;
    }
    boolean getloggedin(){
        return loggedin;
    }

    public void joinUSer(int id)
    {
        File file = new File("users.txt");
        try(FileReader myReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(myReader)){

            String line;
            user = new UserAccount();
            while((line = bufferedReader.readLine()) != null){
                if(line.equals(Integer.toString(id)))
                {
                    user.setId(id);
                    line = bufferedReader.readLine();
                    user.setUserName(line);
                    line = bufferedReader.readLine();
                    user.setPassword(line);
                    line = bufferedReader.readLine();
                    user.setEmail(line);

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
                    line = bufferedReader.readLine();
                    user.setPhoneNum(line);
                    user.setAddress(address);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
