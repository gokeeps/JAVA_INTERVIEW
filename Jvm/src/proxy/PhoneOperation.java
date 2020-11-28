package proxy;

public class PhoneOperation implements Operation {
    @Override
    public String processInfo(String message) {
        System.out.println("Phone process");
        return "phone process " + message;
    }

    @Override public void show() {
        System.out.println("呵呵");
    }
}
