import java.util.regex.Matcher;
import java.util.regex.Pattern;
// based on code found at https://www.techiedelight.com/validate-ip-address-java/#:~:text=Using%20Apache%20Commons%20Validator&text=isValid(inetAddress)%3A%20Returns%20true,is%20a%20valid%20IPv6%20address.
// Java program to validate an IPv4 address
public class ValidateIPv4{
    private static final String IPV4_REGEX =
                    "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
 
    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);
    public static boolean isValidInet4Address(String ip) {
        if (ip == null) {
            return false;
        }
        Matcher matcher = IPv4_PATTERN.matcher(ip);
        return matcher.matches();
    }
}