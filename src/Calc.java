public record Calc(double a, double b) {

    public double somar(){
        return a+b;
    }

    public double subtracao(){
        return a-b;
    }

    public double multiplicacao(){
        return a*b;
    }

    public double divisao(){
        return a/b;
    }
}
