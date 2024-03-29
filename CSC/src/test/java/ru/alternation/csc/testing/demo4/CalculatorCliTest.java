package ru.alternation.csc.testing.demo4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ru.alternation.csc.testing.Calculator;
import ru.alternation.csc.testing.CalculatorCli;

import java.io.StringReader;

import static org.mockito.Mockito.*;

public class CalculatorCliTest {

    private Calculator calculatorMock;
    private CalculatorCli calculatorCli;

    @Before
    public void setUp() {
        calculatorMock = Mockito.mock(Calculator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
    }

    @Test
    public void empty_expressions_must_be_skipped() {
        calculatorCli.runInteractiveSession(new StringReader(";\n;   ;;;\t\n;"));

        Mockito.verifyZeroInteractions(calculatorMock);
    }


    @Test
    public void each_expression_separated_by_semicolon_must_be_evaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));

        Mockito.verify(calculatorMock).calculate("1");
        Mockito.verify(calculatorMock).calculate("2");
        Mockito.verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }


    @Test
    public void each_expression_separated_by_semicolon_must_be_evaluated_2() {
        Mockito.when(calculatorMock.calculate("1")).thenReturn(1d);
        Mockito.when(calculatorMock.calculate("2")).thenReturn(2d);
        Mockito.when(calculatorMock.calculate("3")).thenReturn(3d);

        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
        Mockito.verify(calculatorMock).calculate("1");
        Mockito.verify(calculatorMock).calculate("2");
        Mockito.verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }
}
