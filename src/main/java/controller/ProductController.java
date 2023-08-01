package controller;

import model.product.Brand;
import model.product.Category;
import model.product.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showAll(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "delete":

                break;
            case "edit":

                break;
            case "search":
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/home.jsp");
        List<Product> products = productService.getAll();
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                createProduct(request, response);
                break;
            case "delete":

                break;
            case "edit":

                break;
            case "search":
                break;
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean status = request.getParameter("status").isEmpty();
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("id"));
        int idBrand = Integer.parseInt(request.getParameter("id"));
        Category category = new Category(idCategory);
        Brand brand = new Brand(idBrand);
        productService.add(new Product(name,img,price,quantity,status,description,category,brand));
        response.sendRedirect("/products?action=home");
    }
}