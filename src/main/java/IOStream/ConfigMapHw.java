package IOStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigMapHw {

    public String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
        if (configMapFilePath == null || keyName == null) {
            return null;
        }
        Map<String, String> collect = Files.lines(configMapFilePath)
                .collect(Collectors.toMap(line -> ((String) line).split("=")[0],
                        line -> ((String) line).split("=")[1]));

        return collect.get(keyName);
    }

    public long getNumberOfFilesWithExtension(Path pathToStartSearch, String extension) throws IOException {
        if (pathToStartSearch == null || extension == null) {
            return 0;
        }

        try (Stream<Path> stream = Files
                .find(pathToStartSearch, Integer.MAX_VALUE, (specificPath, attr)
                        -> String.valueOf(specificPath).endsWith(extension))

        ) {
            return stream.count();
        }

    }

}