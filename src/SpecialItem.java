public class SpecialItem {
    private String item;
    private int delay;

    public SpecialItem(String item, int delay){
        this.item = item;
        this.delay = Math.max(1, delay);
    }

    public String getItem() {
        return item;
    }

    public int getDelay() {
        return delay;
    }
}
