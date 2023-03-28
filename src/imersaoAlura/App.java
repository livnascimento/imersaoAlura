package imersaoAlura;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// conexão e get dos dados

		URI endereco = URI.create("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		// tratamento de resposta
		
		var parser = new JsonParser();
		List<Map<String, String>> listaFilmes = parser.parse(body);
		
		// exibição de título, imagem e classificação
		
		GeradorFigurinhas gerador = new GeradorFigurinhas();

		for (Map<String, String> filme : listaFilmes) {
			InputStream inputStream = new URL(filme.get("image")).openStream();
			
			String nomeArquivo = filme.get("title") + ".png";
			
			gerador.cria(inputStream, nomeArquivo);
			
			System.out.println(filme.get("title") + "\n");
		}
		
	}

}
