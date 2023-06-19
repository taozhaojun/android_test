package com.julienb.assignment3_mobdev;

import java.util.ArrayList;

public class DataSource {

    private static ArrayList<CartEntry> cart= new ArrayList();

    // setting up autobiography menu items
    public static ArrayList<MenuItem> getAutobiography(){

        ArrayList<MenuItem> autobiography= new ArrayList();
        autobiography.add(new MenuItem("Steve Jobs","Steve Jobs", "Steve Jobs is the authorized self-titled biography of American business magnate and Apple co-founder Steve Jobs", "10.00", "steve_jobs"));
        autobiography.add(new MenuItem("Autobiography of a Yogi","Paramahansa Yogananda" ,"Autobiography of a Yogi is at once a beautifully written account of an exceptional life and a profound introduction to the ancient science of Yoga","11.00", "yogi_autobiography"));
        autobiography.add(new MenuItem("Long Walk to Freedom", "Nelson Mandela","Autobiography credited to South African President Nelson Mandela", "12.00", "long_walk_to_freedom"));
        autobiography.add(new MenuItem("The Autobiography of Benjamin Franklin", "Benjamin Franklin","The Autobiography of Benjamin Franklin is the traditional name for the unfinished record of his own life written by Benjamin Franklin from 1771 to 1790", "13.00", "autobiography_benjamin"));
        return autobiography;
    }
    // setting up Fiction menu items
    public static ArrayList<MenuItem> getFiction(){

        ArrayList<MenuItem> fiction= new ArrayList();
        fiction.add(new MenuItem("To Kill a Mockingbird", "Harper Lee","A Pulitzer Prize-winning novel set in the 1930s, it tells the story of a young girl named Scout Finch and her father, a lawyer named Atticus Finch", "22.10", "to_kill_a_mockingbird"));
        fiction.add(new MenuItem("The Great Gatsby","F. Scott Fitzgerald ", "Set in the roaring 20s, it tells the story of a mysterious and wealthy man named Jay Gatsby who throws extravagant parties to win back his lost love, Daisy Buchanan.", "18.20", "the_great_gatsby"));
        fiction.add(new MenuItem("Brave New World", "Aldous Huxley","Another dystopian novel, set in a world where people are genetically engineered and conditioned to conform to a strict social hierarchy.", "20.30", "brave_new_world"));
        fiction.add(new MenuItem("The Catcher in the Rye", "J.D. Salinger","A coming-of-age story that follows the rebellious and alienated teenager Holden Caulfield as he navigates his way through adolescence.", "21.30", "the_cather_in_the_rye"));
        return fiction;
    }
    // setting up Comics menu items
    public static ArrayList<MenuItem> getComics(){
        ArrayList<MenuItem> comics= new ArrayList();
        comics.add(new MenuItem("Watchmen", "Alan Moore and Dave Gibbons","A graphic novel that explores the complex themes of power, morality, and humanity through the lens of a group of retired superheroes investigating a murder.", "15.10", "watch_men"));
        comics.add(new MenuItem("Batman", "Frank Miller","A dark and gritty comic that imagines a future in which an older Bruce Wayne returns to the role of Batman to fight crime and corruption in a deteriorating Gotham City.", "13.20", "batman"));
        return comics;
    }
    // setting up SelfHelp books menu items
    public static ArrayList<MenuItem> getSelfHelpBook(){

        ArrayList<MenuItem> selfHelp= new ArrayList();
        selfHelp.add(new MenuItem("The 7 Habits of Highly Effective People", "Stephen R. Covey","his book presents seven habits that can help individuals become more productive and successful in their personal and professional lives.", "6.10", "habit"));
        selfHelp.add(new MenuItem("How to Win Friends and Influence People", "Dale Carnegie","A classic self-help book that provides tips and strategies for improving interpersonal communication and building strong relationships.", "5.80", "friends"));
        selfHelp.add(new MenuItem("Think and Grow Rich", "Napoleon Hill","A motivational book that outlines the steps individuals can take to achieve financial success and abundance.", "4.70", "think_grow"));
        return selfHelp;
    }

    public static String[] getMenuItemsNames(ArrayList<MenuItem> menuList){
        String[] menuItemsNames = new String[menuList.size()];
        // Just loop through each menu item and returning an array of names
        for (int i = 0; i < menuList.size(); i++){
            menuItemsNames[i] = menuList.get(i).name;
        }
        return menuItemsNames;
    }

    public static MenuItem getItemDetailsByName(ArrayList<MenuItem> menuList, String itemName){
        MenuItem itemRequested = null;
        // Looping through each menu items
        for (MenuItem menuItem : menuList) {
            // If we find the item requested, we break the loop and return it
            if (menuItem.name.equals(itemName)) {
                itemRequested = menuItem;
                break;
            }
        }
        return itemRequested;
    }

    public static void addToCart(MenuItem menuItem, int quantity){
        for (int i = 0; i < cart.size(); i++) {
            // Checking if we already added that item to the cart
            if(cart.get(i).name.equals(menuItem.name)){
                cart.get(i).quantity+=quantity;
                return;
            }
        }
        // If nothing has been found (no return) then we add the item to the cart
        cart.add(new CartEntry(menuItem.name, quantity, menuItem.price));
    }

    // Calculating the cart total
    public static Double getCartTotal(){
        Double total = 0.0;
        for (CartEntry cartEntry : cart) {
            total += cartEntry.quantity * Double.parseDouble(cartEntry.price);
        }
        return total;
    }

    public static ArrayList<CartEntry> getCart(){
        return cart;
    }

    public static void clearCart(){
        cart.clear();
    }

}
