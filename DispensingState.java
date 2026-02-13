public class DispensingState implements VendingMachineState {

    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem() {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Currently dispensing. Cannot insert coins.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Dispensing item...");
        machine.reduceInventory();
        machine.resetBalance();
        System.out.println("Item dispensed.");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void setOutOfOrder() {
        machine.setState(machine.getOutOfOrderState());
    }
}
