package by.bsuir.first.servlet;

import javax.servlet.Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/log")
public class FirstServletHtml extends HttpServlet implements Servlet
{
    static Logger logger = Logger.getLogger(FirstServletHtml.class);

    public FirstServletHtml() {
        super();
    }

    public void init() throws ServletException {
        BasicConfigurator.configure();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException
    {
        BasicConfigurator.configure();

//--------------------------------------------------------------------------------------------
        String fileName = "pages\\Carousel Template · Bootstrap.htm";

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String htmString="";

                String tmp = "";
                while ((tmp=br.readLine())!= null) {
                    htmString+= tmp + "\r\n";
                }

                response.setContentType("text/html;charset=UTF-8");
                String secondString = new String(htmString.getBytes("windows-1251"),"UTF-8");
                response.getWriter().print(secondString);

                logger.info("Hello from Log4j!!!");
                logger.info("Connection was established with " + request.getRemoteAddr());
                logger.info("There are examples of different log-message levels:");
                logger.debug("- Debug level message");
                logger.info("- Info level message");
                logger.warn("- Warn level message");
                logger.error("- Error level message");
                logger.fatal("- Fatal level message");


 //-------------------------------------------------------------------------------------------------

        /*response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName() + ", using the GET method <br>");
        response.getWriter().print("Servlet config: " + this.getServletConfig() + ", using the GET method <br>");
        response.getWriter().print("Your IP adress is: " + request.getRemoteAddr() + "<br>");*/


        /*logger.info("Hello from Log4j!!!");
        logger.info("Connection was established with " + request.getRemoteAddr());
        logger.info("There are examples of different log-message levels:");
        logger.debug("- Debug level message");
        logger.info("- Info level message");
        logger.warn("- Warn level message");
        logger.error("- Error level message");
        logger.fatal("- Fatal level message");*/
    }
}