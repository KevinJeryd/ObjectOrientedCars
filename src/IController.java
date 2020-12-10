//Gör bara en "onButtonClick" som skickar med vilken knapp istället för alla dessa. Gör även att man kan customisea vilka knappar olika kontrollers ska ha kontroll till om man t.ex. vill dela upp eller liknande

import javax.swing.*;
import java.awt.event.ActionEvent;

public interface IController {

    public void onButtonClick(JButton button);


}
