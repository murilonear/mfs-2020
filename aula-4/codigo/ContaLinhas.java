import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException ;
import java.io.LineNumberReader;
import java.nio.file.FileVisitResult ;
import java.nio.file.Files ;
import java.nio.file.Path ;
import java.nio.file.Paths ;
import java.nio.file.SimpleFileVisitor ;
import java.nio.file.attribute.BasicFileAttributes ;

public class ContaLinhas {

        public static void main(String[] args) {
            int contaLinhas = 0;
            int somaLinhas = 0;
            try {
                Path startPath = Paths.get("C:\\Users\\ga_murilovaz\\Desktop\\TEste\\mfs\\aula-4");
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws FileNotFoundException, IOException {
                        if (file.toString().endsWith(".class") || file.toString().endsWith(".java")){
                            LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(file.toString()));
                            linhaLeitura.skip(file.toString().length());
                            int contaLinhas = linhaLeitura.getLineNumber();
                            int somaLinhas =+ contaLinhas;
                            System.out.println("Total de linhas de todos os arquivos: " + somaLinhas); 
                            System.out.println("Total de linhas: " + contaLinhas + " Arquivo: " + file.toString());
                        }
                    return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException e) {
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
            }
        }
}