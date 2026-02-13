public class IdleState implements VendingMachineState {

    private VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        if (machine.getInventory() > 0) {
            System.out.println("Item selected.");
            machine.setState(machine.getItemSelectedState());
        } else {
            System.out.println("Out of stock.");
            machine.setState(machine.getOutOfOrderState());
        }
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Select an item first.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("No item selected.");
    }

    @Override
    public void setOutOfOrder() {
        machine.setState(machine.getOutOfOrderState());
    }
}
