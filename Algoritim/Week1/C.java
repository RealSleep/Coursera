public class C  {
    public static void main(String[] args) throws java.io.IOException {
        String command = "shutdown -s";
        Runtime.getRuntime().exec(command);
    }
}