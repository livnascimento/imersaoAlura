package imersaoAlura;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
		
		//leitura da imagem
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// capturando tamanho e criando nova altura
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 350;
		
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiando imagem original pra nova imagem
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// setando fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setFont(fonte);
		
		// setando cor da fonte
		graphics.setColor(Color.YELLOW);
		
		// escrevendo na imagem nova
		graphics.drawString("fig gerada com java", 10, novaAltura - 100);
		
		// criando pasta para armazenar a fig
//		File pasta = new File ("C:/Users/livia/eclipse-workspace/imersaoAlura/figurinhas");
//		pasta.mkdirs();
		
		//criando fig
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
	}

}
