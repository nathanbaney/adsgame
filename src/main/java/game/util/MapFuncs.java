package game.util;

import game.Tile;
import game.grids.Grid;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MapFuncs {

    public static Set<Character> solidGlyphs = new HashSet<>();

    public static void load(File map, Grid grid){
        parseDocument(parseXML(map, grid), grid);
    }
    private static Document parseXML(File map, Grid grid){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(map);
        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch(SAXException se) {
            se.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return doc;
    }
    private static void parseDocument(Document doc, Grid grid){
        Element docEle = doc.getDocumentElement();
        NodeList rowList = docEle.getElementsByTagName("row");
        if(rowList != null && rowList.getLength() > 0) {
            for(int ii = 0 ; ii < rowList.getLength();ii++) {
                Element tempRow = (Element)rowList.item(ii);
                NodeList cells = tempRow.getElementsByTagName("cell");
                for (int jj = 0; jj < cells.getLength(); jj++){
                    Element tempCell = (Element)cells.item(jj);
                    grid.putTile(jj, ii, makeTileFromElement(tempCell));
                }
            }
        }
    }
    private static Tile makeTileFromElement(Element element){
        char glyph = (char)Integer.parseInt(element.getElementsByTagName("ascii").item(0).getFirstChild().getNodeValue());
        Color foreground = Color.decode(element.getElementsByTagName("fgd").item(0).getFirstChild().getNodeValue());
        Color background = Color.decode(element.getElementsByTagName("bkg").item(0).getFirstChild().getNodeValue());
        return new Tile(glyph, foreground, background, isWalkable(glyph));
    }
    public static boolean isWalkable(char glyph){
        if (solidGlyphs.contains(glyph)){
            return false;
        }else{
            return true;
        }
    }
    public static void initializeSolidGlyphs(){
        for (int ii = 179; ii < 224; ii++){
            solidGlyphs.add((char)ii);
        }
    }
}
