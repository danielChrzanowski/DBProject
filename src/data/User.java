package data;

//Singleton
public class User {

    static User user;
    public static String login, databaseName;

    private User() {
    }

    public static User getUser() {
        if (user == null) {
            user = new User();
        }

        return user;
    }
}
