import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalcPFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Configurações da janela
        primaryStage.setTitle("Calculadora");

        // Criando os componentes da interface
        Label label1 = new Label("Primeiro número:");
        Label label2 = new Label("Segundo número:");
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        Label resultadoLabel = new Label("Resultado:");
        TextField resultadoField = new TextField();
        resultadoField.setEditable(false); // Campo não editável

        // Botões de operação
        Button btnSoma = new Button("Somar");
        Button btnSubtracao = new Button("Subtrair");
        Button btnMultiplicacao = new Button("Multiplicar");
        Button btnDivisao = new Button("Dividir");

        // GridPane para organizar os componentes
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Adicionando os componentes no GridPane
        grid.add(label1, 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(btnSoma, 0, 2);
        grid.add(btnSubtracao, 1, 2);
        grid.add(btnMultiplicacao, 0, 3);
        grid.add(btnDivisao, 1, 3);
        grid.add(resultadoLabel, 0, 4);
        grid.add(resultadoField, 1, 4);

        // Ações dos botões
        btnSoma.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            resultadoField.setText(String.valueOf(num1 + num2));
        });

        btnSubtracao.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            resultadoField.setText(String.valueOf(num1 - num2));
        });

        btnMultiplicacao.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            resultadoField.setText(String.valueOf(num1 * num2));
        });

        btnDivisao.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            if (num2 != 0) {
                resultadoField.setText(String.valueOf(num1 / num2));
            } else {
                resultadoField.setText("Erro: Divisão por zero");
            }
        });

        // Cena e exibição
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
