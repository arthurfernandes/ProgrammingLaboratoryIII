
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
public class URLReader {
    
    public enum docTypes{
        HTML5,
        XHTML_1_0_TRANSITIONAL,
        DETECT_AUTOMATICALLY
    }
    
    public static String doGetHttpRequest(String site,docTypes docType){
        String url = "http://validator.w3.org/check?uri="+site;
        
        switch(docType){
            case HTML5:
                url+="%2F&charset=%28detect+automatically%29&doctype=HTML5";
                break;
            case XHTML_1_0_TRANSITIONAL:
                url+="%2F&charset=%28detect+automatically%29&doctype=XHTML+1.0+Transitional";
                break;
            default:
                break;
        }
        
        return url;
    }
    
    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entre com o site que deseja verificar:");
        String site = "";
        try{
            site = in.nextLine();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        docTypes docType = docTypes.DETECT_AUTOMATICALLY;
        int docNumber = 0;
        System.out.println("Entre com o tipo de documento que deseja verificar\n"
                + "0 - DEFAULT\n1- HTML 5\n2- XHTML 1.0 Transitional");
        
        try{
            docNumber = in.nextInt();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        switch(docNumber){
            case 1:
                docType = docTypes.HTML5; break;
            case 2:
                docType = docTypes.XHTML_1_0_TRANSITIONAL; break;
            default:
                break;
        }
        
        Document doc = null;
        try{
            System.out.println(URLReader.doGetHttpRequest(site, docType));
            doc = Jsoup.connect(URLReader.doGetHttpRequest(site, docType)).get();
        }
        
        catch(Exception e){
            e.printStackTrace();
            return;
        }
        
        Elements result = doc.getElementsByClass("valid");
        if(!result.isEmpty()){
            System.out.println("SUCESSO!\n");
            for(Element e : result){
                System.out.println(e.text());
                return;
            }
        }
        else{
            System.out.println("Documento nao foi validado\n");
            result = doc.getElementsByClass("invalid");
            for(Element e : result){
                System.out.println(e.text());
            }
            
            System.out.println("ERROS:");
            
            result = doc.getElementsByClass("msg_err");
            
            for(int i = 0;i<result.size();i++){
                Element e = result.get(i);
                Elements tag = e.getElementsByTag("em");
                Elements msg = e.getElementsByClass("msg");
                if(!(tag.isEmpty() || msg.isEmpty()))
                    System.out.println("Erro "+(i+1)+" - Em: " + tag.get(0).text() + " : " + msg.get(0).text());
                
            }
            
            System.out.println("WARNINGS:");
            
             result = doc.getElementsByClass("msg_warn");
            
            for(int i = 0;i<result.size();i++){
                Element e = result.get(i);
                Elements tag = e.getElementsByTag("em");
                Elements msg = e.getElementsByClass("msg");
                if(!(tag.isEmpty() || msg.isEmpty()))
                    System.out.println("Warning "+(i+1)+" - Em: " + tag.get(0).text() + " : " + msg.get(0).text());
                
            }
        }
        
        
    }
}
