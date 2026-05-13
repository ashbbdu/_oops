package Day3;

public class Book {
    String title;
    String author;
    double price;

    Book () {
        this.title = "N/A";
        this.author = "N/A";
        this.price = 0.0;
    }
    Book (String title , String author , double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display () {
        System.out.println("Book Name : " + title + " , Author : " + author + " , price : " + price);
    }
}
