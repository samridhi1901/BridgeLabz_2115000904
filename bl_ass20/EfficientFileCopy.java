import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        
        long startTime, endTime;
        
        // Unbuffered File Copy
        startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while copying file: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endTime - startTime) / 1e6 + " ms");
        
        // Buffered File Copy
        startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while copying file: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
