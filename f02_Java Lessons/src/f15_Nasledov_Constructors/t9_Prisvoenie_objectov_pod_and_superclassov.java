package f15_Nasledov_Constructors;
/*   Java является строго типизированным языком программирования. Это означает, что переменная,
 ссылающаяся на объект класса одного типа, как правило, не может ссылаться на объект класса другого типа. 
    Однако существует одно важное исключение из этоrо: ссылке на объект суперкласса может быть присвоена 
ссылка на объект любого подкласса, производного от данного суперкласса. 
В примере ниже ссылка на объект А суперкласса присваивается ссылке на объект В подкласса, производного от класса А
    Важно указать, что после присвоения объекта А объекту В у объекта А суперкласса не появляется аргументов подкласса, а 
изменяются только собственные аргументы(переменные) (они становятся такими же, как у объекта В подкласса)    */

class Superclass4 {
    int a;
            Superclass4 (int a){
                this.a = a;}
}

class Podclass4 extends Superclass4{
    int b;
            Podclass4 (int a, int b) {
                super(a);
                this.b = b;}
}
class t9_Prisvoenie_objectov_pod_and_superclassov {
public static void main (String[] args){
  Superclass4 A = new Superclass4 (12);
  Podclass4 B = new Podclass4 (1, 2);
  System.out.println(" Данные для объекта A     A.a = " + A.a);
  System.out.println(" Данные для объекта B     B.b = " + B.a + "   B.b = " + B.b); System.out.println();
  
  A = B;
  System.out.println(" Объект A суперкласса присваивается объекту подкласса В");
  System.out.println(" Данные для объекта A     A.a = " + A.a);
  System.out.println(" Данные для объекта B     B.b = " + B.a + "   B.b = " + B.b);
  System.out.println(" Как видно, объект подкласса В не изменился.        У объекта А суперкласса изменилась только переменная А.а (переменной А.b у него не существует)");
  
  // B = A;
  System.out.println("\n Обратное присваивание объекта В подкласса объекту А суперкласса невозможно");
        }
}
