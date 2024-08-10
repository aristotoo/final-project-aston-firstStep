package com.aston.project.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtFileFilling {
    private TypeFillingStrategy typeFillingStrategy;
    private String uri;

    public TxtFileFilling(TypeFillingStrategy typeFillingStrategy, String uri) {
        this.typeFillingStrategy = typeFillingStrategy;
        this.uri = uri;
    }

    public TypeFillingStrategy getTypeFillingStrategy() {
        return typeFillingStrategy;
    }

    public void setTypeFillingStrategy(TypeFillingStrategy typeFillingStrategy) {
        this.typeFillingStrategy = typeFillingStrategy;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void parsingFile() {
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(uri)))
                    .replaceAll("[\\n\\r]", "");
        } catch (IOException e) {
            System.out.println("Error reading file: " + uri);;
        }
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(text);
        List<String> lines = new ArrayList<>();
        while (matcher.find()) {
            lines.add(matcher.group(1));
        }
        if (lines.isEmpty()) {
            return;
        }
        for (String line : lines) {
            String[] split = line.split(",");
            Map<String, String> parameters = Stream.of(split)
                    .collect(Collectors.toMap(s1 -> customSplit(s1)[0], s2 -> customSplit(s2)[1]));
            typeFillingStrategy.filling(parameters);
        }

    }

    private String[] customSplit(String s) {
        String[] split = s.split(":");
        if (split.length < 2) {
            return new String[]{split[0], ""};
        } else {
            return split;
        }
    }
}
