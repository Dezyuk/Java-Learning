package IOStream;

import java.io.IOException;
import java.nio.file.Path;

public class Demo {
    static void main() throws IOException {
        ConfigMapHw s = new ConfigMapHw();
        String a = s.getValueFromConfigMap(Path.of("a"), "discount");
        System.out.println(a);
    }
}
