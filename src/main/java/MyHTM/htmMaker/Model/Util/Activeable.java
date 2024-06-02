package MyHTM.htmMaker.Model.Util;

public abstract class Activeable {
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void activate() {
        isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }
}
