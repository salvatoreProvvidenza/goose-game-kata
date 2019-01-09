package goose.game;

public class CommandStrategy {

	public Command run(String command){

		if(command.startsWith("add")){
			return new AddCommand(command);
		} else {
			return new MoveCommand(command);
		}

	}

}
