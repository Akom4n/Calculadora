import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalcP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double a,b;
        System.err.printf("1-Soma %n2-Subtração%n3-Multiplicação%n4-Divisão%n5-Sair%n");
        System.out.println("Escolha a opção: ");
        int op=sc.nextInt();

        switch(op){
            case 1:
                System.out.println("Escolha o primeiro valor:");
                a = sc.nextDouble();

                System.out.println("Escolha o segundo valor:");
                b = sc.nextDouble();
                Calc resultado = new Calc(a, b);
                System.out.println("A soma de: " + a + " + " + b + " é " + resultado.somar());
                break;

            case 2:
                System.out.println("Escolha o primeiro valor:");
                a = sc.nextDouble();

                System.out.println("Escolha o segundo valor:");
                b = sc.nextDouble();
                Calc resultado2 = new Calc(a, b);
                System.out.println("A soma de: " + a + " - " + b + " é " + resultado2.subtracao());
                break;
            case 3:
                System.out.println("Escolha o primeiro valor:");
                a = sc.nextDouble();

                System.out.println("Escolha o segundo valor:");
                b = sc.nextDouble();
                Calc resultado3 = new Calc(a, b);
                System.out.println("A multiplicação de: " + a + " * " + b + " é " + resultado3.multiplicacao());
                break;

            case 4:
                System.out.println("Escolha o primeiro valor:");
                a = sc.nextDouble();

                System.out.println("Escolha o segundo valor:");
                b = sc.nextDouble();
                Calc resultado4 = new Calc(a, b);
                System.out.println("A divisão de: " + a + " / " + b + " é " + resultado4.divisao());
                break;

                default:
                break;
        }

        sc.close();
    }
}