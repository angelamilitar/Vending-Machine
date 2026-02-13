public class Main {
    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine(5);

        machine.selectItem();
        machine.insertCoin(5);
        machine.insertCoin(5);
    }
}
