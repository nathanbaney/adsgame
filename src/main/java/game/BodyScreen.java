package game;

import java.util.HashSet;
import java.util.Set;

public class BodyScreen extends Screen {


    public BodyScreen(GameWrangler wrangler) {
        super(wrangler);
    }
    @Override
    public void draw(){
        System.out.println("drawing");
    }
    /*private void addComponents() {
        TextBoxBuilder bldr = new TextBoxBuilder();

        header = Components.header()
                .withText("BODY SCREEN")
                .withTitle("titleHeader")
                .build();
        screen.addComponent(header);
        components.add(header);

        headHeader = Components.header()
                .withText("HEAD PARTS:")
                .withTitle("headHeader")
                .withPosition(3, 3)
                .build();
        screen.addComponent(headHeader);
        components.add(headHeader);

        bldr.withPosition(5,4)
                .withContentWidth(35);
                for (int ii = 0; ii < Driver.wrangler.player.headSlots; ii++){
                    if (ii < Driver.wrangler.player.headParts.size()){
                        bldr.addListItem(Driver.wrangler.player.headParts.get(ii).toString());
                    }else{
                        bldr.addListItem("EMPTY SLOT");
                    }
                    bldr.addNewLine();
                }
        headParts = bldr.build();
        screen.addComponent(headParts);
        components.add(headParts);

        torsoHeader = Components.header()
                .withText("TORSO PARTS:")
                .withTitle("torsoHeader")
                .withPosition(3, 8)
                .build();
        screen.addComponent(torsoHeader);
        components.add(torsoHeader);

        bldr = new TextBoxBuilder();
        bldr.withPosition(5,9)
                .withContentWidth(35);
        for (int ii = 0; ii < Driver.wrangler.player.torsoSlots; ii++){
            if (ii < Driver.wrangler.player.torsoParts.size()){
                bldr.addListItem(Driver.wrangler.player.torsoParts.get(ii).toString());
            }else{
                bldr.addListItem("EMPTY SLOT");
            }
            bldr.addNewLine();
        }
        torsoParts = bldr.build();
        screen.addComponent(torsoParts);
        components.add(torsoParts);

        legHeader = Components.header()
                .withText("LEG PARTS:")
                .withTitle("legHeader")
                .withPosition(3, 13)
                .build();
        screen.addComponent(legHeader);
        components.add(legHeader);

        bldr = new TextBoxBuilder();
        bldr.withPosition(5,14)
                .withContentWidth(35);
        for (int ii = 0; ii < Driver.wrangler.player.legSlots; ii++){
            if (ii < Driver.wrangler.player.legParts.size()){
                bldr.addListItem(Driver.wrangler.player.legParts.get(ii).toString());
            }else{
                bldr.addListItem("EMPTY SLOT");
            }
            bldr.addNewLine();
        }
        legParts = bldr.build();
        screen.addComponent(legParts);
        components.add(legParts);
    }
    */
}
