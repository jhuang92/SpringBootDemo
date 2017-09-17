package hello;

public class Book {
    //    Properties
    private final String name;
    private final String author;

    //    Constructor
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
