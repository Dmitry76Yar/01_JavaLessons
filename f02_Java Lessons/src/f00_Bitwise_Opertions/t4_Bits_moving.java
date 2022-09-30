package f00_Bitwise_Opertions;

class t0_Perevod_v_dvoichn3 {
public static void perevod (int chislo) {
 // Происходит сравнение каждого бита со степенными производными двойки (т.е. только один бит равен 1)
    System.out.print("Число = " + chislo + " в двоичной системе - \t");
    for (int m = 128; m>0; m=m/2)
        if ((chislo&m) != 0) System.out.print("1 "); else System.out.print("0 "); System.out.println();
                  }
    }
class t4_Bits_moving {  
public static void main (String args []) {
    //Смещение влево. При сдвиге влево освободившиеся младшие разряды заполняются нулями.\
    // Цифра справа от << означает на сколько рарядов должен быть смещен бит
    System.out.print("\t Смещение влево \n");       
    t0_Perevod_v_dvoichn3.perevod(1);
    t0_Perevod_v_dvoichn3.perevod(1<<1);
    t0_Perevod_v_dvoichn3.perevod(1<<4);
    t0_Perevod_v_dvoichn3.perevod(8);
    t0_Perevod_v_dvoichn3.perevod(8<<4);
System.out.print("\t Как можно видеть ниже все биты с единицами смещаются на заданное число разрядов- \n");   
    t0_Perevod_v_dvoichn3.perevod(23);
    t0_Perevod_v_dvoichn3.perevod(23<<1);
    t0_Perevod_v_dvoichn3.perevod(23<<2);
    t0_Perevod_v_dvoichn3.perevod(23<<3);
System.out.print("\t Для отрицательных чисел смещение ВЛЕВО работает ровно таким же способом \n");       
    t0_Perevod_v_dvoichn3.perevod(-23);
    t0_Perevod_v_dvoichn3.perevod(-23<<1);
    t0_Perevod_v_dvoichn3.perevod(-23<<2);
    
    System.out.print("\t Смещение вправо \n");       
    t0_Perevod_v_dvoichn3.perevod(22);
    t0_Perevod_v_dvoichn3.perevod(22>>1);
    t0_Perevod_v_dvoichn3.perevod(22>>2);
    t0_Perevod_v_dvoichn3.perevod(22>>3);
System.out.print("\t Для отрицательных чисел смещение ВПРАВО работает по другому, первая единица всегда остается \n");       
//Как известно, признаком отрицательного целого числа является единица в старшем разряде, поэтому при сдвиге вправо старший
// (знаковый) разряд сохраняется. Если число положительное, то в него записывается нуль, а если отрицательное - единица.
    t0_Perevod_v_dvoichn3.perevod(-22);
    t0_Perevod_v_dvoichn3.perevod(-22>>1);
    t0_Perevod_v_dvoichn3.perevod(-22>>2);
    
    System.out.print("\t Смещение вправо без знака \n");       
    System.out.print("\t Для отрицательных чисел cмещение вправо без знака означает и смещение старшего бита вправо - переход числа в положительные, т.к. старший бит теперь равен нулю \n");       
    t0_Perevod_v_dvoichn3.perevod(-22);
    t0_Perevod_v_dvoichn3.perevod(-22>>>1);
    t0_Perevod_v_dvoichn3.perevod(-22>>>2);
    t0_Perevod_v_dvoichn3.perevod(-22>>>28);
    
    }
}