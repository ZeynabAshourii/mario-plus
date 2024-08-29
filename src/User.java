package src;

import java.io.*;
import java.util.LinkedList;

public class User implements Serializable {
    public String username;
    public String password;
    private static final String path = "D:\\github\\mario-plus\\a.txt";
    public static LinkedList<User> users = new LinkedList<>();
    public int coin = 0;
    public int maxScore = 0;
    public LinkedList<Integer> scores = new LinkedList<>();
    public boolean mario0 = true;
    public boolean mario1 = false;
    public boolean mario2 = false;
    public boolean mario3 = false;
    public boolean mario4 = false;
    public int typeMario = 0;
    public int s1 = 0;
    public int l1 = 0;
    public int s2 = 0;
    public int l2 = 0;
    public int s3 = 0;
    public int l3 = 0;
    public boolean game1 = false;
    public boolean game2 = false;
    public boolean game3 = false;
    private static LinkedList<String> reading = new LinkedList<>();

    public User(String username , String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
    }
    public static LinkedList<User> sortResultUsers(){
        LinkedList<User> sortUsers = new LinkedList<>();
        for(int i = 0; i < users.size(); i++){
            sortUsers.add(users.get(i));
        }
        User y;
        for (int i = 0; i < users.size(); i++) {
            for (int j = i+1 ; j < users.size(); j++) {
                if (sortUsers.get(i).maxScore < sortUsers.get(j).maxScore) {

                    y = sortUsers.get(i);

                    sortUsers.set(i , sortUsers.get(j));

                    sortUsers.set(j , y);
                }
            }
        }
        return sortUsers;
    }
    public int highestScore(){
        for(int i =0 ; i < this.scores.size(); i++){
            if(this.scores.get(i) > maxScore){
                maxScore = this.scores.get(i);
            }
        }
        return maxScore;
    }


//    public static User findUser(String username , String password){
//        User user = null;
//        for(int i = 0; i < users.size(); i++){
//            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
//                user = users.get(i);
//                findUser = true;
//                break;
//            }
//        }
//        return user;
//    }
//
//    public static void readUsers() throws FileNotFoundException {
//        reading = true;
//        String line = null;
//
//        try {
//            FileReader fr = new FileReader(path);
//
//            BufferedReader br = new BufferedReader(fr);
//
//            while( (line = br.readLine() ) != null ) {
//                userPas.add(line);
//            }
//
//            br.close();
//
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//        users = new LinkedList<>();
//
//        for(int i = 0 ; i < userPas.size()/2; i = i+2){
//            users.add(new User(userPas.get(i) , userPas.get(i+1)));
//        }
//        reading = false;
//    }
    public static void saveUser(User user , boolean b ) throws IOException {
        File file = new File(path);
        FileOutputStream fout1 = new FileOutputStream(file , b);
        PrintStream out1 = new PrintStream(fout1);
        out1.println(user.username);
        out1.println(user.password);
        out1.println(user.coin);
        out1.println(user.maxScore);
        out1.println(user.typeMario);
        out1.println(user.mario0);
        out1.println(user.mario1);
        out1.println(user.mario2);
        out1.println(user.mario3);
        out1.println(user.mario4);
        out1.println(user.s1);
        out1.println(user.l1);
        out1.println(user.s2);
        out1.println(user.l2);
        out1.println(user.s3);
        out1.println(user.l3);
        out1.println(user.game1);
        out1.println(user.game2);
        out1.println(user.game3);
    }
//    public static void writeUser(User user) throws IOException {
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("per2.txt"));
//
//        for(int i = 0; i < User.users.size(); i++){
//            objectOutputStream.writeObject(User.users.get(i));
//        }
//        try {
//            User.users.add(user);
//            objectOutputStream.writeObject(user);
//        } catch (IOException e) {
//
//            throw new RuntimeException(e);
//        }
//    }
//    public static void readUser() throws IOException {
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("per2.txt"));
//        Object obj = null;
//        try {
//            while (((obj = objectInputStream.readObject()) instanceof User)) {
//                users.add((User) obj);
//                //System.out.println(((User) obj).username + ((User) obj).password + ((User) obj).coin);
//                System.out.println(users.getLast().username + users.getLast().password  + users.getLast().coin + users.getLast().maxScore);
//            }
//        } catch (Exception e) {
//
//        }
//    }
    public static void readUser() throws IOException {
        String line = null;
        try {
            FileReader fr = new FileReader(path);

            BufferedReader br = new BufferedReader(fr);

            while( (line = br.readLine() ) != null ) {
                reading.add(line);
            }

            br.close();

        }
        catch(IOException e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i < reading.size(); i += 19){
            User user = new User(reading.get(i) , reading.get(i+1));
            user.coin = Integer.parseInt(reading.get(i+2));
            user.maxScore = Integer.parseInt(reading.get(i+3));
            user.typeMario = Integer.parseInt(reading.get(i+4));
            user.mario0 = Boolean.parseBoolean(reading.get(i+5));
            user.mario1 = Boolean.parseBoolean(reading.get(i+6));
            user.mario2 = Boolean.parseBoolean(reading.get(i+7));
            user.mario3 = Boolean.parseBoolean(reading.get(i+8));
            user.mario4 = Boolean.parseBoolean(reading.get(i+9));
            user.s1 = Integer.parseInt(reading.get(i+10));
            user.l1 = Integer.parseInt(reading.get(i+11));
            user.s2 = Integer.parseInt(reading.get(i+12));
            user.l2 = Integer.parseInt(reading.get(i+13));
            user.s3 = Integer.parseInt(reading.get(i+14));
            user.l3 = Integer.parseInt(reading.get(i+15));
            user.game1= Boolean.parseBoolean(reading.get(i+16));
            user.game2 = Boolean.parseBoolean(reading.get(i+17));
            user.game3 = Boolean.parseBoolean(reading.get(i+18));
//            System.out.println(reading.get(i) + " : " + i);
//            System.out.println(reading.get(i+1));
//            System.out.println(reading.get(i+2));
//            System.out.println(reading.get(i+3));
//            System.out.println(reading.get(i+4));
//            System.out.println(reading.get(i+5));
//            System.out.println(reading.get(i+6));
//            System.out.println(reading.get(i+7));
//            System.out.println(reading.get(i+8));
//            System.out.println(reading.get(i+9));
//            System.out.println(reading.get(i+10));
//            System.out.println(reading.get(i+11));
//            System.out.println(reading.get(i+12));
//            System.out.println(reading.get(i+13));
//            System.out.println(reading.get(i+14));
//            System.out.println(reading.get(i+15));
//            System.out.println(reading.get(i+16));
//            System.out.println(reading.get(i+17));
//            System.out.println(reading.get(i+18));
//            System.out.println(user.username + " " + user.password);
            users.add(user);
        }
    }
    public static void resetUser() throws IOException {
        saveUser(users.get(0) , false);
        for(int i = 1; i < User.users.size(); i++){
            saveUser(users.get(i) , true);
        }
    }
}
