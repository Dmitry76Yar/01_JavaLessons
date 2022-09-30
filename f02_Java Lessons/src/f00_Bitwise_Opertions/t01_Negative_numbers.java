package f00_Bitwise_Opertions;

class t0_Perevod_v_dvoichn {
public static void perevod (int chislo) {
 // Происходит сравнение каждого бита со степенными производными двойки (т.е. только один бит равен 1)
    System.out.print("Число = " + chislo + " в двоичной системе - \t");
    for (int m = 128; m>0; m=m/2)
        if ((chislo&m) != 0) System.out.print("1 "); else System.out.print("0 "); System.out.println();
                  }
    }
            
class t01_Negative_numbers {
    public static void main (String args []) {
  // Унарная поразрядная операция НЕ (или дополнения до l) изменяет на обратное состояние всех битов операнда.
    t0_Perevod_v_dvoichn.perevod(1);
    t0_Perevod_v_dvoichn.perevod(-1);  System.out.println();

    t0_Perevod_v_dvoichn.perevod(5);
    t0_Perevod_v_dvoichn.perevod(-8); 
 // Число (8) - это 00001000. Сначала инвертируем биты = 11110111, добавляем единицу и получаем - 11111000 - это число (-8)
    t0_Perevod_v_dvoichn.perevod(248); 
    System.out.println("Число = 248 в двоичной системе аналогично (-8), но число 248 выходит за 8 бит (byte)");
 
    }
}