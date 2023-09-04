import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BookService implements BookInterface {

    private Database database;


    public BookService(Database database) {
        this.database = database;
    }


    @Override
    public Book saveBook(Long libraryId, Book book) {
      for(Library ll:database.getLibraries()){
          if(ll.getInstanceId()==libraryId){
              List<Book>newBook=ll.getBooks();
              if(!newBook.contains(book)){

                      newBook.add(book);
                  for(int i=0; i<newBook.size(); i++){
                      newBook.get(i).setInstanceId(i+1-1);
                  }
                      System.out.println("New Book added");
              }else{
                  System.out.println("This book already exist");
              }
          }
      }
        System.out.println(database.getLibraries());
      return book;
    }



    @Override
    public List<Book> getAllBooks(Long libraryId) {
        Iterator<Book> iterator = database.getBooks().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return null;
    }

    @Override
    public void getBookById(Long libraryId, Long bookId) {
        for(int i=0; i<database.getBooks().size(); i++){
            if(database.getBooks().get(i).getInstanceId()==libraryId){
                for(Library ll:database.getLibraries()){
                    if(ll.getInstanceId()==libraryId){
                        System.out.println(database.getBooks().get(i));
                    }
                }
            }
        }

    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (int i = 0; i < database.getBooks().size(); i++) {
            if (database.getBooks().get(i).getInstanceId() == bookId) {
                Book removedBook = database.getBooks().remove(i);


                for (Library library : database.getLibraries()) {
                    if (library.getInstanceId() == libraryId) {
                        library.getBooks().remove(removedBook);
                        System.out.println(database.getBooks());
                        break;
                    }
                }
                return "Book deleted.";
            }
        }
        return "Book not found.";
    }




    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library ll : database.getLibraries()) {
            if (ll.getInstanceId() == libraryId) {
                ll.getBooks().clear();
                System.out.println(database.getLibraries());
                break;
            }
        }
    }
}
