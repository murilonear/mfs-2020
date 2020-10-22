import java.io.File;
public class DiretorioListarDir {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\ga_murilovaz\\Desktop\\TEste\\mfs\\aula-4\\dir");
		File[] arquivos = file.listFiles(); 
		for(int i = 0; i < arquivos.length; i++)
			if(arquivos[i].isDirectory())
			   System.out.println(arquivos[i].getName());

	}
}