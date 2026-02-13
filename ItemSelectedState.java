public class ItemSelectedState implements VendingMachineState {

    private VendingMachine machine;
    private static final double ITEM_PRICE = 10.0;

    public ItemSelectedState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        System.out.println("Item already selected.");
    }

    @Override
    public void insertCoin(double amount) {
        machine.addBalance(amount);
        System.out.println("Inserted: " + amount);

        if (machine.getBalance() >= ITEM_PRICE) {
            machine.setState(machine.getDispensingState());
            machine.dispenseItem();
        }
    }

    @Override
    public void dispenseItem() {
        if (machine.getBalance() >= ITEM_PRICE) {
            machine.setState(machine.getDispensingState());
            machine.dispenseItem();
        } else {
            System.out.println("Not enough balance.");
        }
    }

    @Override
    public void setOutOfOrder() {
        machine.setState(machine.getOutOfOrderState());
    }
}
