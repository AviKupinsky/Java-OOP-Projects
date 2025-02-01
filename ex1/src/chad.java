import java.util.Scanner;

class Chat {
    public static void main(String[] args) {
        String[] resposToIligal0 = {"what " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER,
                "say i should say " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER,
                "say what?! ", "say i should say", "what? "};
        String[] resposToIligal1 = {"whaaat " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER,
                "say say "+ ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER,
                "what did you say?? ", "what?? "};
        String[] resposToLigal0 = {"Alright then i will say " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER,
                "here we go, " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER};
        String[] resposToLigal1 = {"no need to shout, gosh... " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER,
                "don't tell me what to say, " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER};
        ChatterBot[] ChatterBotArray = new ChatterBot[2];
        ChatterBotArray[0] = new ChatterBot("Yair", resposToLigal0,resposToIligal0);
        ChatterBotArray[1] = new ChatterBot("Rada",resposToLigal1, resposToIligal1);
        Scanner scanner = new Scanner(System.in);
        String statement = "say";
        for (int i = 0; ; i++){
            statement = ChatterBotArray[i%ChatterBotArray.length].replyTo(statement);
            System.out.println(ChatterBotArray[i%ChatterBotArray.length].getName() + ": " + statement);
            scanner.nextLine();
        }
    }
}