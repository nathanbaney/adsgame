package game;

import org.hexworks.zircon.api.Components;
import org.hexworks.zircon.api.UIEventResponses;
import org.hexworks.zircon.api.component.Button;
import org.hexworks.zircon.api.component.Component;
import org.hexworks.zircon.api.component.Header;
import org.hexworks.zircon.api.screen.Screen;
import org.hexworks.zircon.api.uievent.MouseEventType;
import org.hexworks.zircon.api.uievent.UIEventResponse;

import java.util.HashSet;
import java.util.Set;

public class MainMenuScreenDrawer extends ScreenDrawer {
    private Set<Component> components;

    public MainMenuScreenDrawer(Screen screen, GameWrangler wrangler){
        super(screen, wrangler);
        components = new HashSet<>();
        addComponents();
    }

    @Override
    public void draw(Screen screen){
    }

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
    }
}
