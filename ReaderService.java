import java.util.Iterator;
import java.util.List;

public class ReaderService implements ReaderInterface {

    private Database database;


    public ReaderService(Database database) {
        this.database = database;

    }

    @Override
    public void saveReaderByLibraryId(Long id, Reader reader) {
        for (Library ll : database.getLibraries()) {
            if (ll.getInstanceId() == id) {
                List<Reader> readers = ll.getReaders();
                if (!readers.contains(reader)) {
                    readers.add(reader);
                    for (int i = 0; i < readers.size(); i++) {
                        readers.get(i).setInstanceId(i+1-1);
                    }
                    System.out.println("New Reader added");
                } else {
                    System.out.println("This Reader already exist");
                }
            }
        }
        System.out.println(database.getLibraries());

    }


    @Override
    public List<Reader> getAllReaders() {
        Iterator<Reader> iterator = database.getReaders().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return null;
    }


    @Override
    public Reader getReaderById(Long id) {
        for (Reader ll : database.getReaders()) {
            if (ll.getInstanceId() == id) {
                System.out.println(ll);
            }
        }
        return null;
    }


    @Override
    public Reader updateReader(Long id, Reader reader) {
        List<Reader> readers = database.getReaders();
        for (int i = 0; i < database.getReaders().size(); i++) {
            if (database.getReaders().get(i).getInstanceId() == id) {
                database.getReaders().get(i).setInstanceId(database.getReaders().get(i).getInstanceId() + 1);
                return readers.get(i);
            }

        }
        return reader;

    }


    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        List<Library> libraries = database.getLibraries();
        List<Reader> readers = database.getReaders();

        for (Reader oldReaders : readers) {
            if (oldReaders.getInstanceId() == readerId) {
                for (Library oldLibrary : libraries) {
                    if (oldLibrary.getInstanceId() == libraryId) {
                        oldLibrary.getReaders().add(oldReaders);
                        database.getLibraries().add(oldLibrary);
                        System.out.println("Transferred succesfully: " + oldLibrary);
                        return;
                    }
                }
            }
        }
        System.out.println("This library already exist");

    }
}
