import java.io.Serializable; // Best practice for JavaBeans

public class PersonBean implements Serializable {
    private String name;
    private int age;
    private String address;

    // Default (no-argument) constructor - mandatory for JavaBeans
    public PersonBean() {
    }

    // Property: name (Read/Write)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Property: age (Read/Write)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Property: address (Read/Write)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}