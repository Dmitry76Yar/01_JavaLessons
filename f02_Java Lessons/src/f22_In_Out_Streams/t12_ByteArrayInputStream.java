package f22_In_Out_Streams;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

/* ByteArrayInputStream - байтовый входной поток, наследует InpitStream 
Класс ByteArrayInputStream использует байтовый массив в качестве источника данных. Он имеет следующие конструкторы :
	ByteArrayInputStream(byte[] buf);
    ByteArrayInputStream(byte[] buf, int offset, int length);
В качестве параметров конструкторы ByteArrayInputStream используют массив байтов buf для чтения, смещение относительно начала массива
offset и количество считываемых символов length. 
	В отличие от других классов потоков для закрытия объекта ByteArrayInputStream не требует вызывать метод close.
*/

public class t12_ByteArrayInputStream {
public static void main(String[] args) {
	byte byteArray [] = new byte [] {1, 3, 5, 7, 127};
	ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
	int i = 0;
	while ((i = bais.read()) != -1 ) {
		System.out.print(i + "\t");}
	System.out.println();
	
	String str = "Hello World";
	byte[] strArray = str.getBytes();
	ByteArrayInputStream bais2 = new ByteArrayInputStream(strArray, 0, 4);
	i = 0;
	while ((i = bais2.read()) != -1 ) {
		System.out.print((char)i + "\t");} System.out.println();
		
	/* BufferedInputStream служит для организации более эффективного "буферизованного" ввода данных. Буферизация ввода-вывода 
является удобным способом оптимизации производительности, позволяя заключить в оболочку любой поток класса InputStream. 	 */
		String text = "Hello world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream bais4;
        bais4 = new ByteArrayInputStream(buffer);
        try {
            BufferedInputStream bis;
            bis = new BufferedInputStream(bais4); 
            int c;
            while((c = bis.read()) != -1){
                System.out.print((char)c);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
		
	}
}
