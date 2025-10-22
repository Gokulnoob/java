public class JavaBeanTest {
    public static void main(String[] args) {
        // 1. Instantiate the JavaBean
        PersonBean person = new PersonBean();

        // 2. Set properties using setter methods
        person.setName("Mr.V");
        person.setAge(21);
        person.setAddress("SALEM");

        // 3. Get properties using getter methods and display
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
    }
}