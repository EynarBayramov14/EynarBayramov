import java.util.HashSet;
import java.util.Set;

class User {
    private String username;
    private String password;
    private String role; // Admin, Seller, Buyer, Agent
    private String email;
    private int messageCount;
    private Set<String> messageSenders;

    public User(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.messageCount = 0;
        this.messageSenders = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public Set<String> getMessageSenders() {
        return messageSenders;
    }

    public void incrementMessageCount(String sender) {
        messageCount++;
        messageSenders.add(sender);
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", role='" + role + '\'' + "}";
    }
}