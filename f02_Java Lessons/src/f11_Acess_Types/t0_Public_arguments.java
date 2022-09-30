package f11_Acess_Types;

 class line {
    public float x1,y1,x2,y2;
    public float length;
    
    public line(float x1, float y1, float x2, float y2) {  // Конструктор
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        calculateLength();
    }
 
    public void calculateLength()
    { length=(float) Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));   }
           
}
class t0_Public_arguments {
public static void main (String[] args){
    line Line1 = new line(0,0,1,1);
    System.out.println("x1 =  " + Line1.x1 + "  x2 =  " + Line1.x2 + "  " + "  y1=  " + Line1.y1 + "  y2=  " + Line1.y2);
    System.out.println("length =  " + Line1.length);
        
    }
}