package LamdaExample.Lamda;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    InterFaceEx i =  () -> {
    	System.out.println("Hello");
    };
    i.show();
    InterFaceEx i1 =  () ->	System.out.println("Hello 3");
    i1.show();
    
   //  SumInter i2=  (a,b) -> { return a+b; };
    SumInter i2=  (a,b) -> a+b; 
    System.out.println(i2.sum(10,20));
  }
}
