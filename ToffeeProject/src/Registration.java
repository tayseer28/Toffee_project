

import java.io.*;
import java.util.Scanner;


public class Registration {

    private String userName;
    private String password;
    private String email;

    private Address address;

    private  String phoneNum;

    //password validation
    private String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private String phonePattern= "^01[0-2]\\d{1,8}$";



    public void WriteToFile(){

        try(FileWriter myWriter = new FileWriter("users.txt", true);
            BufferedWriter bw = new BufferedWriter(myWriter);) {
            bw.write(userName);
            bw.write("\n");
            bw.write(password);
            bw.write("\n");
            bw.write(email);
            bw.write("\n");
            bw.write(address.getGovernorate() + " | " + address.getDistrict() + " | " + address.getStreet() + " | " + address.getBuildingNumber() + " | " + address.getFloorBuilding() + " | " + address.getFlatBuilding() + " | " + address.getLandMark());
            bw.write("\n");
            bw.write(phoneNum);
            bw.write("\n");
            bw.close();

            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    boolean isExist(String userN){

        File file = new File("users.txt");
        try(FileReader myReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(myReader)){

            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.equals(userN)){
                    System.out.println("user is exist");
                    bufferedReader.close();
                    return true;
                }
            }
            bufferedReader.close();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }


    public void getAddressInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your governorate: ");
        String governorate = input.nextLine();
        System.out.println("Enter your district: ");
        String district = input.nextLine();
        System.out.println("Enter your street: ");
        String street = input.nextLine();
        System.out.println("Enter your building number: ");
        int buildingNumber = input.nextInt();
        input.nextLine();

        System.out.println("Enter your floor number: ");
        int floorBuilding = input.nextInt();
        input.nextLine();
        System.out.println("Enter your flat number: ");
        int flatBuilding = input.nextInt();
        input.nextLine();
        System.out.println("Enter your landmark: ");
        String landMark = input.nextLine();
        this.address = new Address(governorate, district, street, buildingNumber, floorBuilding, flatBuilding, landMark);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if(password.matches(pattern)){
            this.password = password;
            return true;
        }
        else{
            System.out.println("Password is not valid");
            return false;
        }

    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.matches(emailRegex)){
            this.email = email;
            return true;
        }
        else{
            System.out.println("Email is not valid");
            return false;
        }

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public boolean setPhoneNum(String phoneNum) {
        if(phoneNum.matches(phonePattern)){
            this.phoneNum = phoneNum;
            return true;
        }
        else{
            System.out.println("Phone number is not valid");
            return false;
        }

    }
    public void register(){
        String pass, e, phone,user;

            do {
                Scanner input = new Scanner(System.in);

                System.out.println("Enter your username: ");

                user = input.nextLine();

                setUserName(user);

                System.out.println("Enter your password: ");

                 pass = input.nextLine();

                System.out.println("Enter your email: ");

                 e = input.nextLine();


                System.out.println("Enter your phone number: ");

                 phone = input.nextLine();

                getAddressInfo();

            }
            while(isExist(user)||!setPassword(pass)|| !setEmail(e) || !setPhoneNum(phone) );
            WriteToFile();



    }

}
