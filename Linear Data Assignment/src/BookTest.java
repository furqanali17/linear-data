public class BookTest {
    public static void main(String[] args) {
        //printing object from PrintBook class which overrides Book class
        PrintBook test= new PrintBook("Diary of a Wimpy Kid", "Jeff Kinney", 2012,
                "Amulet Books", 978384320);

        System.out.println(test);

        System.out.println(" ");
        System.out.println("-----End of PrintBook-----");
        System.out.println(" ");

        //printing object from AudioBook class which overrides Book class
        AudioBook test2 = new AudioBook("Diary of a Wimpy Kid", "Jeff Kinney", 2012,
                        55, 1.57, "Dan Russell");

        System.out.println(test2);

        System.out.println(" ");
        System.out.println("-----End of AudioBook-----");
    }
}
