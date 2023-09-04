import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Reader {

    public static int id;
    private int instanceId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Gender gender;





    public Reader( String fullName, String email, String phoneNumber, Gender gender) {
        this.instanceId = id++;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Reader.id = id;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nReader{" +
                "instanceId=" + instanceId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                '}';
    }
}
