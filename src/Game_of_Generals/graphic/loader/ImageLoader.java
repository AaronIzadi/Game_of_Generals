package Game_of_Generals.graphic.loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private final BufferedImage board;
    private final BufferedImage pawnWhite, pawnBlack;
    private final BufferedImage bishopWhite, bishopBlack;
    private final BufferedImage goldenGeneralWhite, goldenGeneralBlack;
    private final BufferedImage silverGeneralWhite, silverGeneralBlack;
    private final BufferedImage lanceWhite, lanceBlack;
    private final BufferedImage kingWhite, kingBlack;
    private final BufferedImage startScreen, aboutScreen, whiteWins, blackWins;
    private final BufferedImage icon;
    private final BufferedImage selectIcon;
    private static final ImageLoader instance = new ImageLoader();

    private ImageLoader(){
        this.board = loadImage("/Board.png");
        this.pawnWhite = loadImage("/PawnWhite.png");
        this.pawnBlack = loadImage("/PawnBlack.png");
        this.bishopWhite = loadImage("/BishopWhite.png");
        this.bishopBlack = loadImage("/BishopBlack.png");
        this.goldenGeneralWhite = loadImage("/GoldenGeneralWhite.png");
        this.goldenGeneralBlack = loadImage("/GoldenGeneralBlack.png");
        this.silverGeneralWhite = loadImage("/SilverGeneralWhite.png");
        this.silverGeneralBlack = loadImage("/SilverGeneralBlack.png");
        this.lanceWhite = loadImage("/LanceWhite.png");
        this.lanceBlack = loadImage("/LanceBlack.png");
        this.kingWhite = loadImage("/KingWhite.png");
        this.kingBlack = loadImage("/KingBlack.png");
        this.startScreen = loadImage("/Start.png");
        this.aboutScreen = loadImage("/About.png");
        this.whiteWins = loadImage("/White.png");
        this.blackWins = loadImage("/Black.png");
        this.icon = loadImage("/Icon.png");
        this.selectIcon = pawnWhite;
    }


    public static ImageLoader getInstance() {
        return instance;
    }

    public BufferedImage loadImage(String path) {
        BufferedImage imageToReturn = null;

        try {
            imageToReturn = ImageIO.read(new File("src/resources/media" + path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }

    public BufferedImage getBoard() {
        return board;
    }

    public BufferedImage getPawnWhite() {
        return pawnWhite;
    }

    public BufferedImage getPawnBlack() {
        return pawnBlack;
    }

    public BufferedImage getBishopWhite() {
        return bishopWhite;
    }

    public BufferedImage getBishopBlack() {
        return bishopBlack;
    }

    public BufferedImage getGoldenGeneralWhite() {
        return goldenGeneralWhite;
    }

    public BufferedImage getGoldenGeneralBlack() {
        return goldenGeneralBlack;
    }

    public BufferedImage getSilverGeneralWhite() {
        return silverGeneralWhite;
    }

    public BufferedImage getSilverGeneralBlack() {
        return silverGeneralBlack;
    }

    public BufferedImage getLanceWhite() {
        return lanceWhite;
    }

    public BufferedImage getLanceBlack() {
        return lanceBlack;
    }

    public BufferedImage getKingWhite() {
        return kingWhite;
    }

    public BufferedImage getKingBlack() {
        return kingBlack;
    }

    public BufferedImage getAboutScreen() {
        return aboutScreen;
    }

    public BufferedImage getStartScreen() {
        return startScreen;
    }

    public BufferedImage getBlackWins() {
        return blackWins;
    }

    public BufferedImage getWhiteWins() {
        return whiteWins;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public BufferedImage getSelectIcon() {
        return selectIcon;
    }
}
