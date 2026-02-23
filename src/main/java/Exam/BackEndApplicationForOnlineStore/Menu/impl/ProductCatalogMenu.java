package Exam.BackEndApplicationForOnlineStore.Menu.impl;

import Exam.BackEndApplicationForOnlineStore.Configs.ApplicationContext;
import Exam.BackEndApplicationForOnlineStore.Enteties.Cart;
import Exam.BackEndApplicationForOnlineStore.Enteties.Product;
import Exam.BackEndApplicationForOnlineStore.Menu.Menu;
import Exam.BackEndApplicationForOnlineStore.Services.ProductManagementService;
import Exam.BackEndApplicationForOnlineStore.Services.impl.DefaultProductManagementService;

import java.util.Scanner;

public class ProductCatalogMenu implements Menu {
    private static final String CHECKOUT_COMMAND = "checkout";

    private ApplicationContext context;
    private ProductManagementService productManagementService;

    {
        context=ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }
    @Override
    public void start() {
        Menu menuToNavigate = null;
        while (true){
            printMenuHeader();
            printProductToConsole();

            String userInput = readUserInput();
            if(context.getLoggedInUser()==null){
                System.out.println("You are not logged in. Please, sign in or create new account");
                menuToNavigate = new MainMenu();
                break;
            }
            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                menuToNavigate = new MainMenu();
                break;
            }
            if(userInput.equalsIgnoreCase(CHECKOUT_COMMAND)){
                Cart sessionCart = context.getSessionCart();
                if(sessionCart == null || sessionCart.isEmpty()){
                    System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
                }else{
                    menuToNavigate = new CheckoutMenu();
                    break;
                }
            }
            else {
                Product productToCart = fetchProduct(userInput);
                if(productToCart == null){
                    System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
                    continue;
                }
                processAddToCart(productToCart);
            }
        }
        menuToNavigate.start();
    }

    private void processAddToCart(Product productToCart) {
        context.getSessionCart().addProduct(productToCart);
        System.out.printf("Product %s has been added to your cart. "
                + "If you want to add a new product - enter the product id. "
                + "If you want to proceed with checkout - enter word "
                + "'checkout' to console %n", productToCart.getProductName());
    }

    private Product fetchProduct(String userInput) {
        int productId = Integer.parseInt(userInput);
        Product productToAddToCart  = productManagementService.getProductById(productId);
        return productToAddToCart;
    }

    private String readUserInput() {
        System.out.print("Product ID to add to cart or enter 'checkout' to proceed with checkout: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        return userInput;
    }

    private void printProductToConsole(){
        Product[] products = productManagementService.getProducts();
        for (Product product:products){
            System.out.println(product);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** PRODUCT CATALOG *****");
        System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
    }
}
