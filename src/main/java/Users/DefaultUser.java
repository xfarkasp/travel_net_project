package Users;

import java.util.ArrayList;

abstract class DefaultUser {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String originCountry;

    protected String password;
    protected int age;
    protected ArrayList<String> hobbies;
    protected ArrayList<String> foods;
    protected ArrayList<String> languages;

    public DefaultUser(String firstName, String lastName, String email, String password, int age, ArrayList<String> hobbies, ArrayList<String> foods, ArrayList<String> languages, String originCountry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.hobbies = hobbies;
        this.foods = foods;
        this.languages = languages;
        this.originCountry = originCountry;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<String> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<String> foods) {
        this.foods = foods;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}
