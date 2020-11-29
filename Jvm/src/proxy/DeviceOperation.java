package proxy;


public class DeviceOperation implements Operation {

    @Override public String processInfo(String message) {
        return "DEVICE processInfo";
    }

    @Override public void show() {
        System.out.println("DEVICE show");
    }

    @Override public void test() {

    }
}
