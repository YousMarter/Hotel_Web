package Hotel;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateCheck {

public  boolean isValidDate(String inDate) {

if (inDate == null)
return false;

//set the format to use as a constructor argument
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

if (inDate.trim().length() != dateFormat.toPattern().length())
return false;

dateFormat.setLenient(false);

try {
//parse the inDate parameter
dateFormat.parse(inDate.trim());
}
catch (ParseException pe) {
return false;
}
return true;
}
}