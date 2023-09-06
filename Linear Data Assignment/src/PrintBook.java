public class PrintBook extends Book {
    //Fields
    public String publisher;
    public int isbn;

    //Constructor
    public PrintBook(String title, String author, int publicationYear, String publisher, int isbn) {
        super(title, author, publicationYear);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "This name of the book is " + title +
                "\n The author is " + author +
                "\n It was released in the year " + yearOfPublication +
                "\n The publisher of the book is " + publisher +
                "\n The ISBN number of the book is " + isbn;
    }
}
