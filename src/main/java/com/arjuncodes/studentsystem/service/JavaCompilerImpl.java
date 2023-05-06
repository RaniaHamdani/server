package com.arjuncodes.studentsystem.service;

import javax.tools.ToolProvider;
import java.io.*;

public class JavaCompilerImpl {
    public static String compileAndExecuteJavaCode(String javaCode) {
        // Define the custom file name for the Java code
        String fileName = "HelloWorld.java";

        // Create a temporary file with the custom file name
        File tempFile;
        try {
            File tempDir = new File(System.getProperty("java.io.tmpdir"));
            tempFile = new File(tempDir, fileName);
            tempFile.deleteOnExit(); // Delete the file when the JVM exits
            FileWriter fileWriter = new FileWriter(tempFile);
            fileWriter.write(javaCode);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "There is an issue: " + e;
        }

        // Get the Java compiler
        javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // Capture the standard output and standard error streams during compilation
        StringBuilder compilationOutput = new StringBuilder();
        try {
            ByteArrayOutputStream compilationErrorStream = new ByteArrayOutputStream();
            int compilationResult = compiler.run(null, null, compilationErrorStream, tempFile.getAbsolutePath());

            if (compilationResult == 0) {
                System.out.println("Compilation successful!");

                // Execute the compiled Java code
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", tempFile.getParent(), fileName.substring(0, fileName.indexOf(".java")));
                pb.redirectErrorStream(true);
                Process executionProcess = pb.start();
                BufferedReader executionReader = new BufferedReader(
                        new InputStreamReader(executionProcess.getInputStream()));
                String executionLine;
                StringBuilder executionOutput = new StringBuilder();
                while ((executionLine = executionReader.readLine()) != null) {
                    executionOutput.append(executionLine).append("\n");
                }
                executionReader.close();

                // Capture the standard error stream during execution
                BufferedReader executionErrorReader = new BufferedReader(
                        new InputStreamReader(executionProcess.getErrorStream()));
                String executionErrorLine;
                while ((executionErrorLine = executionErrorReader.readLine()) != null) {
                    executionOutput.append(executionErrorLine).append("\n");
                }
                executionErrorReader.close();

                // Check if there is any runtime exception during execution
                try {
                    int executionResult = executionProcess.waitFor();
                    if (executionResult == 0) {
                        System.out.println("Execution successful!");
                        return "Execution Successful\n" + executionOutput.toString();
                    } else {
                        System.out.println("Execution failed with error code: " + executionResult);
                        return "Execution failed with error code: " + executionResult + "\n" + executionOutput.toString();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return "There is an issue: " + e;
                }

            } else {
                System.out.println("Compilation failed with error code: " + compilationResult);
                return "Compilation failed with error code: " + compilationResult + "\n" + compilationErrorStream.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "There is an issue: " + e;
        }
    }
}