import java.util.Scanner;

interface Library_Item {         // Creating Library_Item interface
    public void borrow_Book ();     // Declearing abstract methods
    public void return_Book();
    public void check_Availability();
}   
interface Library_User {         // Creating Library_User interface
    public void get_Borrowing();    // Declearing abstract methods
    public void calculate_Fine();
}
interface Library_Transaction {     // Creating Library_Transaction 
    public void process_Transaction();      // Declearing abstract methnods
    public void generate_Receipt();
}
class Book implements Library_Item{     // Book class implementing the methods of the parent class Library Item
    public void borrow_Book () {
        
    }
    public void return_Book (){

    }
    public void check_Availability () {

    }
}
class Student implements Library_User {     // Student class implementing the methods of the parent class Library User
    public void get_Borrowing () {

    }
    public void calculate_Fine (){

    }
}   
class Faculty implements Library_User {     // Faculty class implementing the methods of the parent class Library User
    public void get_Borrowing () {

    }
    public void calculate_Fine () {

    }
}
class Member implements Library_User {      // Member class implementing the methods of the parent class Library User
    public void get_Borrowing () {

    }
    public void calculate_Fine () {

    }
}
class borrow_Transaction implements Library_Transaction {       // Borrow Transaction class implement the abstract methods of super class Library Transaction
    public void process_Transaction () {

    }
    public void generate_Receipt () {

    }
}
class Books {        // Creating this class for the attributes of book and to get and set(change details) them   COMPLETED 
    private String book_Name;
    private String author_Name;
    private double book_Price;
    private String publisher_Name;
    private int book_Quantity;

    Books (String book_Name, String author_Name, double book_Price, int book_Quantity, String publisher_Name) {     // Initializing the attributes of book 
        this.book_Name = book_Name;
        this.author_Name = author_Name;
        this.book_Price = book_Price;
        this.book_Quantity = book_Quantity;
        this.publisher_Name = publisher_Name;
    }
    public String get_Book_Name () {        // The following methods to get the attributes of book
        return book_Name;
    }
    public String get_Author_Name () {
        return author_Name;
    }
    public double get_Book_Price () {
        return book_Price;
    }
    public String get_Publisher_Name () {
        return publisher_Name;
    }
    public int get_Book_Quantity () {
        return book_Quantity;
    }

    public void set_Book_Name (String new_Book_Name) {      // The following methods to change the attributes of books
        this.book_Name = new_Book_Name;
    }
    public void set_Author_Name (String new_Author_Name){
        this.author_Name = new_Author_Name;
    }
    public void set_Book_Price (double new_Book_Price) {
        this.book_Price = new_Book_Price;
    } 
    public void set_Publisher_Name (String new_Publisher_Name) {
        this.publisher_Name = new_Publisher_Name;
    }
    public void set_Book_Quantity (int new_Book_Quantity){
        this.book_Quantity = new_Book_Quantity;
    }
}

class Book_Inventory {      // Creating this class to manage books          COMPLETED 
    Books[] books;
    int allotable_Books;
    int book_Index;
    int deleted_index;

    Book_Inventory (int allotable_Books) {      // Taking the number of books 
        this.allotable_Books = allotable_Books;
        book_Index = 0;
    }
    public void add_Book (Books book) {         // To add new books 
        if  (books[deleted_index] == null) {
            books[deleted_index] = book;

        } else if (book_Index < allotable_Books) {

           books[book_Index] = book;
           book_Index++;
        } else {
            System.out.println("Sorry, no product is present in the book inventory with this name.");
        }
    }
    public void remove_Book (String book_Name) {        // To remove books 
        boolean found = false;

        for (deleted_index = 0; deleted_index < book_Index; deleted_index++){       // Finding the book
            if (book_Name.equals(books[deleted_index].get_Book_Name())) {
                books[deleted_index] = null;
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Sorry, no book is present in the book inventory with this name.");
        }
    }
    public void Update_Quantity (String book_Name, int borrowed_Quantity){      // To update the quantity of a book based on borrowing and returning 
        boolean found = false;

        for (int index = 0; index < book_Index; index++) {
            if (book_Name.equals(books[index].get_Book_Name())) {
                books[index].set_Book_Quantity(borrowed_Quantity);
                break;
            }
        }
        if (found == false) {
            System.out.println("Sorry, no book is present in the book inventory with this name.");
        }
    }
    public void display_Book_Inventory () {         // To find the details of all book 
        for (int index = 0; index < book_Index; index++) {
            System.out.println("Book name: "+books[index].get_Book_Name()+" | Author name: "+books[index].get_Author_Name()+" | Quantity: "+books[index].get_Book_Quantity()+" | Price: "+books[index].get_Book_Price()+" | Publisher name: "+books[index].get_Publisher_Name());
        }
    }
    public void particular_Book_Details (String book_Name) {        // To find the details of a particular book 
        boolean found = false;

        for (int index = 0; index < book_Index; index++) {
            if (book_Name.equals(books[index].get_Book_Name())) {
                System.out.println("Book name: "+books[index].get_Book_Name()+" | Author name: "+books[index].get_Author_Name()+" | Quantity: "+books[index].get_Book_Quantity()+" | Price: "+books[index].get_Book_Price()+" | Publisher name: "+books[index].get_Publisher_Name());    
                found = true;
                break;
            }
        }
        if (found == false ) {
            System.out.println("Sorry, no product is present in the inventory with this name.");
        }
    }
}
public class Library_Management_System {
    Scanner var;

