package sirfireydevs.rana;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sandeep
 */
public class SHOUTcast{

    private String name=null;
    private String id=null;
    private String mt=null;
    private String genre=null;
    private String br=null;
    private String ct=null;
    private String lc=null;
    
    /**
     * 
     * @param devID Your developers id
     * @param limit the no of results to be returned
     * @return An ArrayList contains String arrays those having Element attributes in a order like {name,id,mt,br,genre,ct,lc}
     * 
     */
    public ArrayList<String[]> S_TopSong(String devID,int limit){
        ArrayList<String[]> list=new ArrayList();
        try{
//    File file=new File("");
    String urlString=null;
    urlString="http://api.shoutcast.com/legacy/Top500?k="+devID+"&limit="+String.valueOf(limit);
            
    DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
    URL url=new URL(urlString);
    InputStream ins=url.openStream();
    Document doc=dBuilder.parse(ins);
    doc.getDocumentElement().normalize();
    
    
    NodeList nList=doc.getElementsByTagName("station");
    int i=0;
    for(i=0;i<nList.getLength();i++){
        
        Element element=(Element) nList.item(i);
        
        
        name=element.getAttribute("name");
        id=element.getAttribute("id");
        mt=element.getAttribute("mt");
        br=element.getAttribute("br");
        genre=element.getAttribute("genre");
        ct=element.getAttribute("ct");
        lc=element.getAttribute("lc");
        
        list.add(new String[]{name,id,mt,br,genre,ct,lc});
//        System.out.println("Name="+this.getName()+this.getBr()+this.getCt()+this.getGenre()+this.getId()+this.getLc()+this.getMt());
    }
        
        
    }catch(IOException | ParserConfigurationException | SAXException ex){
        ex.printStackTrace();
    }
    
        return list;
}
    
    
    /**
     * @param searchString Search station name you wants to search
     * @param devID Your developers id
     * @param limit the no of results to be returned
     * @return An ArrayList<String[]> contains String arrays those having Element attributes in a order like {name,id,mt,br,genre,ct,lc}
     * 
     */
    public ArrayList S_SearchSong(String devID,int limit,String searchString){
        ArrayList<String[]> list=new ArrayList();
        try{
//    File file=new File("");
    String urlString=null;
    if(searchString.contains(" ")){
        searchString=searchString.replace(" ", "+");
    }
    urlString="http://api.shoutcast.com/legacy/stationsearch?k="+devID+"&search="+searchString+"&limit="+String.valueOf(limit);
            
    DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
    URL url=new URL(urlString);
    InputStream ins=url.openStream();
    Document doc=dBuilder.parse(ins);
    doc.getDocumentElement().normalize();
//    System.out.println("Root Element :"+doc.getDocumentElement().getNodeName());
//    System.out.println("------------------------------------------------------");
    
    NodeList nList=doc.getElementsByTagName("station");
    int i=0;
    for(i=0;i<nList.getLength();i++){
        
        Element element=(Element) nList.item(i);
        
        
        name=element.getAttribute("name");
        id=element.getAttribute("id");
        mt=element.getAttribute("mt");
        br=element.getAttribute("br");
        genre=element.getAttribute("genre");
        ct=element.getAttribute("ct");
        lc=element.getAttribute("lc");
        
        list.add(new String[]{name,id,mt,br,genre,ct,lc});
        
//        System.out.println("Name="+this.getName()+this.getBr()+this.getCt()+this.getGenre()+this.getId()+this.getLc()+this.getMt());

    }
        
        
    }catch(IOException | ParserConfigurationException | SAXException ex){
        ex.printStackTrace();
    }
    
        return list;
}
    
    
    /**
     * @param genreString Search keywords you wants to search in Genre
     * @param devID Your developers id
     * @param limit the no of results to be returned
     * @return An ArrayList<String[]> object of String arrays those having Element attributes in a order like {name,id,mt,br,genre,ct,lc}
     * 
     */
    public ArrayList S_GenreSong(String devID,int limit,String genreString){
        ArrayList<String[]> list=new ArrayList();
        try{
//    File file=new File("");
    String urlString=null;
    if(genreString.contains(" ")){
        genreString=genreString.replace(" ", "+");
    }
    urlString="http://api.shoutcast.com/legacy/genresearch?k="+devID+"&genre="+genreString+"&limit="+String.valueOf(limit);
            
    DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
    URL url=new URL(urlString);
    InputStream ins=url.openStream();
    Document doc=dBuilder.parse(ins);
    doc.getDocumentElement().normalize();
    System.out.println("Root Element :"+doc.getDocumentElement().getNodeName());
    System.out.println("------------------------------------------------------");
    
    
    NodeList nList=doc.getElementsByTagName("station");
    int i=0;
    for(i=0;i<nList.getLength();i++){
        
        Element element=(Element) nList.item(i);
        
        
        name=element.getAttribute("name");
        id=element.getAttribute("id");
        mt=element.getAttribute("mt");
        br=element.getAttribute("br");
        genre=element.getAttribute("genre");
        ct=element.getAttribute("ct");
        lc=element.getAttribute("lc");
        
         list.add(new String[]{name,id,mt,br,genre,ct,lc});
        
//        System.out.println("Name="+this.getName()+this.getBr()+this.getCt()+this.getGenre()+this.getId()+this.getLc()+this.getMt());

        
        
       
    }
        
        
    }catch(IOException | ParserConfigurationException | SAXException ex){
        ex.printStackTrace();
    }
     return list;
}

    /**
     * @param customString Pass your custom Url String to get desired results
     * @return An ArrayList<String[]> object of String arrays those having Element attributes in a order like {name,id,mt,br,genre,ct,lc}
     * 
     */
    public ArrayList S_Url_Direct(String customString){
    ArrayList<String[]> list=new ArrayList();
    try{
    
    DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
    URL url=new URL(customString);
    InputStream ins=url.openStream();
    Document doc=dBuilder.parse(ins);
    doc.getDocumentElement().normalize();
//    System.out.println("Root Element :"+doc.getDocumentElement().getNodeName());
//    System.out.println("------------------------------------------------------");
    
    NodeList nList=doc.getElementsByTagName("station");
    int i=0;
    for(i=0;i<nList.getLength();i++){
        
        Element element=(Element) nList.item(i);
        
        
        name=element.getAttribute("name");
        id=element.getAttribute("id");
        mt=element.getAttribute("mt");
        br=element.getAttribute("br");
        genre=element.getAttribute("genre");
        ct=element.getAttribute("ct");
        lc=element.getAttribute("lc");
        
        list.add(new String[]{name,id,mt,br,genre,ct,lc});
        
//        System.out.println("Name="+this.getName()+this.getBr()+this.getCt()+this.getGenre()+this.getId()+this.getLc()+this.getMt());

        
        
       
    }
        
        
    }catch(IOException | ParserConfigurationException | SAXException ex){
        ex.printStackTrace();
    }
     return list;
     
}

    /**
     * It returns the name of the Station as a String
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * It returns id of the Station as a String
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * It 
     * @return the mt
     */
    public String getMt() {
        return mt;
    }

    /**
     * It returns the Genre of the Station as a String
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the br
     */
    public String getBr() {
        return br;
    }

    /**
     * @return the ct
     */
    public String getCt() {
        return ct;
    }

    /**
     * @return the lc
     */
    public String getLc() {
        return lc;
    }

}
