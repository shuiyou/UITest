package Image;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hanxiaodi on 17/8/31.
 */
public class TestPDFtoJPG
{
	public static void main(String[] args)
	{
		try
		{
			new TestPDFtoJPG().Pdf_Png(1);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void Pdf_Png(int pageNumber) throws IOException
	{
		int pagen = pageNumber;
		File file = new File("/Users/hanxiaodi/Downloads/ahc11_campaign-guide_web.pdf");
		PDFFile pdffile = null;
		try
		{
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			FileChannel channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			pdffile = new PDFFile(buf);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		// print 出该 pdf 文档的页数
		System.out.println(pdffile.getNumPages());

		// 设置将第 pagen 页生成 png 图片
		PDFPage page = pdffile.getPage(pagen);

		// create and configure a graphics object
		Rectangle rectangle = new Rectangle(0, 0, ((int) page.getBBox().getWidth()), ((int) page.getBBox().getHeight()));
		//int width = (int) page.getBBox().getWidth();
		//int height = (int) page.getBBox().getHeight();
		Image img = page.getImage(rectangle.width, rectangle.height, rectangle, null, true, true);
		BufferedImage tag = new BufferedImage(rectangle.width, rectangle.height, BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(img, 0, 0, rectangle.width, rectangle.height, null);
		// Graphics2D g2 = img.createGraphics();

		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// do the actual drawing
		FileOutputStream out = new FileOutputStream("/Users/hanxiaodi/Downloads/ahc11_campaign-guide_web.jpg"); // 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param2 = encoder.getDefaultJPEGEncodeParam(tag);
		param2.setQuality(1f, false);// 1f是提高生成的图片质量
		encoder.setJPEGEncodeParam(param2);
		encoder.encode(tag); // JPEG编码
		out.close();
/*	  PDFRenderer renderer = new PDFRenderer(page, g2, new Rectangle(0, 0, width, height), null, Color.WHITE);
	  try {
		  page.waitForFinish();
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  renderer.run();
	  g2.dispose();

	  try {
		  ImageIO.write(img, "png", new File("/Users/hanxiaodi/Downloads/ahc11_campaign-guide_web.png"));
		  System.out.println("S");
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }*/
	}

}




