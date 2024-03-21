public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static Person fromString(String data) throws InvalidDataFormatException {
        String[] parts = data.split(" ");
        if (parts.length != 6) {
            throw new InvalidDataFormatException("Не верное количество введенных данных");
        }

        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];
        String birthDate = parts[3];
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(parts[4]);
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Не правильный формат номера телефона");
        }
        char gender;
        if (parts[5].length() != 1 || !(parts[5].equals("ж") || parts[5].equals("м"))) {
            throw new InvalidDataFormatException("Не верный формат пола: ж - женский, м - мужской");
        }
        gender = parts[5].charAt(0);

        return new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}