package ru.alternation.Trash.Others.Trash.SuppressedExceptions;



// http://howtodoinjava.com/java-7/suppressed-exceptions-in-java-7/



public class DirtyResource implements AutoCloseable
{
    /**
     * Need to call this method if you want to access this resource
     * @throws RuntimeException no matter how you call this method
     * */
    public void accessResource()
    {
        throw new RuntimeException("From 'void accessResource()'");
    }

    /**
     * The overridden closure method from AutoCloseable interface
     * @throws Exception which is thrown during closure of this dirty resource
     * */
    @Override
    public void close() throws Exception
    {
        throw new NullPointerException("From 'void close()'");
    }
}