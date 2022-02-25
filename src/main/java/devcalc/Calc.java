//partes de uma classe

//1- pacote (endereco)
package devcalc;
//2 - biblioteca (mvn repository)(o que ele recebe)

import java.util.Scanner;

//3 - classe (classe por cada arquivo)(quem e o fulano)
public class Calc {
    //3.1 atributo (caracteristicas fisicas)
    static Scanner entrada = new Scanner(System.in);

    //3.2 metodos e funcoes( o que faz: nadar e correr metodo n'ao da retorno a funcao da)

    public static void main (String[] args){
        System.out.println(">>Calculadora<<");
        System.out.println("(1)somar");
        System.out.println("(2)subtrair");
        System.out.println("(3)multiplicar");
        System.out.println("(4)dividir");
        System.out.print("escolha o calculo desejado: ");

        //recebe a opcao desejada
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;
        //pergunta os valores a sere usados na calculadora

       if (opcao >=1 && opcao <=4){;
        System.out.print("Entre o 1' número: ");
        num1 = entrada.nextInt();
        System.out.print("Entre o 2' número: ");
        num2 = entrada.nextInt();
        System.out.print("O Resultado é:");}

        //chama funcao do calculo desejado
        switch (opcao){
            case 1:
                System.out.println(somarDoisNumeros(num1, num2));
                    break;
            case 2:
                System.out.println(subtrairDoisNumeros(num1, num2));
                    break;
            case 3:
                System.out.println(multiplicarDoisNumeros(num1, num2));
                break;
            case 4:
                System.out.println(dividirDoisNumeros(num1, num2));
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }

    }

    public static int somarDoisNumeros(int num1, int num2) {
                return num1 + num2;}
    public static int subtrairDoisNumeros(int num1, int num2){
                return num1 - num2;}
    public static int multiplicarDoisNumeros( int num1, int num2 ){
            return num1 * num2;}
    public static int dividirDoisNumeros( int num1, int num2 ){
        return num1 / num2;}
}
