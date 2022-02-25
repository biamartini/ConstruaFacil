package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testaCalc {
@Test
    //1 -given configurar
    public void testarSomarDoisNumeros(){
    int num1 = 5;
    int num2 = 7;
    int resultadoEsperado = 12;

    // 2 - executar
       int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

    //3- validar
    System.out.println("O resultado Esperado eh:"+ resultadoEsperado +"\n O resultado Atual foi: "+ resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);

    }
    @Test
    //1 -given configurar
    public void testarSubtrairDoisNumeros(){
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = -2;

        // 2 - executar
        int resultadoAtual = Calc.subtrairDoisNumeros(num1, num2);

        //3- validar
        System.out.println("O resultado Esperado eh:"+ resultadoEsperado +"\n O resultado Atual foi: "+ resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);}
    @Test
    //1 -given configurar
    public void testarMultiplicarDoisNumeros(){
        int num1 = 5;
        int num2 = 5;
        int resultadoEsperado = 25;

        // 2 - executar
        int resultadoAtual = Calc.multiplicarDoisNumeros(num1, num2);

        //3- validar
        System.out.println("O resultado Esperado eh:"+ resultadoEsperado +"\n O resultado Atual foi: "+ resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);}
    @Test
    //1 -given configurar
    public void testarDividrDoisNumeros(){
        int num1 = 5;
        int num2 = 0;
        int resultadoEsperado = 0;

        // 2 - executar
        int resultadoAtual = Calc.dividirDoisNumeros(num1, num2);

        //3- validar
        System.out.println("O resultado Esperado eh:"+ resultadoEsperado +"\n O resultado Atual foi: "+ resultadoAtual);
        assertEquals(resultadoEsperado, resultadoAtual);}
    }
