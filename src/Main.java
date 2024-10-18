public class Main {
    public static void main(String[] args) {
        DigitalSignature digitalSignature = new DigitalSignature();
        String message = "Hello World!";
        byte[] signature = digitalSignature.signMessage(message);
        System.out.println(digitalSignature.verifySignature(message, signature));
    }
}
