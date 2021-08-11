package src.main.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet(name = "PrintProducts", urlPatterns = "/products")
public class PrintProducts extends HttpServlet {
    ArrayList<Product> products;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        products = new ArrayList<>();
        generateProducts(products, 10);
        printProducts(products, resp);
    }

    private void generateProducts(ArrayList<Product> products, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            products.add(new Product(i, "product" + i, random.nextInt(900)));
        }
    }

    private void printProducts(ArrayList<Product> products, HttpServletResponse resp) throws IOException {
        for (Product product : products) {
            resp.getWriter().printf("<h1>%s</h1>", product.toString());
        }
    }
}