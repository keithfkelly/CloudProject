import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class TrainTimer extends HttpServlet { 
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {
    // reading the user input
    String StationC = request.getParameter("StationCode");
    Logic trainLogic = new Logic();
    trainLogic.getXML(StationC);
    String display = trainLogic.returnString();
    
   request.setAttribute("results", display);
   request.getRequestDispatcher("/Result.jsp").forward(request, response);
  }  
}