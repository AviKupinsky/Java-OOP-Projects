import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 * @author Dan Nirel
 */
class ChatterBot {
	static final String REQUEST_PREFIX = "say ";
	static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";
	static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";

	Random rand = new Random();
	String[] IllegalRequest;
	String[] LegalRequest;
	String Name;

	/**
	 * The constructor for ChatterBot
	 * @param Name the name of the ChatterBot
	 * @param repliesToLegalRequest the reply will say for legal request
	 * @param repliesToIllegalRequest the reply will say for illegal request
	 */
	ChatterBot(String Name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {
		this.Name = Name;
		this.IllegalRequest = new String[repliesToIllegalRequest.length];
		for(int i = 0 ; i < repliesToIllegalRequest.length ; i = i+1) {
			this.IllegalRequest[i] = repliesToIllegalRequest[i];
		}
		this.LegalRequest = new String[repliesToLegalRequest.length];
		for(int i = 0; i < repliesToLegalRequest.length; i++) {
			this.LegalRequest[i] = repliesToLegalRequest[i];
			}
	}

	/**
	 * the function reply based on the statement if it's legal or not
	 * @param statement the statement we put in the ChatterBot
	 * @return different if It's legal or not
	 */
	String replyTo(String statement) {
		if(statement.startsWith(REQUEST_PREFIX)) {
			//this means it's a legal request
			return replacePlaceholderInARandomPattern(LegalRequest, REQUESTED_PHRASE_PLACEHOLDER, statement.replaceFirst(REQUEST_PREFIX, ""));
		}
		//this means it's a illegal request
		return replacePlaceholderInARandomPattern(IllegalRequest, ILLEGAL_REQUEST_PLACEHOLDER, statement);
	}

	/**
	 * In this function we choose in a random way what sentence to say and replaces all the empty area's with the
	 * relevant statements
	 * @param replies a String Array with all the Request's relevant
	 * @param replaces or a phrase or request
	 * @param statement the statement we want to put.
	 * @return a statement to reply to the user
	 */
	String replacePlaceholderInARandomPattern(String[] replies, String replaces, String statement){
		int temp = rand.nextInt(replies.length);
		String reply = replies[temp];
		return reply.replaceAll(replaces, statement);
	}

	/**
	 * We get the name for the  ChatterBot
	 * @return the name of the ChatterBot
	 */
	String getName(){
		return this.Name;
	}
}



