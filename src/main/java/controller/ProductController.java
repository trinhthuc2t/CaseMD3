package controller;

import filter.SessionUser;
import model.product.Brand;
import model.product.Cart;
import model.product.Category;
import model.product.Product;
import service.product.BrandService;
import service.product.CartService;
import service.product.CategoryService;
import service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    BrandService brandService = new BrandService();
    CartService cartService = new CartService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        boolean checkAction = true;

        switch (action) {
            case "home":
                showAllForUser(request, response);
                break;
            case "product":
                productDetailForm(request, response);
                break;
            case "cart":
                showCartForm(request, response);
                break;
            case "add_cart":
                addCardForm(request, response);
                break;
            case "delete_cart":
                deleteCardForm(request, response);
                break;
            case "product_to_brand":
                showBrandForm(request, response);
                break;
            case "product_to_category":
                showCategoryForm(request, response);
                break;

            case "search":
                showFindForm(request, response);
                break;
            default:
                checkAction = false;
                break;
        }
        if (SessionUser.checkUser(request)) {
            if (!SessionUser.checkRoleAdmin(request)) {
                switch (action) {

                    default:
                        checkAction = false;
                        break;
                }
            } else {
                switch (action) {
                    case "home_admin":
                        showAllForAdmin(request, response);
                        break;
                    case "add":
                        showAddForm(request, response);
                        break;
                    case "delete":
                        deleteProduct(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;

                }
            }
        } else {
            if (!checkAction) response.sendRedirect("/user?action=login");
        }
    }

    private void showFindForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/home_admin.jsp");
        String name = request.getParameter("nameSearch");
        List<Product> products = productService.findByName(name);
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCardForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        cartService.delete(id);
        HttpSession session = request.getSession();
        session.setAttribute("iCart", cartService.getAll().size());
        try {
            response.sendRedirect("/products?action=cart");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void productDetailForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findIndexById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/product_detail.jsp");
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("products", products);
        request.setAttribute("product", product);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addCardForm(HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = new Product(id);
        try {
            cartService.addCart(new Cart(product));
            HttpSession session = request.getSession();
            session.setAttribute("iCart", cartService.getAll().size());
            response.sendRedirect("/products?action=home");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void showCartForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/cart.jsp");
        List<Cart> carts = cartService.getAll();
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        List<Product> products = productService.getAll();
        double sum = cartService.getSumPrice();
        HttpSession session = request.getSession();
        session.setAttribute("sumCart", cartService.getSumPrice());
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("carts", carts);
        request.setAttribute("products", products);
        request.setAttribute("sum", sum);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            /*throw new RuntimeException(e);*/
            e.printStackTrace();
        }
    }

    private void showBrandForm(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/product_to_brand.jsp");
        List<Product> products = productService.getBrand(idBrand);
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCategoryForm(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/product_to_category.jsp");
        List<Product> products = productService.getBrand(idBrand);
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findIndexById(id);
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        try {
            response.sendRedirect("/products?action=card");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/add.jsp");
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showAllForAdmin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/home_admin.jsp");
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllForUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/home_admin.jsp");
        List<Product> products = null;
        List<Category> categories = categoryService.getAll();
        List<Brand> brands = brandService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        String orderBy = request.getParameter("orderBy");
        if (orderBy != null) {
            switch (orderBy) {
                case "asc":
                    products = productService.productAsc();
                    break;
                case "desc":
                    products = productService.productDesc();
                    break;

            }
            request.setAttribute("products", products);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            products = productService.getAll();
            request.setAttribute("products", products);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "search":
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean status = request.getParameter("status").isEmpty();
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        Category category = new Category(categoryId);
        Brand brand = new Brand(brandId);
        Product product = new Product(name, img, price, quantity, status, description, category, brand);
        productService.edit(id, product);
        try {
            response.sendRedirect("/products?action=home_admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean status = request.getParameter("status").isEmpty();
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        Category category = new Category(categoryId);
        Brand brand = new Brand(brandId);
        Product product = new Product(name, img, price, quantity, status, description, category, brand);
        productService.add(product);
        response.sendRedirect("/products?action=home_admin");
    }
}