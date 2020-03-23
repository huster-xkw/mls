package 实例包;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @PACKAGE_NAME: 实例包
 * @NAME: instance
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 19:55
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/

/**
 * 建立城市矩阵
 * 包含了该数据的最优解
 */
public class readfile {
    private BufferedReader reader;
    private Instance i = null;
    private long lIROptInstance = 9223372036854775807L;

    public readfile() {
    }

    public long optInstance() {
        return this.lIROptInstance;
    }

    public void buildInstance(String inputFile) {
        try {
            this.setBR(inputFile);
        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
        }

        double[][] coordinates = this.readCoordinates();
        this.i = new Instance(EuclideanCalculator.calc(coordinates));
        if (inputFile.endsWith("wi29.tsp.txt")) {
            this.lIROptInstance = 27603L;
        } else if (inputFile.endsWith("qa194.tsp.txt")) {
            this.lIROptInstance = 9352L;
        } else if (inputFile.endsWith("uy734.tsp.txt")) {
            this.lIROptInstance = 79114L;
        } else if (inputFile.endsWith("zi929.tsp.txt")) {
            this.lIROptInstance = 95345L;
        }

    }

    public Instance getInstance() {
        if (this.i == null) {
            throw new IllegalStateException("The instance has not been built");
        } else {
            return this.i;
        }
    }

    private void setBR(String fileName) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(fileName));
    }

    private double[][] readCoordinates() {
        boolean readingHeader = true;
        boolean readingCoordinates = false;
        int i = 0;
        double[][] coordinates = null;

        try {
            for(String line = this.reader.readLine().trim(); !line.isEmpty() && !line.equals("EOF"); line = this.reader.readLine().trim()) {
                String[] items;
                if (readingHeader) {
                    items = line.split(":");
                    String headerName = items[0].trim().toUpperCase();
                    String headerValue = items.length > 1 ? items[1].trim() : "";
                    if (headerName.equals("DIMENSION")) {
                        int dimension = Integer.parseInt(headerValue);
                        coordinates = new double[dimension][2];
                    }

                    if (headerName.equals("NODE_COORD_SECTION")) {
                        readingHeader = false;
                        readingCoordinates = true;
                    }
                } else if (readingCoordinates) {
                    items = line.split("(\\s)+");
                    coordinates[i][0] = Double.parseDouble(items[1]);
                    coordinates[i][1] = Double.parseDouble(items[2]);
                    ++i;
                }
            }
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        return coordinates;
    }
}
