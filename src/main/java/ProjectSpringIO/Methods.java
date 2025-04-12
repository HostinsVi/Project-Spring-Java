package ProjectSpringIO;

import java.text.DecimalFormat;

public class Methods {

    public boolean confirmarValores(double peso, double altura) {
        return peso > 0 && altura > 0;
    }

    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String formatarIMC(double imc) {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(imc);
    }

    public String gerarIndicacao(double imc) {
        if (imc < 18.5) {
            return "Você está abaixo do peso ideal, vai comer uma pizza, seja feliz!";
        } else if (imc <= 24.9) {
            return "Você está no peso ideal, Parabéns!";
        } else if (imc <= 25) {
            return "Você está levemente acima do peso. uma maçã aqui e ali resolve!";
        } else if (imc <= 30) {
            return "Você está no primeiro nível de obesidade. Uma alimentação mais equilibrada é o segredo pra um eu mais equilibrado!";
        } else if (imc <= 35) {
            return "Voce está no segundo nível de obesidade. Vamo dar uma mudança no estilo de vida pra ter um futuro melhor!";
        } else {
            return "Você está no terceiro nível de obesidade. Talvez seja uma boa hora de buscar ajuda para mudar sua alimentação e melhorar sua saúde. Estamos torcendo por você!";
        }
    }
}
