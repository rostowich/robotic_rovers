package org.rover.application.validate;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class CommandValidator {

    public boolean validate(List<String> commands){
        if(commands.size()<3 || (commands.size() % 2 == 0))
            return false;
        //Validation of the first line
        Iterator<String> commandIterator = commands.iterator();
        String firstCommand = commandIterator.next();
        String INIT_PLATEAU_PATTERN = "\\s*" + "[1-9]\\d*" + "\\s{1}" + "[1-9]\\d*" + "\\s*";
        if(isNotValid(firstCommand, INIT_PLATEAU_PATTERN))
            return false;
        while (commandIterator.hasNext()){
            String positionCommand = commandIterator.next();
            String INIT_POSITION_PATTERN = "\\s*" + "[1-9]\\d*" + "\\s{1}" + "[1-9]\\d*" + "\\s{1}" + "(E|N|W|S)" + "\\s*";
            if(isNotValid(positionCommand, INIT_POSITION_PATTERN))
                return false;
            String commandForMoving = commandIterator.next();
            String COMMAND_PATTERN = "\\s*" + "(L|R|M)+" + "\\s*";
            if(isNotValid(commandForMoving, COMMAND_PATTERN))
                return false;
        }

        return true;
    }

    private boolean isNotValid(String command, String pattern){
        return !Pattern.compile(pattern)
                .matcher(command)
                .matches();
    }
}
