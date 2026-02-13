public class VendingMachine {

    private VendingMachineState idleState;
    private VendingMachineState itemSelectedState;
    private VendingMachineState dispensingState;
    private VendingMachineState outOfOrderState;

    private VendingMachineState currentState;

    private int inventory;
    private double balance;

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.balance = 0;

        idleState = new IdleState(this);
        itemSelectedState = new ItemSelectedState(this);
        dispensingState = new DispensingState(this);
        outOfOrderState = new OutOfOrderState(this);

        currentState = idleState;
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public void selectItem() {
        currentState.selectItem();
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder();
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getItemSelectedState() {
        return itemSelectedState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public VendingMachineState getOutOfOrderState() {
        return outOfOrderState;
    }

    public int getInventory() {
        return inventory;
    }

    public void reduceInventory() {
        inventory--;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void resetBalance() {
        balance = 0;
    }
}
