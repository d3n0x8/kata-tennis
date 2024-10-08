package katatennis;

public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {

        if (player1Score == player2Score)
            return determineTieState(player1Score);
        else if (player1Score >=4 || player2Score >=4)
            return determineAdvantageOrWin(player1Score, player2Score);
        else
            return generateScoreDisplay(player1Score, player2Score);

    }

    public String determineTieState(int player1Score) {

        switch (player1Score)
        {
            case 0:
                    return "Love-All";
            case 1:
                    return "Fifteen-All";
            case 2:
                    return "Thirty-All";
            default:
                    return  "Deuce";
        }
    }

    public String determineAdvantageOrWin(int player1Score, int player2Score) {
        int minusResult = player1Score-player2Score;

        if (minusResult==1)
            return "Advantage player1";
        else if (minusResult ==-1)
            return "Advantage player2";
        else if (minusResult>=2)
            return "Win for player1";
        else
            return "Win for player2";

    }

    public String generateScoreDisplay(int player1Score, int player2Score){
        String[] scoreDisplay = {
                "Love",
                "Fifteen",
                "Thirty",
                "Forty"
        };

        return scoreDisplay[player1Score] + "-" + scoreDisplay[player2Score];
    }
}