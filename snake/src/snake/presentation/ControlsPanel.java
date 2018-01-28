/**
 * Snake
 *
 * 
 */

package snake.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton startButton = new JButton();
	private JSlider blocksSlider = new JSlider();
	private JSlider speedSlider = new JSlider();
	private JSlider sizeSlider = new JSlider();
	private JLabel scoreLabel = new JLabel();
	private JButton helpButton = new JButton();
        private JButton aboutpButton = new JButton();
	private MainPanel panel;
	
	public ControlsPanel(final MainPanel panel)
	{
		this.panel = panel;
		FlowLayout f = new FlowLayout();
		f.setHgap(10);
		this.setLayout(f);
		this.setBorder(new BevelBorder(1));
		
		startButton.setPreferredSize(new Dimension(150, 40));
		startButton.setText("START");
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(panel.isTitle())
				{
					panel.setTitle(false);
					panel.init();
				}
				else if(panel.isGameOver())
					panel.init();
			}
		});
		
		speedSlider.setPreferredSize(new Dimension(60, 40));
		speedSlider.setMinimum(1);
		speedSlider.setMaximum(10);
		speedSlider.setMajorTickSpacing(2);
		speedSlider.setToolTipText("Tốc độ");
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setValue(panel.getSpeed());
		speedSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				panel.setSpeed(speedSlider.getValue());
				startButton.requestFocus();				
			}	
		});

		blocksSlider.setPreferredSize(new Dimension(80, 40));
		blocksSlider.setMinimum(0);
		blocksSlider.setMaximum(60);
		blocksSlider.setMajorTickSpacing(20);
		blocksSlider.setToolTipText("Vật cản");
		blocksSlider.setPaintTicks(true);
		blocksSlider.setPaintLabels(true);
		blocksSlider.setValue(panel.getBlocksNumber());
		blocksSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				panel.setBlocksNumber(blocksSlider.getValue());
				startButton.requestFocus();
			}	
		});

		sizeSlider.setPreferredSize(new Dimension(50, 40));
		sizeSlider.setMinimum(1);
		sizeSlider.setMaximum(3);
		sizeSlider.setMajorTickSpacing(1);
		sizeSlider.setToolTipText("Kích thước");
		sizeSlider.setPaintTicks(true);
		sizeSlider.setPaintLabels(true);
		
		if(panel.getSquareSize() == 5)
			sizeSlider.setValue(1);
		else if(panel.getSquareSize() == 10)
			sizeSlider.setValue(2);
		else if(panel.getSquareSize() == 20)
			sizeSlider.setValue(3);
		else
			throw new IllegalArgumentException("Square size not allowed.");
				
		sizeSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int value;
				if(sizeSlider.getValue() == 1)
					value = 5;
				else if(sizeSlider.getValue() == 2)
					value = 10;
				else
					value = 20;
				
				panel.setSquareSize(value);
				startButton.requestFocus();
			}	
		});
		
		scoreLabel.setPreferredSize(new Dimension(70, 40));
                scoreLabel.setForeground(Color.RED);
		scoreLabel.setText("000");
		scoreLabel.setFont(new Font("Times New Reman", Font.PLAIN, 30));
		
		helpButton.setPreferredSize(new Dimension(55, 40));
		helpButton.setText("Guide");
		helpButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {                        
			    JOptionPane.showMessageDialog(panel,"                              "       
                                    + "Hướng dẫn\n\nGame rắn săn mồi , 2017. All rights reserved.\n"
                                    + "\n           Mau Bao + My Linh + Thuy Trang\n"
                                    + "\n Dùng phím mũi tên để di chuyển con rắn, bạn sẽ được\n"
                                    + "\ncộng 1 điểm khi ăn khối màu đỏ, ăn càng nhiều rắn sẽ \n "
                                    + "\ncàng dài ra.\n"
                                    + "\nBạn chọn tốc độ con rắn, kích thước rắn, số lượng vật cản\n"
                                    + "\n      "
                                    + "\n                    Cách con rắn di chuyển\n"
                                    + "\n                  Up: Di chuyển rắn lên trên\n"
                                    + "\n                  Downs: Di chuyển rắn đi xuống\n"
                                    + "\n                  Left: Di chuyển rắn sang trái\n"
                                    + "\n                  Right: Di chuyển rắn sang phải\n",
                                    "Hướng dẫn...",JOptionPane.PLAIN_MESSAGE);
			}
		});
                aboutpButton.setPreferredSize(new Dimension(55, 40));
		aboutpButton.setText("About");
		aboutpButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {                        
			    JOptionPane.showMessageDialog(panel,"                              "       
                                    + "Snake 1.0\n\nGame rắn săn mồi, 2017. All rights reserved.\n"
                                    + "\n           Mậu Bảo + Mỹ Linh + Thuỳ Trang\n"
                                    + "\n           https://www.facebook.com/mau.bao.77","About...",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		this.add(startButton);
		this.add(speedSlider);
		this.add(blocksSlider);
		this.add(sizeSlider);
		this.add(scoreLabel);
		this.add(helpButton);
                this.add(aboutpButton);
	}
	
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
}
