package f10_String;
// В этом классе имеется метод getErrorMsg (), который возвращает объект типа String, описывающий конкретную ошибку. 
// Объект типа String создается на основании кода ошибки, переданного методу.

class Err {
    String msg;
    int error_number;
    
    Err (String msg, int error_number){
        this.msg = msg; 
        this.error_number = error_number;}
     }
    
 class ErrorInfo {
    String msgs[] = {
                "Ошибка вывода", 
                "Ошибка ввода", 
                "Отсутствует место на диске", 
                "Выход индекса за границы диапазона"};
    int error_numbers[] = {1,2,3,4};
    
    Err ErrorGetInfo(int index) {
        if ((index>=0) & (index < msgs.length))    return new Err (msgs[index], error_numbers[index]);
        else return new Err ("Несуществующий номер ошибки", 0);
   }
}

class t7_Errors_message_in_Massive_Complex {
    public static void main (String[] args) {
    Err b = new Err("",0);          // Создание объекта класса Err c пустыми данными для послед. записи в него данных
    ErrorInfo c = new ErrorInfo();  // Создание объекта класса ErrorInfo, чтобы можно было использовать метод ErrorGetInfo
    b = c.ErrorGetInfo(2);          // �?спользование метода ErrorGetInfo и сразу запись результата в объект b класса Err
    
    System.out.println(b.msg);      // Чтение параметров объекта b класса Err
    System.out.println(b.error_number);
    
   
}
}