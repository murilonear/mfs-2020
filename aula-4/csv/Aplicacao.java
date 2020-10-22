import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class Aplicacao {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv");
		String lerURL;
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite a URL");
		lerURL = leitor.nextLine();
		System.out.println(lerURL);
		if (lerURL != null) {
		  url = new URL(lerURL);
		}
		File file = new File("C:\\Users\\ga_murilovaz\\Desktop\\TEste\\mfs\\aula-4\\csv\\Universidades.csv");
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream(file);
		int bytes = 0;
		while ((bytes = is.read()) != -1) {
			fos.write(bytes);
		}
		is.close();
		fos.close();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String st;
		try {
			while ((st = br.readLine()) != null)
				System.out.println(st);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}