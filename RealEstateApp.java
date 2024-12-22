class CommandHandler {
    private UserManager userManager;
    private PropertyManager propertyManager;
    private User currentUser;

    public CommandHandler() {
        this.userManager = new UserManager();
        this.propertyManager = new PropertyManager();
    }

    public void startApplication() {
        System.out.println("Welcome to the Real Estate Application!");
        // Placeholder for application logic
    }
}

public class RealEstateApp {
    public static void main(String[] args) {
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.startApplication();
    }
}