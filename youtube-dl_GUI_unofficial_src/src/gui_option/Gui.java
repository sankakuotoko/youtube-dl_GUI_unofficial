package gui_option;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui extends Frame implements ActionListener,ItemListener {
  static String str;
  
  Panel p1 = new Panel();
  
  Panel p2 = new Panel();
  
  Panel p3 = new Panel();
  
  Panel p4 = new Panel();
  
  Panel p5 = new Panel();
  
  Label l1 = new Label("つべ動画ダウンロードするゾウくん", 1);
  
  static Label l2 = new Label();
  
  Label p1l1 = new Label("URL");
  
  TextField p1t1 = new TextField("https://");
  
  Label p2l1 = new Label("youtube-dlのあるフォルダ");
  
  static TextField p2t1 = new TextField("C:/youtube-dl_support_unofficial");

  Label p3l1= new Label("保存場所");
  
  static TextField p3t1 = new TextField(System.getenv("UserProfile")+"\\Downloads");
  static Checkbox c1 = new Checkbox("音声ダウンロード（ダウンロード速度は変わりません。）");
  Label p4l1 = new Label("（↑をチェックしている場合）音声format");
  static TextField p4t1 = new TextField("best"); 
  static Checkbox c2 = new Checkbox("全フォーマットダウンロード（非推奨）");
  static Checkbox p5c1 = new Checkbox("format指定");
  static TextField p5t1 = new TextField("best+best");
  Button b1 = new Button("GO!");
  
  Button b2 = new Button("EXIT");
  
  private static final long serialVersionUID = 3948634357808722428L;
  
  @SuppressWarnings("deprecation")
Gui() {
    super("test");
    setSize(700, 600);
    setLayout(new GridLayout(10, 1));
    this.l1.setFont(new Font("Cambria", 1, 20));
    this.p1.setLayout(new GridLayout(1, 2));
    this.p1.add(this.p1l1);
    this.p1.add(this.p1t1);
    this.p2.setLayout(new GridLayout(1, 2));
    this.p2.add(this.p2l1);
    this.p2.add(p2t1);
    str = this.p1t1.getText();
    add(this.l1);
    add(this.p1);
    add(this.p2);
    add(l2);
    add(c1);
    p3.setLayout(new GridLayout(1,2));
    //p3.add(p3l1);
    //p3.add(p3t1);
   // add(p3);
    c1.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
		}});
    c1.getState();
    p4.setLayout(new GridLayout(1,2));
    p4.add(p4l1);
    p4.add(p4t1);
    add(p4);
    c2.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}});
    p5t1.disable();
    p5c1.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			p5t1.enable();
			if(p5c1.getState()==false) {p5t1.disable();}
		}});
    p5.add(p5c1);
    p5.add(p5t1);
    add(p5);
    this.b1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Downloader ddd = new Downloader();
            Gui.str = Gui.this.p1t1.getText();
            ddd.commands();
          }
        });
    add(this.b1);
    this.b2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
          }
        });
    add(this.b2);
  }
  
  @SuppressWarnings("deprecation")
public void makegui() {
    show();
  }
  
  public void actionPerformed(ActionEvent arg0) {}

@Override
public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
