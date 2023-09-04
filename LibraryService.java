import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryService implements LibraryInterface {


    private Database database;


    public LibraryService(Database database) {
        this.database = database;
    }


    @Override
    public List<Library> getAllLibraries() {
        Iterator<Library> iterator = database.getLibraries().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return null;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library ll : database.getLibraries()) {
            if (ll.getInstanceId() == id) {
                System.out.println(ll);
            }
        }
        return null;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        boolean isExist = false;
        List<Library> newLibrary = database.getLibraries();  // Retrieve the list only once

        for (Library library : libraries) {
            if (newLibrary.contains(library)) {
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            newLibrary.addAll(libraries);
            System.out.println("Libraries added successfully.");
        } else {
            System.out.println("Libraries already exist.");
        }

        return newLibrary;
    }






    @Override
    public Library updateLibrary(Long id, Library library) {
       List<Library>libraries=database.getLibraries();
       for (Library ll:database.getLibraries()){
           if(ll.getInstanceId()==id){
               ll.setInstanceId(ll.getInstanceId()-1);
               return ll;
           }
       }
       return library;
    }


    @Override
    public String deleteLibrary(Long id) {
        for (int i = 0; i < database.getLibraries().size(); i++) {
            if (database.getLibraries().get(i).getInstanceId() == id) {
                Library removedLibrary = database.getLibraries().remove(i);
                database.getLibraries().remove(removedLibrary);
                database.getLibraries().get(i).setInstanceId(i);

                    System.out.println(database.getLibraries());
                    break;
                }
            }
            return "Book deleted.";
        }

    }
