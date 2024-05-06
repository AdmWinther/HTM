package MyHTM.htmMaker.Model.Classes;

public record Pair<U, R>(Object first, Object second) {
    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }
}
