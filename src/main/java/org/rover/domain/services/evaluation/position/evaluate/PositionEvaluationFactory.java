package org.rover.domain.services.evaluation.position.evaluate;


public class PositionEvaluationFactory {
    public MovementEvaluator getPositionEvaluator(String commandType){

        if(commandType.equalsIgnoreCase("L"))
            return new LeftMovementEvaluator();
        else if (commandType.equalsIgnoreCase("R")) {
            return new RightMovementEvaluator();
        } else if (commandType.equalsIgnoreCase("M")) {
            return new MoveMovementEvaluator();
        }else return null;
    }
}
