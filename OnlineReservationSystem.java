import java.util.*;

public class OnlineReservationSystem {
  
    static HashMap<String, String> reservations = new HashMap<>();
    static HashMap<String, String> users = new HashMap<>(); // userId ? password

   
    public static void registerUser(Scanner sc) {
        System.out.print("Enter new User ID: ");
        String userId = sc.nextLine();
        if (users.containsKey(userId)) {
            System.out.println("User ID already exists!\n");
            return;
        }
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        users.put(userId, password);
        System.out.println("Registration Successful!\n");
    }

   
    public static String loginPrompt(Scanner sc) {
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (users.containsKey(userId) && users.get(userId).equals(password)) {
            System.out.println("Login Successful!\n");
            return userId;
        } else {
            System.out.println("Invalid credentials.\n");
            return null;
        }
    }

    
    public static void reserveTicket(Scanner sc, String userId) {
        System.out.println("=== Reservation Form ===");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        String trainNo = sc.nextLine();
        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();
        System.out.print("Enter Date of Journey: ");
        String date = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();

        String pnr = "PNR" + (int)(Math.random() * 10000);
        String details = "User: " + userId + ", Name: " + name + ", Train: " + trainNo +
                         ", Class: " + classType + ", Date: " + date +
                         ", Route: " + from + " ? " + to;
        reservations.put(pnr, details);

        System.out.println("Ticket Reserved! Your PNR: " + pnr + "\n");
    }

   
    public static void cancelTicket(Scanner sc) {
        System.out.print("Enter PNR to cancel: ");
        String pnr = sc.nextLine();
        if (reservations.containsKey(pnr)) {
            System.out.println("Reservation Found: " + reservations.get(pnr));
            System.out.print("Confirm cancellation (Y/N): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                reservations.remove(pnr);
                System.out.println("Cancellation Confirmed.\n");
            } else {
                System.out.println("Cancellation Aborted.\n");
            }
        } else {
            System.out.println("PNR not found.\n");
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Online Reservation System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: registerUser(sc); break;
                case 2:
                    String userId = loginPrompt(sc);
                    if (userId != null) {
                        while (true) {
                            System.out.println("1. Reserve Ticket");
                            System.out.println("2. Cancel Ticket");
                            System.out.println("3. Logout");
                            System.out.print("Enter choice: ");
                            int subChoice = sc.nextInt();
                            sc.nextLine();
                            if (subChoice == 1) reserveTicket(sc, userId);
                            else if (subChoice == 2) cancelTicket(sc);
                            else if (subChoice == 3) break;
                            else System.out.println("Invalid choice.\n");
                        }
                    }
                    break;
                case 3: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice.\n");
            }
        }
    }
}