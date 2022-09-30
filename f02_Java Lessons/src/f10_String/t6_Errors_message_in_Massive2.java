package f10_String;
// В этом классе имеется метод getErrorMsg (), который возвращает объект типа String, описывающий конкретную ошибку. 
// Объект типа String создается на основании кода ошибки, переданного методу.

class ErrorMsg {
    String msgs [] = {
    "Ошибка вывода", 
    "Ошибка ввода", 
    "Отсутствует место на диске", 
    "Выход индекса за границы диапазона" };
    int error_number[] = {1,2,3,4};

boolean IScorrect (int number){
    if ((number>=0) & (number<msgs.length))  return true;
    else return false;}
    
void Error_display(int number){
    if (IScorrect(number)==true)  System.out.println("Номер ошибки =  " + error_number[number] + "-  " + " \t " + msgs[number]);   
    else System.out.println("Такой ошибки нет");}
}
    
class t6_Errors_message_in_Massive {
    public static void main (String[] args) {
    ErrorMsg a = new ErrorMsg();
    a.Error_display(3);
        
    }
}