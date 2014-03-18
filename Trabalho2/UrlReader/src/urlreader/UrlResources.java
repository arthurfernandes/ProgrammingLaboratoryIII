
package urlreader;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author arthurfernandes
 */
public class UrlResources{
    
   
    public static void main(String args[]) throws IOException{
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entre com o site que deseja obter os recursos:");
        
        String site = in.nextLine();
        //Recurso de autocompletar: Os sites devem começar com http://
        if(site.charAt(0)!= 'h')
            site = "http://"+site;
        System.out.println(site);
        Document doc = null;
        try{
            doc = Jsoup.connect(site).get();
        }
        catch(Exception e){
            e.printStackTrace();
            return;
        }
        
        System.out.println("\nLINKS\n");
        
        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
          String linkHref = link.attr("href");
          String linkText = link.text();
          System.out.println(linkText + " : " + linkHref);
        }
        
        System.out.println("\n\nIMAGENS:\n");
        
        Elements images = doc.getElementsByTag("img");
        for(Element image : images){
            String imgsrc = image.attr("src");
            String imgText = image.text();
            System.out.println(imgsrc);
        }
    
        
    }
}