    public void forntend_First_Part () {            // First forntend part
        System.out.println("Welcome to our Library Management System (LMS).");
        System.out.println("Here we provide 2 types of interface for both customer and staffs.");
        System.out.println(" ---------------------------------------------------------------------------");
        System.out.println("Sign in as a:");
        System.out.println("    1. If as a Customer then, 'Customer'");
        System.out.println("    2. If as a Staff then, 'Staff'\n");
        this.backend_Choose_Type();
    }
    public void frontend_Sub_Customer () {      // To show the sub parts of a cutomer
        System.out.println("Menue:");
        System.out.println("    1. If you are a student enter 'Student'");
        System.out.println("    2. If you are a professor enter 'Professor'");
        System.out.println("    3. If you are a Staff enter 'Staff'");
    }
    public void frontend_Customer_Menu () {      // To show the options for a customer
        System.out.println("Menue:");
        System.out.println("    1. To borrow a book enter 'BB'");
        System.out.println("    2. To return a book enter 'RB'");
        System.out.println("    3. To check whether a book is available or not 'CAB'");
        System.out.println("    4. To see the number of book that are available along with their details enter 'SDAB");
        System.out.println("    5. To see the deatils of a particular book enter 'SDPB'");
    }
    public void frontend_Staff_Menue () {        // To show the options for a staff or worker 
        System.out.println("Menue:");
        System.out.println("    1. To add a new book to the inventory enter 'ANB'");
        System.out.println("    2. to remove a book from the inventory enter 'RB");
        System.out.println("    3. To update the quantity of a book enter 'UQ;");
        System.out.println("    4. To see the deatail of all book enter 'SDAB'");
        System.out.println("    5. To see the details of a particular book etner 'SDPB");
        System.out.println("    6. To change the details of a book etner 'CDB'");
        this.backend_Staff();
    }
    

