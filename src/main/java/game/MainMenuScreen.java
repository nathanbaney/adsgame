package game;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class MainMenuScreen extends Screen {
    //private Set<Component> components;

    public MainMenuScreen(GameWrangler wrangler){
        super(wrangler);
        //components = new HashSet<>();
        //addComponents();
    }

    @Override
    public void draw(){
    }
    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
/*
    private void addComponents(){
        Header header = Components.header()
                .withPosition(1,4)
                .withText("ANIMAL DISMEMBERMENT SIMULATOR")
                .withTitle("titleHeader")
                .build();
        screen.addComponent(header);
        components.add(header);
        Button startButton = Components.button()
                .withText("start")
                .wrapWithBox(true)
                .withPosition(3, 18)
                .build();
        setStartButtonBehavior(startButton);
        screen.addComponent(startButton);
        components.add(startButton);
    }

    private void setStartButtonBehavior(Button startButton){
        startButton.onMouseEvent(MouseEventType.MOUSE_CLICKED, ((event, phase) -> {
            wrangler.setCurrentScreen(wrangler.playScreen);
            return UIEventResponses.processed();
        }));
    }*/
}
