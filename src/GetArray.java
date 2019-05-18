import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GetArray {

    private String fileName;
    private int[][] tableCayley;
    private int len;

    public GetArray(String fileName) {
        this.fileName = fileName;
    }

    public int[][] GetArray() throws IOException {

        //int[][] tableCayley;
        int[] table;
        int c, size = 0, i = 0, j = 0;
        int[] buf = new int[256];

        FileReader reader = new FileReader(fileName);
        while ((c = reader.read()) != -1) {
            if ((char) c != ' ' && (char) c != '\n' && (char) c != '\r') {
                if (i != 0 && j != 0) {
                    buf[size] = c - '0';
                    size++;
                }
                i++;
            }
            if ((char) c == '\n' || (char) c == '\r') {
                i = 0;
                j++;
            }
        }

        len = (int)Math.sqrt(size);
        tableCayley = new int[len][len];
        i = 0;
        table = Arrays.copyOf(buf, size);
        for (int k = 0; k < len; k++) {
            for (int t = 0; t < len; t++) {
                tableCayley[k][t] = table[i];
                i++;
            }
        }

        return tableCayley;
    }

    public int getLen() {
        return len;
    }
}
