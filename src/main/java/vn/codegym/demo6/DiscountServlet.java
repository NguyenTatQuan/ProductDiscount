package vn.codegym.demo6;// DiscountServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "DiscountServlet", urlPatterns = "/index")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String productDesc = request.getParameter("productDesc");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        // Tính toán chiết khấu
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        // Gửi kết quả về cho client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Discount Result</title></head><body>");
        out.println("<h1>Discount Result</h1>");
        out.println("<p><strong>Product Description:</strong> " + productDesc + "</p>");
        out.println("<p><strong>List Price:</strong> " + listPrice + "</p>");
        out.println("<p><strong>Discount Percent:</strong> " + discountPercent + "</p>");
        out.println("<p><strong>Discount Amount:</strong> " + discountAmount + "</p>");
        out.println("<p><strong>Discount Price:</strong> " + discountPrice + "</p>");
        out.println("</body></html>");
    }
}
