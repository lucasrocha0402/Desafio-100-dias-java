import java.text.MessageFormat;

public class dia7 {

    public static void main(String[] args) {
        showMessage("Java", "é", "perfeito");
    }

    private static void showMessage(String param1, String param2, String param3) {
        String message = MessageFormat.format("Essa mensagem contem 3 parametros. The #1 is ''{0}'', the #2 is ''{1}, and the #3 is ''{2}''.",
                param1, param2, param3);
        System.out.printf(message);
    }
}
