public abstract class Person {
    protected String name;
    protected Gender gender;
    protected String email;

    public Person(String email, String name, Gender gender) {
        this.email = email;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
