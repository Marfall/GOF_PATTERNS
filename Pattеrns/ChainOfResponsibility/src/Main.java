// разбиваем метод на три отдельных класса и каждый из них занимается своим аспектом.
// то есть когда один посылает а другой печатает - все проходит через цепочку вызовов хэндлеров
// и один вызов обрабатывается несколькими классами
// То есть один метод разбиваем на аспекты


public class Main {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageAddExplanationMarkHandler(
                new MessageVerifyHandler(new MessagePrintHandler(null)));
        messageHandler.handle("hello world!");
    }
}

abstract class MessageHandler {
    MessageHandler messageHandler;

    public MessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    abstract  void handle(String msg);
}

class MessagePrintHandler extends MessageHandler {

    public MessagePrintHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String msg) {
        System.out.println(msg);
    }
}

class MessageVerifyHandler extends MessageHandler {

    public MessageVerifyHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String msg) {
        if (msg.matches(".*\\d*")) {
            messageHandler.handle(msg);
        }
    }
}

class MessageAddExplanationMarkHandler extends MessageHandler {

    public MessageAddExplanationMarkHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String msg) {
        messageHandler.handle(msg + "!");
    }
}