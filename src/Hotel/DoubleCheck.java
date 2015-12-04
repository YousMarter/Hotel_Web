package Hotel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoubleCheck extends HttpServlet implements java.io.Serializable {

	String status;
	UserInfo ui;
	String email;
	public int i = 0;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		HttpSession session = request.getSession();
		status = (String) session.getAttribute("status");
		email = (String) session.getAttribute("welcome_name");
		session.setAttribute("server_time", System.currentTimeMillis());

		long time = System.currentTimeMillis();
		if (status != "1") {
			try {
				;
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('Login first before Order Room Service'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			//	response.sendRedirect("login.jsp");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (status == "0") {

			try {

				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('Login first before Order Room Service'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			//	response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (status == "1") {
			try {

				FileInputStream fileIn = new FileInputStream(
						"C:\\apache-tomcat-7.0.34/temp/YourHotel/user/" + email + ".ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				try {
					ui = (UserInfo) in.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				in.close();
				fileIn.close();
				for (int j = 0; j < ui.order.size(); j++) {
					if (ui.order.get(j).getcheckin().getTime() <= time
							&& ui.order.get(j).getcheckout().getTime() >= time) {
						session.setAttribute("userinfo", ui);
						session.setAttribute("checkinroom", ui.order.get(j)
								.getRoomID());
						System.out.println(ui.order.get(j).getRoomID());
						response.sendRedirect("roomservice.jsp");
						i = 1;
					}
				}

				if (i == 0) {

					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('You haven`t Checkin Your Hotel.'); window.location='HomePage.jsp' </script>");
					out.flush();
					out.close();
				//	response.sendRedirect("HomePage.jsp");

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
