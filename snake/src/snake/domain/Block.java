/**
 * Snake
 *
 * 
 */

package snake.domain;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Sprite
{
	@Override
	public void paint(Graphics2D g2) {
            //Vẽ màu cho vật cản
		g2.setColor(Color.green);
		g2.fillRect(x, y, width, height);
            //Xét biến tọa độ cho, kích thước vật cản
	}
}
