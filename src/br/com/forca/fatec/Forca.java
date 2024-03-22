package br.com.forca.fatec;
import java.util.Scanner;

public class Forca {
    private String palavra;
    private StringBuilder palavraEscondida;
    private int tentativasRestantes;

    public Forca(String palavra, int tentativas) {
        this.palavra = palavra.toUpperCase();
        this.tentativasRestantes = tentativas;
        this.palavraEscondida = new StringBuilder(palavra.replaceAll(".", "_"));
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0 && palavraEscondida.indexOf("_") != -1) {
            System.out.println("Palavra: " + palavraEscondida.toString());
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().toUpperCase();

            if (entrada.length() != 1) {
                System.out.println("Por favor, digite apenas uma letra.");
                continue;
            }

            char letra = entrada.charAt(0);
            boolean acertou = false;

            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra) {
                    palavraEscondida.setCharAt(i, letra);
                    acertou = true;
                }
            }
            if (!acertou) {
                tentativasRestantes--;
                desenharForca();
            }
        }
        scanner.close();

        if (tentativasRestantes > 0) {
            System.out.println("Parabéns, você ganhou! A palavra era: " + palavra);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavra);
        }
    }

    private void desenharForca() {
        switch (tentativasRestantes) {
            case 6:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 5:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 4:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |       |");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 3:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 2:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 1:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |      /");
                System.out.println("_|___");
                break;
            case 0:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |      / \\");
                System.out.println("_|___");
                break;
        }
    }

}
