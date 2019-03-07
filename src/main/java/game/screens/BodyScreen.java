package game.screens;

import game.Entity;
import game.GameWrangler;
import game.actions.Action;
import game.actions.ActionDropPart;
import game.actions.ActionGetPlayScreen;
import game.parts.Part;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BodyScreen extends Screen {

    public Entity currentEntity = wrangler.player;
    public int selectedSlot = 0;

    private Map<Integer, Action> actionMap;
    private int slot;

    public BodyScreen(GameWrangler wrangler) {
        super(wrangler);
        actionMap = new HashMap<>();
        addActions();
    }
    @Override
    public void draw(){
        System.out.println("drawing body screen");
        slot = 1;
        wrangler.tileGrid.clear();
        int line = 3;
        wrangler.tileGrid.write("BODY PARTS FOR " + currentEntity.name.toUpperCase(), 3, line++, Color.WHITE, Color.BLUE);
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
                wrangler.tileGrid.write(slot++ + ": " + list.get(ii).toString(), x, y + ii);
            }else{
                wrangler.tileGrid.write(slot++ +": EMPTY SLOT", x, y + ii);
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        if (actionMap.containsKey(e.getKeyCode())) {
            if (e.getKeyCode() == KeyEvent.VK_NUMPAD1){
                selectedSlot = 1;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2){
                selectedSlot = 2;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3){
                selectedSlot = 3;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4){
                selectedSlot = 4;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5){
                selectedSlot = 5;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6){
                selectedSlot = 6;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7){
                selectedSlot = 7;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8){
                selectedSlot = 8;
            }else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9){
                selectedSlot = 9;
            }
            actionMap.get(e.getKeyCode()).execute(this, currentEntity);
        }else {
            actionMap.get(0).execute(this, currentEntity);
        }
    }
    private void addActions(){
        actionMap.put(KeyEvent.VK_NUMPAD1, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD2, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD3, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD4, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD5, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD6, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD7, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD8, new ActionDropPart());
        actionMap.put(KeyEvent.VK_NUMPAD9, new ActionDropPart());
        actionMap.put(0, new ActionGetPlayScreen());
    }
}
