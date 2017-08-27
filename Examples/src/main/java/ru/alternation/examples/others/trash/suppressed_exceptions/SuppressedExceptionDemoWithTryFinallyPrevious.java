package ru.alternation.examples.others.trash.suppressed_exceptions;


import static java.lang.System.err;

public class SuppressedExceptionDemoWithTryFinallyPrevious
{
    /**
     * Executable member function demonstrating suppressed exceptions
     * One exception is lost if not added in suppressed exceptions list
     */

/*

Exception encountered: java.lang.NullPointerException: From 'void close()'

*/
    public static void memberFunction() throws Exception
    {
        DirtyResource resource= new DirtyResource();
        try
        {
            resource.accessResource();
        }
        finally
        {
            resource.close();
        }
    }

    public static void main(String[] arguments) throws Exception
    {
        try
        {
            memberFunction();
        }
        catch(Exception ex)
        {
            err.println("Exception encountered: " + ex.toString());
            final Throwable[] suppressedExceptions = ex.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0)
            {
                err.println("\tThere are " + numSuppressed + " suppressed exceptions:");
                for (final Throwable exception : suppressedExceptions)
                {
                    err.println("\t\t" + exception.toString());
                }
            }
        }
    }
}

