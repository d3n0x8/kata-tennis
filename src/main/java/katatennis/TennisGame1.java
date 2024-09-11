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
        String score = "";
        int tempScore=0;
        if (player1Score == player2Score)
        {
            score = allAnalyse(player1Score);
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            score = advantageAnalyse(player1Score, player2Score);
        }
        else
        {
            score = regularAnalyse(player1Score, player2Score);
        }
        return score;
    }

    public String allAnalyse(int player1Score) {
        String score;
        switch (player1Score)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }

    public String advantageAnalyse(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score-player2Score;
        if (minusResult==1)
            score = "Advantage player1";
        else if (minusResult ==-1)
            score = "Advantage player2";
        else if (minusResult>=2)
            score = "Win for player1";
        else
            score = "Win for player2";
        return score;
    }

    public String regularAnalyse(int player1Score, int player2Score){
        String score = "";
        int tempScore=0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = player1Score;
            else { score+="-"; tempScore = player2Score;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
}