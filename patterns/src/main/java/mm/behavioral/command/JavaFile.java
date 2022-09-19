package mm.behavioral.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JavaFile {
    private String fileName;
    private String className;
    private List<String> linesContent = new ArrayList<>();

    public void addLine(final String line) {
        linesContent.add(line);
    }

    @Override
    public String toString() {
        return "JavaFile{" +
                "fileName='" + fileName + '\'' +
                ", className='" + className + '\'' +
                ", linesContent=" + String.join("\n", linesContent) +
                '}';
    }
}