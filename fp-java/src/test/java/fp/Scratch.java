package fp;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;

public class Scratch {

    public static void main(String[] args) throws Exception {
        String source = "package test; public class Test { static { System.out.println(\"hello\"); }}";

        File root = new File("/java");
        File sourceFile = new File(root, "test/Test.java");
        sourceFile.getParentFile().mkdirs();
        Files.write(source.getBytes(), sourceFile);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());

        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
        Class<?> cls = Class.forName("test.Test", true, classLoader);
        // prints "hello".
    }
}
