package org.rover.application;

import org.rover.application.evaluate.RoverController;
import org.rover.application.read.FileCommandReader;
import org.rover.application.validate.CommandValidator;
import org.rover.application.write.ConsolePositionWriter;
import org.rover.domain.api.PositionsProvider;
import org.rover.domain.technical.injectors.DomainDependencyInjector;

public class RoverApplication
{
    public static void main(String[] args) {
        try {
            if(args.length != 1)
                throw new Exception("Invalid number of arguments to run the application");

            RoverController roverController = new RoverController(
                    new FileCommandReader(args[0]),
                    new CommandValidator(),
                    (PositionsProvider) DomainDependencyInjector.getInstance(PositionsProvider.class),
                    new ConsolePositionWriter()
            );

            roverController.evaluateCommand();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
