public class AudioBook extends Book{
    //Fields
    public double bookSize;
    public double playLength;
    public String playbackArtist;

    //Constructor
    public AudioBook(String title, String author, int publicationYear, double bookSize, double playLength, String playbackArtist) {
        super(title, author, publicationYear);
        this.bookSize = bookSize;
        this.playLength = playLength;
        this.playbackArtist = playbackArtist;
    }

    @Override
    public String toString() {
        return  "This name of the book is " + title +
                "\n The author is " + author +
                "\n It was released in the year " + yearOfPublication +
                "\n The size of the book is " + bookSize + " MB " +
                "\n The length of the track is " + playLength +
                "\n The name of the playback artist is " + playbackArtist;
    }
}
