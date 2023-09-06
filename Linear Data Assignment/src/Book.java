public class Book {
    //Fields
    public String title;
    public String author;
    public int yearOfPublication;

    //Constructor
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = publicationYear;
    }

    //Set Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    //Get Methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    //toString is used to return a string rather than a HashCode
    public String toString() {
        return "This book is " + title + " whose author is " + author + " and was released in the year " + yearOfPublication;
    }
}