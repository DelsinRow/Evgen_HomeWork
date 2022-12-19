public class Test {
    public static void main(String[] args) {
        String str = "Hello";
        TestInterface testInterface = (string) -> {
            String tmp = str;
            tmp = "Hello ";
            return tmp + string;
        };

        System.out.println(testInterface.function("world"));
    }
}
