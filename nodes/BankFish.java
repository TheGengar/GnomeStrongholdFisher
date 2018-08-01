package scripts.gnomefisher.nodes;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import scripts.gnomefisher.data.Constants;
import scripts.gnomefisher.data.Methods;
import scripts.gnomefisher.framework.Node;

public class BankFish extends Node{

    @Override
    public void execute() {
        System.out.println("_________________________________________________________________________________________");
        System.out.println("The LeaveBank Node has been Validated! Executing...");

        if (WebWalking.walkTo(Constants.ACTUAL_BANK_TILE)){
            Methods.waitToStopMoving(3000, 3100);
        }

        Banking.openBank();
        Banking.depositAllExcept(Constants.FEATHERS_ID, Constants.FLY_ROD_ID);
        Banking.close();
        System.out.println("_________________________________________________________________________________________");
    }

    @Override
    public boolean validate()  {
        return (Inventory.isFull() &&
                Constants.BANK_AREA.contains(Player.getPosition()));
    }
}


