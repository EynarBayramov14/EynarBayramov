import java.io.*;
import java.util.HashMap;
import java.util.Map;

class UserManager {
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public boolean registerUser(String username, String password, String role, String email) throws IOException {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, role, email));
        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
        writer.write(username + "," + password + "," + role + "," + email + "\n");
        writer.close();
        System.out.println("User registered successfully!");
        return true;
    }

    public User authenticate(String username, String password) throws IOException {
        User user = users.get(username);
        if (user != null && user.authenticate(username, password)) {
            return user;
        }
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(username) && parts[1].equals(password)) {
                return new User(parts[0], parts[1], parts[2], parts[3]);
            }
        }
        reader.close();

        return null;
    }

    public User getUserByEmail(String email) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[3].equals(email)) {
                return new User(parts[0], parts[1], parts[2], parts[3]);
            }
        }
        reader.close();
        return null;
    }

    public void sendMessageToSeller(String buyerUsername, String sellerUsername, String messageContent) {
        User seller = users.get(sellerUsername);
        if (seller != null) {
            seller.incrementMessageCount(buyerUsername);
            System.out.println("Message from " + buyerUsername + " to " + sellerUsername + ": " + messageContent);
        }
    }
}
