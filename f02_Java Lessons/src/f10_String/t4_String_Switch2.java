package f10_String;
class t4_String_Switch{
    public static void main (String [] args) {
    
        String command = "cancel";
            switch(command) {
                case "connect":     System.out.println("Пoдключeниe");          break;
                case "cancel":      System.out.println("Oтмeнa");               break;
                case "disconnect":  System.out.println("Oтключeниe");           break;
                default:            System.out.println("Heвepнaя команда!");    break;
            }
        }
    }
