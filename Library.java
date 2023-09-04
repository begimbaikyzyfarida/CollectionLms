import java.util.List;

public class Library {
    public static int id;
    private int instanceId;
    private String name;
    private String address;
    private List<Book> books;

    private List<Reader>readers;


    public Library( String name, String address, List<Book> books, List<Reader> readers) {
        this.instanceId = id++;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
        for(int i=0; i<readers.size(); i++){
            readers.get(i).setInstanceId(i+1-1);
        }
        for (int i=0; i<books.size(); i++){
            books.get(i).setInstanceId(i+1-1);
        }

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Library.id = id;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "\nLibrary{" +
                "instanceId=" + instanceId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                ", readers=" + readers +
                '}';
    }
}
