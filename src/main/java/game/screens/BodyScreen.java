package game.screens;

import game.Entity;
import game.GameWrangler;
import game.parts.Part;

import java.awt.*;
import java.util.List;

public class BodyScreen extends Screen {

    public Entity currentEntity = wrangler.player;

    public BodyScreen(GameWrangler wrangler) {
        super(wrangler);
    }
    @Override
    public void draw(){
        System.out.println("drawing body screen");
        wrangler.tileGrid.clear();
        int line = 3;
        wrangler.tileGrid.write("BODY PARTS", 3, line++, Color.WHITE, Color.BLUE);
        wrangler.tileGrid.write("HEAD PARTS:", 5, line++, Color.WHITE, Color.BLUE);
        drawPartList(currentEntity.headParts, currentEntity.headSlots, 7, line);
        line += currentEntity.headSlots;
        wrangler.tileGrid.write("TORSO PARTS:", 5, line++, Color.WHITE, Color.BLUE);
        drawPartList(currentEntity.torsoParts, currentEntity.torsoSlots, 7, line);
        line += currentEntity.torsoSlots;
        wrangler.tileGrid.write("LEG PARTS:", 5, line++, Color.WHITE, Color.BLUE);
        drawPartList(currentEntity.legParts, currentEntity.legSlots, 7, line);
        wrangler.tileGrid.repaint();
    }

    public void drawPartList(List<Part> list, int slots, int x, int y){
        for (int ii = 0; ii < slots; ii++){
            if (ii < list.size()){
                wrangler.tileGrid.write(list.get(ii).toString(), x, y + ii);
            }else{
                wrangler.tileGrid.write("EMPTY SLOT", x, y + ii);
            }
        }
    }
}