    public void backend_Choose_Type () {                 // To chose the type of user
        System.out.println("Please enter your order:");     // Taking user input 
        var = new Scanner(System.in);
        String user_Order = var.next();
        if (user_Order.equals("Customer")) {
            this.frontend_Sub_Customer();
        } else {
            this.frontend_Staff_Menue();
        }
    }
    public void backend_Staff () {          // To opeate the function of staff menue

        System.out.println("Please enter your order:");
        var = new Scanner (System.in);      
        String staff_word = var.next();

        switch (staff_word) {
            case "ANB":     // To add new book 
                System.out.println("Please enter the name of the new book:");
                String new_Book_Name  = var.nextLine();
                System.out.println("Please enter the author name of the new booK:");
                String author_Name_New_Book = var.nextLine();
                System.out.println("Please enter the price of the new book:");
                double new_Book_Price = var.nextDouble();
                System.out.println("Please enter the quantity of the new book:");
                int new_Book_Quantity = var.nextInt();
                System.out.println("Please enter the publisher name of the new book:");
                String new_Book_Publisher_Name = var.nextLine();

                // UNCOMPLETE
                break;
            case "RB":
                System.out.println("Please enter the name of book that you want to remove:");
                String remove_Book_Name = var.nextLine();
                
                break;
            case "UQ":

                break;
            case "SDAB":

                break;
            case "SDPB":

                break;
            case "CDB":

                break;
            default:
                
        } 
    }
    public static void main(String[] args) {
        Book_Inventory bi = new Book_Inventory(100);        // Giving the number of books that the library can hold 

        // Initializing the books
        Books book1 = new Books("Atomic Habits", "James Clear", 528.00, 10, "Penguin Random House");       
        Books book2 = new Books("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 320.00, 20, "Bloomsbury");
        Books book3 = new Books("To Kill a Mockingbird", "Harper Lee", 336.00, 15, "J.B. Lippincott & Co.");
        Books book4 = new Books("1984", "George Orwell", 328.00, 25, "Secker & Warburg");
        Books book5 = new Books("The Great Gatsby", "F. Scott Fitzgerald", 180.00, 18, "Charles Scribner's Sons");
        Books book6 = new Books("The Catcher in the Rye", "J.D. Salinger", 224.00, 12, "Little, Brown and Company");
        Books book7 = new Books("Pride and Prejudice", "Jane Austen", 279.00, 30, "T. Egerton, Whitehall");
        Books book8 = new Books("The Hobbit", "J.R.R. Tolkien", 310.00, 22, "George Allen & Unwin");
        Books book9 = new Books("The Chronicles of Narnia", "C.S. Lewis", 768.00, 8, "Geoffrey Bles");
        Books book10 = new Books("The Lord of the Rings", "J.R.R. Tolkien", 1178.00, 7, "George Allen & Unwin");
        Books book11 = new Books("Crime and Punishment", "Fyodor Dostoevsky", 671.00, 9, "The Russian Messenger");
        Books book12 = new Books("The Brothers Karamazov", "Fyodor Dostoevsky", 796.00, 11, "The Russian Messenger");
        Books book13 = new Books("Moby-Dick", "Herman Melville", 720.00, 14, "Richard Bentley");
        Books book14 = new Books("War and Peace", "Leo Tolstoy", 1225.00, 16, "The Russian Messenger");
        Books book15 = new Books("Anna Karenina", "Leo Tolstoy", 864.00, 19, "The Russian Messenger");
        Books book16 = new Books("The Picture of Dorian Gray", "Oscar Wilde", 254.00, 23, "Ward, Lock & Co.");
        Books book17 = new Books("Les Misérables", "Victor Hugo", 1463.00, 6, "A. Lacroix, Verboeckhoven & Cie.");
        Books book18 = new Books("The Adventures of Huckleberry Finn", "Mark Twain", 366.00, 20, "Charles L. Webster & Company");
        Books book19 = new Books("The Adventures of Tom Sawyer", "Mark Twain", 219.00, 18, "American Publishing Company");
        Books book20 = new Books("The Grapes of Wrath", "John Steinbeck", 464.00, 15, "The Viking Press");
        Books book21 = new Books("The Old Man and the Sea", "Ernest Hemingway", 127.00, 25, "Charles Scribner's Sons");
        Books book22 = new Books("Brave New World", "Aldous Huxley", 311.00, 14, "Chatto & Windus");
        Books book23 = new Books("The Odyssey", "Homer", 382.00, 20, "Unknown");
        Books book24 = new Books("The Divine Comedy", "Dante Alighieri", 798.00, 11, "Unknown");
        Books book25 = new Books("Frankenstein", "Mary Shelley", 280.00, 16, "Lackington, Hughes, Harding, Mavor & Jones");
        Books book26 = new Books("Dracula", "Bram Stoker", 418.00, 9, "Archibald Constable and Company");
        Books book27 = new Books("The Scarlet Letter", "Nathaniel Hawthorne", 238.00, 13, "Ticknor, Reed & Fields");
        Books book28 = new Books("The Count of Monte Cristo", "Alexandre Dumas", 1276.00, 7, "Pétion");
        Books book29 = new Books("Alice's Adventures in Wonderland", "Lewis Carroll", 192.00, 30, "Macmillan");
        Books book30 = new Books("Through the Looking-Glass", "Lewis Carroll", 224.00, 28, "Macmillan");

        bi.add_Book(book1);     // Adding the books to the inventory
        bi.add_Book(book2);
        bi.add_Book(book3);
        bi.add_Book(book4);
        bi.add_Book(book5);
        bi.add_Book(book6);
        bi.add_Book(book7);
        bi.add_Book(book8);
        bi.add_Book(book9);
        bi.add_Book(book10);
        bi.add_Book(book11);
        bi.add_Book(book12);
        bi.add_Book(book13);
        bi.add_Book(book14);
        bi.add_Book(book15);
        bi.add_Book(book16);
        bi.add_Book(book17);
        bi.add_Book(book18);
        bi.add_Book(book19);
        bi.add_Book(book20);
        bi.add_Book(book21);
        bi.add_Book(book22);
        bi.add_Book(book23);
        bi.add_Book(book24);
        bi.add_Book(book25);
        bi.add_Book(book26);
        bi.add_Book(book27);
        bi.add_Book(book28);
        bi.add_Book(book29);
        bi.add_Book(book30);

    }
}