import java.util.Vector;

class MyStack<E> {
    Vector<E> myStack = new Vector<E>();

    public void push( E anElement ) {
        myStack.add(anElement);
    }
    public E pop() {

        if ( ! myStack.isEmpty() )	{
            E anElement = myStack.lastElement();
            myStack.remove(myStack.size() - 1) ;
            return anElement;
        } else  {
            return null;
        }
    }
    public boolean isEmpty()	{
        return myStack.isEmpty();
    }
}

interface I1 			{ }
class A1 			{ }
class A2 extends A1		{ }
class A3 extends A2		{ }
class A4 extends A2 implements I1 { }

class GenericQ {

    private static void m1(MyStack<? extends A3> aStack)  {	}
    private static void m2(MyStack<?> aStack)  {	}
    private static void m3(MyStack<? super A3> aStack)  {	}

    public static void testMyStack()	{
        MyStack<Integer>          aMyStack = new MyStack<>();
        Vector<MyStack<Integer>>  aVector  = new Vector<MyStack<Integer>>();
        MyStack<MyStack<Integer>> bMyStack = new MyStack<MyStack<Integer>>();
        Vector<MyStack<MyStack<Integer>>>
                bVector  = new Vector<MyStack<MyStack<Integer>>>();

        MyStack<A1> aA1 = new MyStack<>();
        MyStack<A2> aA2 = new MyStack<>();
        MyStack<A3> aA3 = new MyStack<>();
        MyStack<A4> aA4 = new MyStack<>();

        m1(aA3);
        m2(aA1);
        m2(aA2);
        m2(aA3);
        m2(aA4);
        m3(aA3);
        m3(aA2);
        m3(aA1);

        aVector.add( aMyStack );
        bVector.add( bMyStack );
    }
    public static void main(String args[] )	{
    }
}