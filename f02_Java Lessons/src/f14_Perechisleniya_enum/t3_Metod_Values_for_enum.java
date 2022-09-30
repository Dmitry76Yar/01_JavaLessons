package f14_Perechisleniya_enum;
// Cтатический метод values()  массив всех констант перечислени€ в том пор€дке, в котором он были инициализированы

public class t3_Metod_Values_for_enum {
	public static void main(String[] args) {
		
			// ћетод values() возвращает массив всех констант перечислени€:
		Type1[] types = Type1.values();
        for (Type1 s : types) {System.out.println(s); }     
        
        	// ћетод valuesOf() "вычлен€ет" в переменную temp1 класса Type1 вызываемую константу  или генерит исключение, если не нашла
        Type1 temp1 = Type1.valueOf("SCIENCE");
        System.out.println("\n" + temp1);
        
        try { Type1.valueOf("SCIENC__E"); 	} 
        catch (Exception e) {
			System.out.println("Ќе существует такого перечислени€");}
	}
}

enum Type1
{   SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}