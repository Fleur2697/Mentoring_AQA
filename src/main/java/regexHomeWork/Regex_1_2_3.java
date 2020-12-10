package regexHomeWork;

import java.util.ArrayList;
import java.util.List;

public class Regex_1_2_3 {

    public static void main(String[] args) {
        List<String> emails = new ArrayList<>();
        List<String> ip = new ArrayList<>();
        List<String> visaCards = new ArrayList<>();

        emails.add("Olha_Koloskova@epam.com");
        emails.add("Olha_Kolo%skova@epam.c+om");
        emails.add("Olha_Koloskova+123-2@epam.com");
        emails.add("Olha_Kolo%sk#$%ova@epam.c+om");
        ip.add("200.200.200.200");
        ip.add("200.200.200.200.");
        ip.add("1.1.1.200");
        ip.add("261.1.1.200");
        visaCards.add("41234wee56789");
        visaCards.add("4123456789123");
        visaCards.add("5123456789123");
        visaCards.add("412345678912333");
        visaCards.add("4123456789123456");

        String patternForEmail = "^([\\w.+-]{1,64})(@)([\\w.]{1,64})$";
        String patternForIP = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.)){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        String patternVisaCard = "^(4[0-9]{12}([0-9]{3})?)$";
        Regex_1_2_3.patternForEmail(emails, patternForEmail);
        Regex_1_2_3.patternForIP(ip, patternForIP);
        Regex_1_2_3.patternForVisa(visaCards, patternVisaCard);
    }


    public static List<String> patternForEmail(List<String> email, String pattern) {
        return matchForPatterns(email, pattern);
    }

    public static List<String> patternForIP(List<String> IP, String pattern) {
        return matchForPatterns(IP, pattern);
    }

    public static List<String> patternForVisa(List<String> visaCards, String pattern) {
        return matchForPatterns(visaCards, pattern);
    }

    private static List<String> matchForPatterns(List<String> values, String pattern) {
        List<String> validValues = new ArrayList<>();
        for (String value : values) {
            if (value.matches(pattern)) {
                validValues.add(value);
                System.out.println(value);
            }
        }
        return validValues;
    }
}
