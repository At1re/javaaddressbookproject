import java.util.ArrayList;
import java.util.Scanner;

record Contact(String name, String phoneNumber) {

    @Override
    public String toString() {
        return "Name: " + name + "\tPhone Number: " + phoneNumber;
    }
}

public class AddressBook {
    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public AddressBook() {
    }

    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.viewContacts();
                    break;
                case 3:
                    System.out.println("Exiting the Address Book. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        }
    }
}
