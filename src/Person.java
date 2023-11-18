public class Person {
    private String name;
    private String surname;
    private int idNumber;
    private String address;

    public Person(String name, String surname, int idNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idNumber=" + idNumber +
                ", address='" + address + '\'' +
                '}';
    }
}