import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GetArray {

    private String fileName;
    private int[][] tableCayley;
    private int size;

    public GetArray(String fileName) {
        this.fileName = fileName;
    }

    public int[][] GetArray() throws IOException {

        Scanner scanner = new Scanner(new File(fileName));
        size = scanner.nextInt();
        tableCayley = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tableCayley[i][j] = scanner.nextInt();
            }
        }

        return tableCayley;
    }

    public int getSize() {
        return size;
    }
}
