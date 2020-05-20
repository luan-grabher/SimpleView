package SimpleView;

import javax.swing.JOptionPane;

public class View {

    private static boolean showMessages = true;

    public static void render(String message) {
        render(message, "");
    }

    public static void render(String message, String typeMessage) {
        if (showMessages) {
            int numberType;
            switch (typeMessage) {
                case "error":
                    numberType = JOptionPane.ERROR_MESSAGE;
                    break;
                case "question":
                    numberType = JOptionPane.QUESTION_MESSAGE;
                    break;
                default:
                    numberType = JOptionPane.INFORMATION_MESSAGE;
                    break;
            }
            JOptionPane.showMessageDialog(null, message, "MENSAGEM DO SISTEMA:", numberType);
        } else {
            String typeMessageString = typeMessage.equals("") ? "" : "[" + typeMessage.toUpperCase() + "] ";
            System.out.println(typeMessageString + message);
        }
    }

    public static void setShowMessages(boolean mostrarMensagens) {
        View.showMessages = mostrarMensagens;
    }

    public static int chooseButton(String message, String[] buttons) {
        return JOptionPane.showOptionDialog(null, message, "Escolha:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                buttons, buttons[0]);
    }

    public static String getInputString(String message) {
        String r = "";
        try {
            r = JOptionPane.showInputDialog(message);
        } catch (Exception e) {
        }
        return r;
    }
}
