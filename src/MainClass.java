import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {

        GetArray tb = new GetArray("test1.txt");
        WhatIsIt result = new WhatIsIt(tb.GetArray(), tb.getLen());
        System.out.println(result.whatIsIt());
    }
}
