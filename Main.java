import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List<Reader> readerList=new ArrayList<>();
        Reader reader=new Reader("Adel", "@adel", "0505123445", Gender.FEMALE);
        Reader reader1=new Reader("Alina", "@alina", "050345678", Gender.MALE);
        Reader reader2=new Reader("Farida", "@farida", "0707896754", Gender.FEMALE);
        readerList.add(reader);
        readerList.add(reader1);
        readerList.add(reader2);

        List<Reader> readerList1=new ArrayList<>();
        Reader reader4=new Reader("Aziz", "aziz", "345678", Gender.FEMALE);
        readerList1.add(reader4);


        List<Reader>readerList2=new ArrayList<>();
        Reader reader5=new Reader("Aktan", "aktan" , "34567", Gender.MALE);
        readerList2.add(reader5);

        Reader reader55=new Reader("Aktannn", "aktan" , "34567", Gender.MALE);

        List<Reader>allReader=new ArrayList<>();
        allReader.addAll(readerList);
        allReader.addAll(readerList1);



        List<Book>booksList=new ArrayList<>();
        Book book=new Book("Becoming", "Michelle", Genre.COMEDY);
        Book book1=new Book("Rich dad", "Erkin", Genre.ROMAN);
        booksList.add(book);
        booksList.add(book1);


        List<Book>bookList1=new ArrayList<>();
        Book book3=new Book("Poor dad", "Aziz", Genre.COMEDY);
        bookList1.add(book3);
        Book book11=new Book("Rich dad1111", "Erkinbek", Genre.ROMAN);


        List<Book>allBook=new ArrayList<>();
        allBook.addAll(booksList);
        allBook.addAll(bookList1);



        List<Library> libraries = new ArrayList<>();
        Library library1 = new Library("Peak", "123 Main St", booksList, readerList);
        libraries.add(library1);


        List<Library>libraries1=new ArrayList<>();
        Library library2 = new Library("Japan", "456 Elm St", bookList1, readerList1);
        libraries1.add(library2);

        List<Library>allLibraries=new ArrayList<>();
        allLibraries.addAll(libraries);
        allLibraries.addAll(libraries1);


        List<Library>libraries11=new ArrayList<>();
        Library library=new Library("Dubai", "78 District", booksList, readerList2);
        libraries11.add(library);





        Database database=new Database(allLibraries, allBook, allReader);

        LibraryService libraryService=new LibraryService(database);
        ReaderService readerService=new ReaderService(database);
        BookService bookService=new BookService(database);


        Scanner scanner=new Scanner(System.in);
        System.out.println("1. Save library");
        System.out.println("2. Get all libraries");
        System.out.println("3. Delete library");
        System.out.println("5. Get library by id");
        System.out.println("-----------------------------");
        System.out.println("6. Get all books");
        System.out.println("7. Save book");
        System.out.println("8. Get book by id");
        System.out.println("9. Delete book");
        System.out.println("10. Clear book by library id");
        System.out.println("----------------------------");
        System.out.println("11. Save reader");
        System.out.println("12. Get all reader");
        System.out.println("13. Get reader by id");
        System.out.println("14. Assign reader to library id");
        System.out.println("15. Update reader id");
        System.out.println("16. Update library id");
        while ((true)){
            int choose=scanner.nextInt();
           switch (choose){
               case 1:
                   System.out.println(libraryService.saveLibrary(libraries11));
                   break;
               case 2:
                   System.out.println(libraryService.getAllLibraries());
                   break;
               case 3:
                   System.out.println(libraryService.deleteLibrary(1L));
                   break;
               case 5:
                   System.out.println(libraryService.getLibraryById(0L));
                   break;
               case 6:
                   System.out.println(bookService.getAllBooks(1L));
                   break;
               case 7:

                   System.out.println(bookService.saveBook(1L,book11));
                   break;
               case 8:
                   bookService.getBookById(1L, 1L);
                   break;
               case 9:
                   System.out.println(bookService.deleteBook(1L, 0L));
                   break;
               case 10:
                   bookService.clearBooksByLibraryId(0L);
                   break;
               case 11:
                   readerService.saveReaderByLibraryId(1L, reader55);
                   break;
               case 12:
                   System.out.println(readerService.getAllReaders());
                   break;
               case 13:
                   System.out.println(readerService.getReaderById(2L));
                   break;
               case 14:
                   readerService.assignReaderToLibrary(0L, 1L);
                   break;
               case 15:
                   System.out.println("Original reader: "+reader2);
                   System.out.println("Updated id from 2 to 3");
                   System.out.println(readerService.updateReader(2L, reader2));
                   break;
               case 16:
                   System.out.println("This is original library: "+ library2);
                   System.out.println("Updated id from 1 to 0");
                   System.out.println(libraryService.updateLibrary(1L, library2));
           }
        }
    }
}
