/**
 * Snake
 *
 * 
 */

package snake.domain;

import java.awt.Color;
import java.awt.Graphics2D;

public class Food extends Sprite
{	
	@Override
	public void paint(Graphics2D g2) {
            //Vẽ màu cho thức ăn cho rắn
		g2.setColor(Color.red);
		g2.fillRect(x, y, width, height);
            //Xét tọa độ, kíhc thước
	}

}
