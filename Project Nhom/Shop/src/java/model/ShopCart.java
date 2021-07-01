
package model;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class ShopCart implements Serializable{
    private  HashMap<Integer, ProductLine> cart;

    public ShopCart(ShopCart c){
        cart=c.cart;
    }
    public ShopCart() {
        cart=new HashMap<Integer, ProductLine>();
    }
    public int add(Product p){
        if(cart.containsKey(p.getProductID())){
            int sl=cart.get(p.getProductID()).getQuantity();
            cart.get(p.getProductID()).setQuantity(sl+1);
        }
        else cart.put(p.getProductID(), new ProductLine(p));
        return cart.size();
    }
//--------------------------------------------------------------------    
    public int remove(int pid){
        if(cart.containsKey(pid)) cart.remove(pid);
        return cart.size();
    }
//-------------------------------------------------------------------    
    public Collection<ProductLine> getCart() {
        return cart.values();
    }
    
    public int getCount(){
        return cart.size();
    }
    public double getTotal(){
        double total=0;
        for(ProductLine a:cart.values()) total+=a.getPrice()*a.getQuantity();
        return total;
    }
    
}
