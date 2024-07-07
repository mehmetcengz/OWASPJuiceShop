package data;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserData {
    private String email;
    private String password;
    private String confirmPassword;
    private String securityQuestion;
    private String securityAnswer;
    private String country;
    private String name;
    private String mobileNumber;
    private String zipCode;
    private String address;
    private String city;
    private String state;
    private String creditCardNumber;
    private String expiryMonth;
    private String expiryYear;

    public static UserData generateUserData(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String securityQuestion = "Company you first work for as an adult?";
        String securityAnswer = faker.company().name();
        String country = faker.country().name();
        String name = faker.name().fullName();
        String mobileNumber = String.valueOf(faker.number().numberBetween(99900000, 99988888));
        String zipCode = faker.number().digits(6);
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String creditCardNumber = faker.number().digits(16);
        String expiryMonth = String.valueOf(faker.number().numberBetween(1,12));
        String expiryYear = String.valueOf(faker.number().numberBetween(2080,2099));

        UserData userData = new UserData();
        userData.setEmail(email);
        userData.setPassword(password);
        userData.setConfirmPassword(password);
        userData.setSecurityQuestion(securityQuestion);
        userData.setSecurityAnswer(securityAnswer);
        userData.setCountry(country);
        userData.setName(name);
        userData.setMobileNumber(mobileNumber);
        userData.setZipCode(zipCode);
        userData.setAddress(address);
        userData.setCity(city);
        userData.setState(state);
        userData.setCreditCardNumber(creditCardNumber);
        userData.setExpiryMonth(expiryMonth);
        userData.setExpiryYear(expiryYear);

        return userData;
    }
}
