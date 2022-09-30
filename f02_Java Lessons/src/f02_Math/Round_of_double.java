package f02_Math;

public class Round_of_double {
public static void main(String[] args) {
	
	//Math.ceil() округл€ет до ближайшего целого числа вверх, но отдаЄт не целочисленный тип, а double:
	// ƒаже если у нас будет 34.00000001, все равно после использовани€ Math.ceil мы получим 35,0.
	double value = 34.777774;
	double value1 = 34.00000001;
	double result = Math.ceil(value);
	double result1 = Math.ceil(value1);
	System.out.println((result)); 		//35.0
	System.out.println((result1)); 		//35.0
	
//	Math.floor() округл€ет до ближайшего целого вниз, также результатом отдаЄт double:
	double value3 = 34.777774;
	double value4 = 34.99999999;
	double result3 = Math.floor(value3);
	double result4 = Math.floor(value4);
	System.out.println((result3)); 		//34.0
	System.out.println((result4)); 		//34.0
	
//	Math.round () Ч округл€ет до ближайшего целого числа, как результат отдаЄт int:
	double value5 = 34.777774;
	int result5 = (int) Math.round(value5);
	System.out.println((result5)); //35
	
	/* „тобы не просто обрезать всю вещественную часть, а регулировать этот процесс до определенного количества знаков и 
	 при этом округл€ть, число умножают на 10^n (10 в степени n), где n равно количеству необходимых знаков после зап€той. 
	 ѕосле этого примен€ют какой-нибудь метод класса Math дл€ округлени€, ну а затем снова дел€т на 10^n:			 */
	// Math.pow Ч принимает два аргумента. ѕервый Ч число, второй Ч степень, в которую его нужно возвести.
	double value6 = 34.777774;
	double scale6 = Math.pow(10, 3);
	double result6 = Math.ceil(value6 * scale6) / scale6;
	System.out.println((result6)); //34.778
	
	
	
	}

}
