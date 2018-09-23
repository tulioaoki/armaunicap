
package arma;

import java.util.Scanner;



public class Arma {
    
    
    public static void main(String[] args) {
       createBullet();
       createMagazine();
       
       
    }
    
    public static Barrel createBarrel(){  //testing 
        Scanner in = new Scanner(System.in);
        System.out.println("choose the name of the new Barrel:");
        String name = in.nextLine();
        System.out.println("choose the sound modifier for the new Barrel");
        int soundMod = in.nextInt();
        System.out.println("choose the range modifier for the new Barrel");
        int rangeMod = in.nextInt();
        System.out.println("choose the weight for the new Barrel");
        float weight = in.nextFloat();
        System.out.println("choose the id number for the new Barrel");
        int id = in.nextInt();
        
        Barrel b = new Barrel(name,soundMod,rangeMod,weight,id);
        
        System.out.println("NEW BARREL CREATED:");
        System.out.println(b.toString());
        
        return b;
    } //testing
    
    public static Bullet createBullet(){  //testing 
        Scanner in = new Scanner(System.in);
        System.out.println("choose the name of the new Bullet:");
        String name = in.nextLine();
        System.out.println("choose the sound modifier for the new Bullet");
        int soundMod = in.nextInt();
        System.out.println("choose the damage modifier for the new Bullet");
        int damageMod = in.nextInt();
        System.out.println("choose the weight for the new Bullet");
        float weight = in.nextFloat();
        System.out.println("choose the id number for the new Bullet");
        int id = in.nextInt();
        
        Bullet b = new Bullet(name,damageMod,soundMod,weight,id);
        
        System.out.println("NEW BULLET CREATED:");
        System.out.println(b.toString());
        
        return b;
    } //testing
    
    public static Magazine createMagazine(){  //testing 
        Scanner in = new Scanner(System.in);
        System.out.println("choose the name of the new Magazine:");
        String name = in.nextLine();
        System.out.println("choose the capacity of the new Magazine");
        int capacity = in.nextInt();
        System.out.println("choose the id number for the new Magazine");
        int id = in.nextInt();
        
        Magazine m = new Magazine(name,capacity,id);
        
        System.out.println("NEW MAGAZINE CREATED:");
        System.out.println(m.toString());
        
        return m;
    } //testing
    
    
}
