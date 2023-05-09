import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogIN {
    private String username;
    private String password;

    public LogIN(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean isExist(String userN, String pass){

        File file = new File("users.txt");
        try(FileReader myReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(myReader)){

            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.equals(userN)){
                    line = bufferedReader.readLine();
                    if(line.equals(pass))
                    {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    void login(){


        Scanner input = new Scanner(System.in);
        String userN, pass;

        do{
            System.out.println("Enter your username: ");
            userN = input.nextLine();
            System.out.println("Enter your password: ");
            pass = input.nextLine();
            if(isExist(userN, pass)){
                System.out.println("Welcome " + userN);
            }
            else{
                System.out.println("Invalid username or password");
            }

        }while (!isExist(userN, pass));



    }
}
