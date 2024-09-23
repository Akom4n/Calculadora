import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalcPFX extends Application {

    private double resultadoAnterior = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculadora");

        // Criando os componentes da interface
        Label label1 = new Label("Primeiro número:");
        TextField num1Field = new TextField();
        Label label2 = new Label("Segundo número:");
        TextField num2Field = new TextField();
        Label resultadoLabel = new Label("Resultado:");
        TextField resultadoField = new TextField();
        resultadoField.setEditable(false); // Campo não editável

        CheckBox usarResultadoAnterior = new CheckBox("Usar resultado anterior");

        // Botões de operação
        Button btnSoma = new Button("Somar");
        Button btnSubtracao = new Button("Subtrair");
        Button btnMultiplicacao = new Button("Multiplicar");
        Button btnDivisao = new Button("Dividir");

        // Layouts HBox para organizar os botões em uma linha
        HBox hBoxBotoes = new HBox(10);  // Espaçamento de 10px entre os botões
        hBoxBotoes.getChildren().addAll(btnSoma, btnSubtracao, btnMultiplicacao, btnDivisao);

        // VBox para organizar os componentes verticalmente
        VBox vBoxLayout = new VBox(15);  // Espaçamento de 15px entre os componentes
        vBoxLayout.setPadding(new Insets(15));
        vBoxLayout.getChildren().addAll(
                label1, num1Field,
                label2, num2Field,
                usarResultadoAnterior,
                hBoxBotoes,
                resultadoLabel,
                resultadoField
        );

        // Ações dos botões
        btnSoma.setOnAction(e -> realizarOperacao(num1Field, num2Field, resultadoField, "+", usarResultadoAnterior));
        btnSubtracao.setOnAction(e -> realizarOperacao(num1Field, num2Field, resultadoField, "-", usarResultadoAnterior));
        btnMultiplicacao.setOnAction(e -> realizarOperacao(num1Field, num2Field, resultadoField, "*", usarResultadoAnterior));
        btnDivisao.setOnAction(e -> realizarOperacao(num1Field, num2Field, resultadoField, "/", usarResultadoAnterior));

        // Cena e exibição
        Scene scene = new Scene(vBoxLayout, 400, 400);
        scene.getStylesheets().add("style.css");  // Atualize o caminho para o arquivo CSS
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void realizarOperacao(TextField num1Field, TextField num2Field, TextField resultadoField, String operador, CheckBox usarResultadoAnterior) {
        double num1 = getFirstNumber(num1Field, usarResultadoAnterior);
        double num2 = Double.parseDouble(num2Field.getText());
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    resultadoField.setText("Erro: Divisão por zero");
                    return;
                }
                break;
        }

        resultadoField.getStyleClass().add("resultado-field");
        resultadoField.setText(String.valueOf(resultado));
        resultadoAnterior = resultado;
    }

    private double getFirstNumber(TextField num1Field, CheckBox usarResultadoAnterior) {
        if (usarResultadoAnterior.isSelected()) {
            return resultadoAnterior;
        } else {
            return Double.parseDouble(num1Field.getText());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
