package Hotel;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendMail {
   public void send(int a,UserInfo ui) {
      // Recipient's email ID needs to be mentioned.
     System.out.println(">>>>>>>>here1");
	   String to = ui.email;//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "youwu0106@gmail.com";//change accordingly
      final String username = "youwu0106@gmail.com";//change accordingly
      final String password = "Wyandfx2014";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      
      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         if(a==0){   /* todo send reset url and temppassword  */
         // Set Subject: header field
         message.setSubject("Your Hotel Password Reset Notification");

         // Now set the actual message
         message.setText("Dear" +ui.firstname+ ", This is your temp password :" +ui.temppassword+" use it go to http://localhost:8080/YourHotel/doreset.jsp to reset your password");

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");}
         
         if(a==1){
        	 
        	 message.setSubject("Your Hotel Reservation Notification");
        	 
        	 message.setText("Dear"+ui.firstname+",Your order has been placed,remember that your checkin date:" +ui.order.get(ui.order.size()-1).getcheckin()+"and bring the letter to check in.");
        	//todo send confirmation letter. 
        	 
        	 Transport.send(message);

             System.out.println("Sent message successfully....");
         }

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
   
   
}