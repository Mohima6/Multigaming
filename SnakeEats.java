
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeEats extends JPanel implements ActionListener {
   private final int TILE_SIZE = 10;
   private final int BOARD_SIZE = 300;
   private final int ALL_TILES = 900;
   private final int DELAY = 140;
   private final int[] x = new int[900];
   private final int[] y = new int[900];
   private int snakeLength;
   private int appleX;
   private int appleY;
   private boolean left = false;
   private boolean right = true;
   private boolean up = false;
   private boolean down = false;
   private boolean inGame = true;
   private Timer timer;
   private Random random;

   public SnakeEats() {
      this.initBoard();
   }

   private void initBoard() {
      this.setBackground(Color.BLACK);
      this.setFocusable(true);
      this.setPreferredSize(new Dimension(300, 300));
      this.addKeyListener(new TAdapter(this));
      this.random = new Random();
      this.startGame();
   }

   private void startGame() {
      this.snakeLength = 3;

      for(int i = 0; i < this.snakeLength; ++i) {
         this.x[i] = 50 - i * 10;
         this.y[i] = 50;
      }

      this.placeApple();
      this.timer = new Timer(140, this);
      this.timer.start();
   }

   private void placeApple() {
      this.appleX = this.random.nextInt(30) * 10;
      this.appleY = this.random.nextInt(30) * 10;
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (this.inGame) {
         g.setColor(Color.RED);
         g.fillRect(this.appleX, this.appleY, 10, 10);

         for(int i = 0; i < this.snakeLength; ++i) {
            g.setColor(i == 0 ? Color.GREEN : Color.WHITE);
            g.fillRect(this.x[i], this.y[i], 10, 10);
         }
      } else {
         this.gameOver(g);
      }

   }

   private void gameOver(Graphics g) {
      String msg = "Game Over";
      g.setColor(Color.WHITE);
      g.drawString(msg, 120, 150);
   }

   private void move() {
      for(int i = this.snakeLength; i > 0; --i) {
         this.x[i] = this.x[i - 1];
         this.y[i] = this.y[i - 1];
      }

      int[] var10000;
      if (this.left) {
         var10000 = this.x;
         var10000[0] -= 10;
      }

      if (this.right) {
         var10000 = this.x;
         var10000[0] += 10;
      }

      if (this.up) {
         var10000 = this.y;
         var10000[0] -= 10;
      }

      if (this.down) {
         var10000 = this.y;
         var10000[0] += 10;
      }

   }

   private void checkApple() {
      if (this.x[0] == this.appleX && this.y[0] == this.appleY) {
         ++this.snakeLength;
         this.placeApple();
      }

   }

   private void checkCollision() {
      for(int i = this.snakeLength; i > 0; --i) {
         if (this.x[0] == this.x[i] && this.y[0] == this.y[i]) {
            this.inGame = false;
         }
      }

      if (this.x[0] < 0 || this.x[0] >= 300 || this.y[0] < 0 || this.y[0] >= 300) {
         this.inGame = false;
      }

      if (!this.inGame) {
         this.timer.stop();
      }

   }

   public void actionPerformed(ActionEvent e) {
      if (this.inGame) {
         this.checkApple();
         this.checkCollision();
         this.move();
      }

      this.repaint();
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Snake Game");
      SnakeEats game = new SnakeEats();
      frame.add(game);
      frame.setDefaultCloseOperation(3);
      frame.pack();
      frame.setLocationRelativeTo((Component)null);
      frame.setVisible(true);
   }
}
