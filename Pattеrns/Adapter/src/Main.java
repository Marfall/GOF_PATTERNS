class Main {
    public static void main(String[] args) {
        SipmpleAmericanSocket socket = new SipmpleAmericanSocket();
        EuroSocket euroSocket = new SocketAdapter(socket);
        Radio radio = new Radio();
        radio.listenMusic(euroSocket);
    }
}
    interface EuroSocket {
        void getPower();
    }

    // адптер в конструкторе принимает американскую розетку и ее использует
    // в методе getPower() при переопределении

    class SocketAdapter implements EuroSocket {

        AmericanSocket americanSocket;

        public SocketAdapter(AmericanSocket americanSocket) {
            this.americanSocket = americanSocket;
        }

        @Override
        public void getPower() {
            americanSocket.getPower();
        }
    }

    interface AmericanSocket {
        void getPower();
    }

    class SipmpleAmericanSocket implements AmericanSocket {

        @Override
        public void getPower() {
            System.out.println("get\n110 volt");
        }
    }

    class Radio {
        public void listenMusic(EuroSocket euroSocket) {
            euroSocket.getPower();
        }
    }

//  - создаем 2 интерфейса - Euro, American
//  - создаем  класс-адаптер, имплементим ему первый интерфейс - Euro, создаем поле второго - American
//  - в конструкторе адапетра принимаем переменную второго - American
//  - целевой объект принимает методе объект Euro и на нем вызываем get()
