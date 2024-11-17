package model;

/**
 * The User class represents a user in the application.
 * It contains the user's personal information such as their name, surname, birthday, and role.
 */
public class User {
    
    // The name of the user.
    String name;
    
    // The surname of the user.
    String surname;
    
    // The birthday of the user in string format (e.g., "dd/mm/yyyy").
    String birthday;
    
    // The role of the user, typically represented as an integer.
    int role;
    
    /**
     * Constructor to initialize the User object with provided details.
     * 
     * @param name The name of the user.
     * @param surname The surname of the user.
     * @param birthday The user's birthday in string format.
     * @param role The user's role as an integer (1 - Normal User | 2 = Manager | 3 = Developer)
     */
    public User(String name, String surname, String birthday, int role){
        this.name = name;        
        this.surname = surname;  
        this.birthday = birthday; 
        this.role = role;    
    }
}